package io.github.lieonlion.mcv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.entity.MoreChestBlockEntity;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ChestModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Calendar;

@Environment(EnvType.CLIENT)
public class MoreChestRenderer<T extends ChestBlockEntity> extends ChestRenderer<T> {
    private final ChestModel singleModel;
    private final ChestModel doubleLeftModel;
    private final ChestModel doubleRightModel;
    public static boolean xmasTextures;
    public static boolean starwarsday;

    public MoreChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
        this.singleModel = new ChestModel(context.bakeLayer(ModelLayers.CHEST));
        this.doubleLeftModel = new ChestModel(context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT));
        this.doubleRightModel = new ChestModel(context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT));
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            xmasTextures = true;
        }
        if (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5) {
            starwarsday = true;
        }
    }

    public static Material getChestPath(String path) {
        return new Material(Sheets.CHEST_SHEET, MoreChestVariants.asId("entity/chest/" + path));
    }

    public static Material chooseMaterial(ChestType type, Material left, Material right, Material single) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
    }

    private Material getChestMaterial(T blockEntity, ChestType type) {
        String chestType = ((MoreChestBlock) blockEntity.getBlockState().getBlock()).chestType;
        if (xmasTextures) {
            return Sheets.chooseMaterial(blockEntity, type, true);
        } else if(starwarsday) {
            return chooseMaterial(type, getChestPath("starwars_left"), getChestPath("starwars_right"), getChestPath("starwars"));
        } else {
            return chooseMaterial(type, getChestPath(chestType + "_left"),
                    getChestPath(chestType + "_right"), getChestPath(chestType));
        }
    }

    public void render(T blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        MoreChestVariants.LOGGER.info("Hi");
        Level level = blockEntity.getLevel();
        boolean bl = level != null;
        BlockState blockState = bl ? blockEntity.getBlockState() : Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
        ChestType chestType = blockState.hasProperty(ChestBlock.TYPE) ? blockState.getValue(ChestBlock.TYPE) : ChestType.SINGLE;
        if (blockState.getBlock() instanceof AbstractChestBlock<?> abstractChestBlock) {
            boolean bl2 = chestType != ChestType.SINGLE;
            poseStack.pushPose();
            float g = blockState.getValue(ChestBlock.FACING).toYRot();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(Axis.YP.rotationDegrees(-g));
            poseStack.translate(-0.5F, -0.5F, -0.5F);
            DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> neighborCombineResult;
            if (bl) {
                neighborCombineResult = abstractChestBlock.combine(blockState, level, blockEntity.getBlockPos(), true);
            } else {
                neighborCombineResult = DoubleBlockCombiner.Combiner::acceptNone;
            }

            float h = neighborCombineResult.apply(ChestBlock.opennessCombiner(blockEntity)).get(f);
            h = 1.0F - h;
            h = 1.0F - h * h * h;
            int k = neighborCombineResult.apply(new BrightnessCombiner<>()).applyAsInt(i);
            Material material = getChestMaterial(blockEntity, chestType);
            VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entityCutout);
            if (bl2) {
                if (chestType == ChestType.LEFT) {
                    this.render(poseStack, vertexConsumer, this.doubleLeftModel, h, k, j);
                } else {
                    this.render(poseStack, vertexConsumer, this.doubleRightModel, h, k, j);
                }
            } else {
                this.render(poseStack, vertexConsumer, this.singleModel, h, k, j);
            }

            poseStack.popPose();
        }
    }

    private void render(PoseStack poseStack, VertexConsumer vertexConsumer, ChestModel chestModel, float f, int i, int j) {
        chestModel.setupAnim(f);
        chestModel.renderToBuffer(poseStack, vertexConsumer, i, j);
    }
}