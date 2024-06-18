package io.github.lieonlion.mcv.client.renderer;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.entity.MoreTrappedChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoreTrappedChestRenderer extends ChestRenderer<MoreTrappedChestBlockEntity> {

    public MoreTrappedChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Material getMaterial(MoreTrappedChestBlockEntity blockEntity, ChestType chestType) {
        return getChestMaterial(blockEntity, chestType);
    }

    public static Material getChestPath(String path) {
        return new Material(Sheets.CHEST_SHEET, MoreChestVariants.asId("entity/chest/trapped/" + path));
    }

    private Material getChestMaterial(MoreTrappedChestBlockEntity blockEntity, ChestType type) {
        if (MoreChestRenderer.christmas) {
            return Sheets.chooseMaterial(blockEntity, type, true);
        } else if (MoreChestRenderer.starwarsday) {
            return MoreChestRenderer.chooseMaterial(type, MoreChestRenderer.getChestPath("starwars_left"), MoreChestRenderer.getChestPath("starwars_right"), MoreChestRenderer.getChestPath("starwars"));
        } else {
            return MoreChestRenderer.chooseMaterial(type, getChestPath(blockEntity.getBlock().chestType + "_left"),
                    getChestPath(blockEntity.getBlock().chestType + "_right"), getChestPath(blockEntity.getBlock().chestType));
        }
    }
}