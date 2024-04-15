package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreTrappedChestBlock;
import io.github.lieonlion.mcv.block.entity.MoreChestBlockEntity;
import io.github.lieonlion.mcv.block.entity.MoreTrappedChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class McvBlockInit {
    public static final MoreChestBlock OAK_CHEST = new MoreChestBlock(MapColor.OAK_TAN, "oak");
    public static final MoreChestBlock SPRUCE_CHEST = new MoreChestBlock(MapColor.SPRUCE_BROWN, "spruce");
    public static final MoreChestBlock BIRCH_CHEST = new MoreChestBlock(MapColor.PALE_YELLOW, "birch");
    public static final MoreChestBlock JUNGLE_CHEST = new MoreChestBlock(MapColor.DIRT_BROWN, "jungle");
    public static final MoreChestBlock ACACIA_CHEST = new MoreChestBlock(MapColor.ORANGE, "acacia");
    public static final MoreChestBlock DARK_OAK_CHEST = new MoreChestBlock(MapColor.BROWN, "dark_oak");
    public static final MoreChestBlock MANGROVE_CHEST = new MoreChestBlock(MapColor.RED, "mangrove");
    public static final MoreChestBlock CHERRY_CHEST = new MoreChestBlock(MapColor.TERRACOTTA_WHITE, BlockSoundGroup.CHERRY_WOOD, "cherry");
    public static final MoreChestBlock BAMBOO_CHEST = new MoreChestBlock(MapColor.YELLOW, BlockSoundGroup.BAMBOO_WOOD, "bamboo");
    public static final MoreChestBlock CRIMSON_CHEST = new MoreChestBlock(MapColor.DULL_PINK, BlockSoundGroup.NETHER_WOOD, "crimson");
    public static final MoreChestBlock WARPED_CHEST = new MoreChestBlock(MapColor.DARK_AQUA, BlockSoundGroup.NETHER_WOOD, "warped");

    public static final MoreTrappedChestBlock OAK_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.OAK_TAN, "oak");
    public static final MoreTrappedChestBlock SPRUCE_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.SPRUCE_BROWN, "spruce");
    public static final MoreTrappedChestBlock BIRCH_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.PALE_YELLOW, "birch");
    public static final MoreTrappedChestBlock JUNGLE_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.DIRT_BROWN, "jungle");
    public static final MoreTrappedChestBlock ACACIA_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.ORANGE, "acacia");
    public static final MoreTrappedChestBlock DARK_OAK_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.BROWN, "dark_oak");
    public static final MoreTrappedChestBlock MANGROVE_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.RED, "mangrove");
    public static final MoreTrappedChestBlock CHERRY_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.TERRACOTTA_WHITE, BlockSoundGroup.CHERRY_WOOD, "cherry");
    public static final MoreTrappedChestBlock BAMBOO_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.YELLOW, BlockSoundGroup.BAMBOO_WOOD, "bamboo");
    public static final MoreTrappedChestBlock CRIMSON_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.DULL_PINK, BlockSoundGroup.NETHER_WOOD, "crimson");
    public static final MoreTrappedChestBlock WARPED_TRAPPED_CHEST = new MoreTrappedChestBlock(MapColor.DARK_AQUA, BlockSoundGroup.NETHER_WOOD, "warped");

    public static BlockEntityType<MoreChestBlockEntity> MORE_CHEST_BLOCK_ENTITY;
    public static BlockEntityType<MoreTrappedChestBlockEntity> MORE_TRAPPED_CHEST_BLOCK_ENTITY;
    public static final List<Block> more_chest = new ArrayList<>();
    public static final List<Block> more_trapped_chest = new ArrayList<>();

    public static void registerBlocks() {
        registerBlock("oak", OAK_CHEST, OAK_TRAPPED_CHEST);
        registerBlock("spruce", SPRUCE_CHEST, SPRUCE_TRAPPED_CHEST);
        registerBlock("birch", BIRCH_CHEST, BIRCH_TRAPPED_CHEST);
        registerBlock("jungle", JUNGLE_CHEST, JUNGLE_TRAPPED_CHEST);
        registerBlock("acacia", ACACIA_CHEST, ACACIA_TRAPPED_CHEST);
        registerBlock("dark_oak", DARK_OAK_CHEST, DARK_OAK_TRAPPED_CHEST);
        registerBlock("mangrove", MANGROVE_CHEST, MANGROVE_TRAPPED_CHEST);
        registerBlock("cherry", CHERRY_CHEST, CHERRY_TRAPPED_CHEST);
        registerBlock("bamboo", BAMBOO_CHEST, BAMBOO_TRAPPED_CHEST);
        registerBlock("crimson", CRIMSON_CHEST, CRIMSON_TRAPPED_CHEST);
        registerBlock("warped", WARPED_CHEST, WARPED_TRAPPED_CHEST);

        MORE_CHEST_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, "chest_entity",
                FabricBlockEntityTypeBuilder.create(MoreChestBlockEntity::new, more_chest.toArray(Block[]::new)).build());
        MORE_TRAPPED_CHEST_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, "trapped_chest_entity",
                FabricBlockEntityTypeBuilder.create(MoreTrappedChestBlockEntity::new, more_trapped_chest.toArray(Block[]::new)).build());
    }

    private static void registerBlock(String name, Block chest, Block trappedChest) {
        Registry.register(Registries.BLOCK, new Identifier(MoreChestVariants.MODID, name + "_chest"), chest);
        Registry.register(Registries.BLOCK, new Identifier(MoreChestVariants.MODID, name + "_trapped_chest"), trappedChest);
        more_chest.add(chest);
        more_trapped_chest.add(trappedChest);
    }
}