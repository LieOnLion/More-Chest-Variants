package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.blocks.EnumMoreChest;
import io.github.lieonlion.mcv.tileentities.TileEntityMoreChest;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;

@OnlyIn(Dist.CLIENT)
public class TileEntityMoreChestRenderer extends ChestRenderer<TileEntityMoreChest> {
    public static Material[] single = new Material[EnumMoreChest.VALUES.length];
    public static Material[] left = new Material[EnumMoreChest.VALUES.length];
    public static Material[] right = new Material[EnumMoreChest.VALUES.length];

    static {
        for (EnumMoreChest type : EnumMoreChest.VALUES) {
            single[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH));
            left[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_left");
            right[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_right");
        }
    }

    public TileEntityMoreChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Material getMaterial(TileEntityMoreChest blockEntity, ChestType chestType) {
        return getChestMaterial(blockEntity, chestType);
    }

    private static Material getChestMaterial(String path) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(MoreChestVariants.MODID, "entity/chest/" + path));
    }

    private static Material getChestMaterial(TileEntityMoreChest tile, ChestType type) {
        switch(type) {
            case LEFT:
                return left[tile.getChestType().ordinal()];
            case RIGHT:
                return right[tile.getChestType().ordinal()];
            case SINGLE:
            default:
                return single[tile.getChestType().ordinal()];
        }
    }
}
