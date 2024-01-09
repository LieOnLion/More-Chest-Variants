package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import io.github.lieonlion.mcv.blocks.MoreTrappedChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoreTrappedChestRenderer extends ChestRenderer<MoreTrappedChestBlockEntity> {
    public static Material[] single = new Material[MoreChestEnum.VALUES.length];
    public static Material[] left = new Material[MoreChestEnum.VALUES.length];
    public static Material[] right = new Material[MoreChestEnum.VALUES.length];

    static {
        for (MoreChestEnum type : MoreChestEnum.VALUES) {
            single[type.ordinal()] = getChestMaterial("trapped/" + type.name());
            left[type.ordinal()] = getChestMaterial("trapped/" + type.name() + "_left");
            right[type.ordinal()] = getChestMaterial("trapped/" + type.name() + "_right");
        }
    }

    public MoreTrappedChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Material getMaterial(MoreTrappedChestBlockEntity blockEntity, ChestType chestType) {
        return getChestMaterial(blockEntity, chestType);
    }

    public static Material chooseMaterial(ChestType type, Material left, Material right, Material single) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
    }

    public static Material getChestMaterial(String path) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(MoreChestVariants.MODID, "entity/chest/" + path));
    }

    private Material getChestMaterial(MoreTrappedChestBlockEntity tile, ChestType type) {
        if (MoreChestRenderer.christmas) {
            return Sheets.chooseMaterial(tile, type, true);
        } else if (MoreChestRenderer.starwarsday) {
            return chooseMaterial(type, getChestMaterial("starwars_left"), getChestMaterial("starwars_right"), getChestMaterial("starwars"));
        } else {
            return chooseMaterial(type, left[tile.getChestType().ordinal()], right[tile.getChestType().ordinal()], single[tile.getChestType().ordinal()]);
        }
    }
}
