package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import io.github.lieonlion.mcv.blocks.MoreChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Calendar;
import java.util.Locale;

@OnlyIn(Dist.CLIENT)
public class MoreChestRenderer extends ChestRenderer<MoreChestBlockEntity> {
    public static Material[] single = new Material[MoreChestEnum.VALUES.length];
    public static Material[] left = new Material[MoreChestEnum.VALUES.length];
    public static Material[] right = new Material[MoreChestEnum.VALUES.length];
    private static boolean christmas;
    private static boolean starwarsday;

    static {
        for (MoreChestEnum type : MoreChestEnum.VALUES) {
            single[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH));
            left[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_left");
            right[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_right");
        }
    }

    public MoreChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
            christmas = true;
        }
        if (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5) {
            starwarsday = true;
        }
    }

    @Override
    protected Material getMaterial(MoreChestBlockEntity blockEntity, ChestType chestType) {
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

    private Material getChestMaterial(MoreChestBlockEntity tile, ChestType type) {
        if (christmas) {
            return Sheets.chooseMaterial(tile, type, christmas);
        } else if (starwarsday) {
            return chooseMaterial(type, getChestMaterial("starwars_left"), getChestMaterial("starwars_right"), getChestMaterial("starwars"));
        } else {
            return chooseMaterial(type, left[tile.getChestType().ordinal()], right[tile.getChestType().ordinal()], single[tile.getChestType().ordinal()]);
        }
    }
}
