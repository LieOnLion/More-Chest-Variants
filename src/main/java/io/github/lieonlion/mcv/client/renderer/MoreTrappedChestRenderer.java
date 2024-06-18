package io.github.lieonlion.mcv.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.entity.MoreTrappedChestBlockEntity;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;

import java.util.Calendar;

@Environment(EnvType.CLIENT)
public class MoreTrappedChestRenderer extends ChestRenderer<MoreTrappedChestBlockEntity> {
    private final ModelPart lid;
    private final ModelPart bottom;
    private final ModelPart lock;
    private final ModelPart doubleLeftLid;
    private final ModelPart doubleLeftBottom;
    private final ModelPart doubleLeftLock;
    private final ModelPart doubleRightLid;
    private final ModelPart doubleRightBottom;
    private final ModelPart doubleRightLock;
    public static boolean christmas;
    public static boolean starwarsday;

    public MoreTrappedChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            christmas = true;
        }
        if (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5) {
            starwarsday = true;
        }

        ModelPart modelPart = context.bakeLayer(ModelLayers.CHEST);
        this.bottom = modelPart.getChild("bottom");
        this.lid = modelPart.getChild("lid");
        this.lock = modelPart.getChild("lock");
        ModelPart modelPart2 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT);
        this.doubleLeftBottom = modelPart2.getChild("bottom");
        this.doubleLeftLid = modelPart2.getChild("lid");
        this.doubleLeftLock = modelPart2.getChild("lock");
        ModelPart modelPart3 = context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT);
        this.doubleRightBottom = modelPart3.getChild("bottom");
        this.doubleRightLid = modelPart3.getChild("lid");
        this.doubleRightLock = modelPart3.getChild("lock");
    }

    public static Material getChestPath(String path) {
        return new Material(Sheets.CHEST_SHEET, MoreChestVariants.asId("entity/chest/trapped/" + path));
    }

    private Material getChestMaterial(MoreTrappedChestBlockEntity blockEntity, ChestType type) {
        if (christmas) {
            return Sheets.chooseMaterial(blockEntity, type, true);
        } else if(starwarsday) {
            return MoreChestRenderer.chooseMaterial(type, getChestPath("starwars_left"), getChestPath("starwars_right"), getChestPath("starwars"));
        } else {
            return MoreChestRenderer.chooseMaterial(type, getChestPath(blockEntity.getBlock().chestType + "_left"),
                    getChestPath(blockEntity.getBlock().chestType + "_right"), getChestPath(blockEntity.getBlock().chestType));
        }
    }

    public void render(MoreTrappedChestBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Level level = blockEntity.getLevel();
        boolean bl = level != null;
        BlockState blockState = bl ? blockEntity.getBlockState() : Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
        ChestType chestType = blockState.hasProperty(ChestBlock.TYPE) ? blockState.getValue(ChestBlock.TYPE) : ChestType.SINGLE;
        Block block = blockState.getBlock();
        if (block instanceof ChestBlock moreChestBlock) {
            boolean bl2 = chestType != ChestType.SINGLE;
            poseStack.pushPose();
            float g = ((Direction)blockState.getValue(ChestBlock.FACING)).toYRot();
            poseStack.translate(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(Axis.YP.rotationDegrees(-g));
            poseStack.translate(-0.5F, -0.5F, -0.5F);
            DoubleBlockCombiner.NeighborCombineResult<? extends ChestBlockEntity> neighborCombineResult;
            if (bl) {
                neighborCombineResult = moreChestBlock.combine(blockState, level, blockEntity.getBlockPos(), true);
            } else {
                neighborCombineResult = DoubleBlockCombiner.Combiner::acceptNone;
            }
            float h = neighborCombineResult.apply(ChestBlock.opennessCombiner(blockEntity)).get(f);
            h = 1.0f - h;
            h = 1.0f - h * h * h;
            int k = ((Int2IntFunction)neighborCombineResult.apply(new BrightnessCombiner())).applyAsInt(i);
            Material material = getChestMaterial(blockEntity, chestType);
            VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entityCutout);
            if (bl2) {
                if (chestType == ChestType.LEFT) {
                    this.render(poseStack, vertexConsumer, this.doubleLeftLid, this.doubleLeftLock, this.doubleLeftBottom, h, k, j);
                } else {
                    this.render(poseStack, vertexConsumer, this.doubleRightLid, this.doubleRightLock, this.doubleRightBottom, h, k, j);
                }
            } else {
                this.render(poseStack, vertexConsumer, this.lid, this.lock, this.bottom, h, k, j);
            }
            poseStack.popPose();
        }
    }

    private void render(PoseStack poseStack, VertexConsumer vertexConsumer, ModelPart modelPart, ModelPart modelPart2, ModelPart modelPart3, float f, int i, int j) {
        modelPart2.xRot = modelPart.xRot = -(f * 1.5707964f);
        modelPart.render(poseStack, vertexConsumer, i, j);
        modelPart2.render(poseStack, vertexConsumer, i, j);
        modelPart3.render(poseStack, vertexConsumer, i, j);
    }
}