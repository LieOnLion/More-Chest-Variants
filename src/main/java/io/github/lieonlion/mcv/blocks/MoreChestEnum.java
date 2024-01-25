package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.init.blockEntityInit;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;

public enum MoreChestEnum {
      oak,
      spruce,
      birch,
      jungle,
      acacia,
      dark_oak,
      mangrove,
      cherry,
      bamboo,
      crimson,
      warped;

      public static final MoreChestEnum[] VALUES = values();

      public MapColor getMapColour() {
            return switch (this) {
                  case oak -> MapColor.WOOD;
                  case spruce -> MapColor.PODZOL;
                  case birch -> MapColor.SAND;
                  case jungle -> MapColor.DIRT;
                  case acacia -> MapColor.COLOR_ORANGE;
                  case dark_oak -> MapColor.COLOR_BROWN;
                  case mangrove -> MapColor.COLOR_RED;
                  case cherry -> MapColor.TERRACOTTA_WHITE;
                  case bamboo -> MapColor.COLOR_YELLOW;
                  case crimson -> MapColor.CRIMSON_STEM;
                  case warped -> MapColor.WARPED_STEM;
            };
      }

      public BlockEntityType<MoreChestBlockEntity> getChestEntity() {
            return switch (this) {
                  case oak -> blockEntityInit.OAK_CHEST_E.get();
                  case spruce -> blockEntityInit.SPRUCE_CHEST_E.get();
                  case birch -> blockEntityInit.BIRCH_CHEST_E.get();
                  case jungle -> blockEntityInit.JUNGLE_CHEST_E.get();
                  case acacia -> blockEntityInit.ACACIA_CHEST_E.get();
                  case dark_oak -> blockEntityInit.DARK_OAK_CHEST_E.get();
                  case mangrove -> blockEntityInit.MANGROVE_CHEST_E.get();
                  case cherry -> blockEntityInit.CHERRY_CHEST_E.get();
                  case bamboo -> blockEntityInit.BAMBOO_CHEST_E.get();
                  case crimson -> blockEntityInit.CRIMSON_CHEST_E.get();
                  case warped -> blockEntityInit.WARPED_CHEST_E.get();
            };
      }

      public BlockEntityType<MoreTrappedChestBlockEntity> getTRPChestEntity() {
            return switch (this) {
                  case oak -> blockEntityInit.OAK_TPR_CHEST_E.get();
                  case spruce -> blockEntityInit.SPRUCE_TPR_CHEST_E.get();
                  case birch -> blockEntityInit.BIRCH_TPR_CHEST_E.get();
                  case jungle -> blockEntityInit.JUNGLE_TPR_CHEST_E.get();
                  case acacia -> blockEntityInit.ACACIA_TPR_CHEST_E.get();
                  case dark_oak -> blockEntityInit.DARK_OAK_TPR_CHEST_E.get();
                  case mangrove -> blockEntityInit.MANGROVE_TPR_CHEST_E.get();
                  case cherry -> blockEntityInit.CHERRY_TPR_CHEST_E.get();
                  case bamboo -> blockEntityInit.BAMBOO_TPR_CHEST_E.get();
                  case crimson -> blockEntityInit.CRIMSON_TPR_CHEST_E.get();
                  case warped -> blockEntityInit.WARPED_TPR_CHEST_E.get();
            };
      }
}