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
      WARPED,
      FIR,
      REDWOOD,
      MAHOGANY,
      JACARANDA,
      PALM,
      WILLOW,
      DEAD,
      MAGIC,
      UMBRAN,
      HELLBARK;

      public static final MoreChestEnum[] VALUES = values();

      public String getId() {
            return new String(this.name().toLowerCase() + "_chest");
      }

      public Boolean getCanBurn() {
            return switch (this) {
                  default -> true;
                  case CRIMSON, WARPED -> false;
            };
      }

      public MapColor getMapColour() {
            return switch (this) {
                  case SPRUCE -> MapColor.PODZOL;
                  case BIRCH -> MapColor.SAND;
                  case JUNGLE -> MapColor.DIRT;
                  case ACACIA -> MapColor.COLOR_ORANGE;
                  case DARK_OAK -> MapColor.COLOR_BROWN;
                  case MANGROVE -> MapColor.COLOR_RED;
                  case CHERRY, FIR -> MapColor.TERRACOTTA_WHITE;
                  case BAMBOO -> MapColor.COLOR_YELLOW;
                  case CRIMSON -> MapColor.CRIMSON_STEM;
                  case WARPED -> MapColor.WARPED_STEM;
                  case REDWOOD -> MapColor.TERRACOTTA_ORANGE;
                  case MAHOGANY -> MapColor.TERRACOTTA_PINK;
                  case JACARANDA -> MapColor.QUARTZ;
                  case PALM -> MapColor.TERRACOTTA_YELLOW;
                  case WILLOW -> MapColor.TERRACOTTA_LIGHT_GREEN;
                  case DEAD -> MapColor.STONE;
                  case MAGIC -> MapColor.COLOR_BLUE;
                  case UMBRAN -> MapColor.TERRACOTTA_BLUE;
                  case HELLBARK -> MapColor.TERRACOTTA_GRAY;
            };
      }
}