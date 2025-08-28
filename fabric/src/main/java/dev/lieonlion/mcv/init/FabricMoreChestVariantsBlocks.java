package dev.lieonlion.mcv.init;

import dev.lieonlion.mcv.MoreChestVariants;
import dev.lieonlion.mcv.block.FabricMoreChestBlock;
import dev.lieonlion.mcv.block.FabricMoreTrappedChestBlock;
import dev.lieonlion.mcv.block.MoreChestBlock;
import dev.lieonlion.mcv.block.entity.FabricMoreChestBlockEntity;
import dev.lieonlion.mcv.block.entity.FabricMoreTrappedChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;

public class FabricMoreChestVariantsBlocks {
    public static final FabricMoreChestBlock OAK_CHEST = new FabricMoreChestBlock(MapColor.WOOD, "oak");
    public static final FabricMoreChestBlock SPRUCE_CHEST = new FabricMoreChestBlock(MapColor.PODZOL, "spruce");
    public static final FabricMoreChestBlock BIRCH_CHEST = new FabricMoreChestBlock(MapColor.SAND, "birch");
    public static final FabricMoreChestBlock JUNGLE_CHEST = new FabricMoreChestBlock(MapColor.DIRT, "jungle");
    public static final FabricMoreChestBlock ACACIA_CHEST = new FabricMoreChestBlock(MapColor.COLOR_ORANGE, "acacia");
    public static final FabricMoreChestBlock DARK_OAK_CHEST = new FabricMoreChestBlock(MapColor.COLOR_BROWN, "dark_oak");
    public static final FabricMoreChestBlock MANGROVE_CHEST = new FabricMoreChestBlock(MapColor.COLOR_RED, "mangrove");
    public static final FabricMoreChestBlock CHERRY_CHEST = new FabricMoreChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry");
    public static final FabricMoreChestBlock PALE_OAK_CHEST = new FabricMoreChestBlock(MapColor.QUARTZ, "pale_oak");
    public static final FabricMoreChestBlock BAMBOO_CHEST = new FabricMoreChestBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo");
    public static final FabricMoreChestBlock CRIMSON_CHEST = new FabricMoreChestBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson");
    public static final FabricMoreChestBlock WARPED_CHEST = new FabricMoreChestBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped");

    public static final FabricMoreTrappedChestBlock OAK_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.WOOD, "oak");
    public static final FabricMoreTrappedChestBlock SPRUCE_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.PODZOL, "spruce");
    public static final FabricMoreTrappedChestBlock BIRCH_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.SAND, "birch");
    public static final FabricMoreTrappedChestBlock JUNGLE_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.DIRT, "jungle");
    public static final FabricMoreTrappedChestBlock ACACIA_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.COLOR_ORANGE, "acacia");
    public static final FabricMoreTrappedChestBlock DARK_OAK_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.COLOR_BROWN, "dark_oak");
    public static final FabricMoreTrappedChestBlock MANGROVE_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.COLOR_RED, "mangrove");
    public static final FabricMoreTrappedChestBlock CHERRY_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry");
    public static final FabricMoreTrappedChestBlock PALE_OAK_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.QUARTZ, "pale_oak");
    public static final FabricMoreTrappedChestBlock BAMBOO_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo");
    public static final FabricMoreTrappedChestBlock CRIMSON_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson");
    public static final FabricMoreTrappedChestBlock WARPED_TRAPPED_CHEST = new FabricMoreTrappedChestBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped");

    public static BlockEntityType<FabricMoreChestBlockEntity> MORE_CHEST_BLOCK_ENTITY;
    public static BlockEntityType<FabricMoreTrappedChestBlockEntity> MORE_TRAPPED_CHEST_BLOCK_ENTITY;
    public static final List<Block> more_chest = new ArrayList<>();
    public static final List<Block> more_trapped_chest = new ArrayList<>();

    public static void register() {
        registerBlock(OAK_CHEST, OAK_TRAPPED_CHEST);
        registerBlock(SPRUCE_CHEST, SPRUCE_TRAPPED_CHEST);
        registerBlock(BIRCH_CHEST, BIRCH_TRAPPED_CHEST);
        registerBlock(JUNGLE_CHEST, JUNGLE_TRAPPED_CHEST);
        registerBlock(ACACIA_CHEST, ACACIA_TRAPPED_CHEST);
        registerBlock(DARK_OAK_CHEST, DARK_OAK_TRAPPED_CHEST);
        registerBlock(MANGROVE_CHEST, MANGROVE_TRAPPED_CHEST);
        registerBlock(CHERRY_CHEST, CHERRY_TRAPPED_CHEST);
        registerBlock(PALE_OAK_CHEST, PALE_OAK_TRAPPED_CHEST);
        registerBlock(BAMBOO_CHEST, BAMBOO_TRAPPED_CHEST);
        registerBlock(CRIMSON_CHEST, CRIMSON_TRAPPED_CHEST);
        registerBlock(WARPED_CHEST, WARPED_TRAPPED_CHEST);

        MORE_CHEST_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, "chest_entity",
                FabricBlockEntityTypeBuilder.create(FabricMoreChestBlockEntity::new, more_chest.toArray(Block[]::new)).build());
        MORE_TRAPPED_CHEST_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, "trapped_chest_entity",
                FabricBlockEntityTypeBuilder.create(FabricMoreTrappedChestBlockEntity::new, more_trapped_chest.toArray(Block[]::new)).build());
    }

    private static void registerBlock(MoreChestBlock chest, MoreChestBlock trappedChest) {
        Registry.register(BuiltInRegistries.BLOCK, MoreChestVariants.location(chest.woodType + "_chest"), chest);
        Registry.register(BuiltInRegistries.BLOCK, MoreChestVariants.location(trappedChest.woodType + "_trapped_chest"), trappedChest);
        more_chest.add(chest);
        more_trapped_chest.add(trappedChest);
    }
}
