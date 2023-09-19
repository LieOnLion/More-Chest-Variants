package io.github.lieonlion.mcv.blocks;

import net.minecraft.world.level.material.MapColor;

public enum MoreChestEnum {
      SPRUCE,
      BIRCH,
      JUNGLE,
      ACACIA,
      DARK_OAK,
      MANGROVE,
      CHERRY,
      BAMBOO,
      CRIMSON,
      WARPED;

      public static final MoreChestEnum[] VALUES = values();

      public String getId() {
            return this.name().toLowerCase() + "_chest";
      }

      public MapColor getMapColour() {
            return switch (this) {
                  case SPRUCE -> MapColor.PODZOL;
                  case BIRCH -> MapColor.SAND;
                  case JUNGLE -> MapColor.DIRT;
                  case ACACIA -> MapColor.COLOR_ORANGE;
                  case DARK_OAK -> MapColor.COLOR_BROWN;
                  case MANGROVE -> MapColor.COLOR_RED;
                  case CHERRY -> MapColor.TERRACOTTA_WHITE;
                  case BAMBOO -> MapColor.COLOR_YELLOW;
                  case CRIMSON -> MapColor.CRIMSON_STEM;
                  case WARPED -> MapColor.WARPED_STEM;
            };
      }
}