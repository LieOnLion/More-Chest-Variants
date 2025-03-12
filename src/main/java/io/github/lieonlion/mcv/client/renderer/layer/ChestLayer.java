package io.github.lieonlion.mcv.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.util.IChestEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.HashMap;

public abstract class ChestLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    /*
        Big thanks to Khajiitos for the code for this to work, taken from Chested Companions.

        Go check it out! :)
        https://github.com/Khajiitos/ChestedCompanions/
        https://www.curseforge.com/minecraft/mc-mods/chested-companions
        https://modrinth.com/mod/chested-companions
    */
    protected static final float HALF_PI = (float)Math.PI / 2.f;
    private static final ResourceLocation BASE_CHEST_LOCATION = MoreChestVariants.asId("textures/chest/chest.png");
    private static final HashMap<Item, ResourceLocation> CHEST_TEXTURES = new HashMap<>();

    private final ModelPart chestModel;

    private static ResourceLocation getResourceLocation(@Nullable ItemStack chestItem) {
        if (chestItem == null) {
            return BASE_CHEST_LOCATION;
        }

        if (!CHEST_TEXTURES.containsKey(chestItem.getItem())) {
            ResourceLocation itemLocation = BuiltInRegistries.ITEM.getKey(chestItem.getItem());

            ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(itemLocation.getNamespace(), "textures/chest/" + itemLocation.getPath() + ".png");
            if (Minecraft.getInstance().getResourceManager().getResource(texture).isPresent()) {
                CHEST_TEXTURES.put(chestItem.getItem(), texture);
            } else {
                CHEST_TEXTURES.put(chestItem.getItem(), BASE_CHEST_LOCATION);
                return BASE_CHEST_LOCATION;
            }
            return texture;
        } else {
            return CHEST_TEXTURES.get(chestItem.getItem());
        }
    }

    protected abstract Vector3f positionChests();

    public ChestLayer(RenderLayerParent<T, M> renderLayerParent) {
        super(renderLayerParent);

        PartDefinition partDefinition = new MeshDefinition().getRoot();
        CubeListBuilder cubeListBuilder = CubeListBuilder.create().texOffs(0, 0).addBox(-4, 0, -2, 8, 8, 3);
        partDefinition.addOrReplaceChild("left_chest", cubeListBuilder,
                PartPose.offsetAndRotation(
                        positionChests().x, positionChests().y, positionChests().z,
                        0, -HALF_PI, 0));
        partDefinition.addOrReplaceChild("right_chest", cubeListBuilder,
                PartPose.offsetAndRotation(
                        -positionChests().x, positionChests().y, positionChests().z,
                        0, HALF_PI, 0));

        this.chestModel = partDefinition.bake(22, 11);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T entity, float f, float g, float h, float j, float k, float l) {
        if (!(entity instanceof IChestEntity chestEntity) || !chestEntity.mcv$hasChestItemStack()) {
            return;
        }

        chestModel.render(poseStack, multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(getResourceLocation(chestEntity.mcv$getChestItemStack()))), i, LivingEntityRenderer.getOverlayCoords(entity, 0.f));
    }
}
