package dev.lieonlion.mcv.init;

import dev.lieonlion.mcv.MoreChestVariants;
import dev.lieonlion.mcv.block.MoreChestBlock;
import dev.lieonlion.mcv.block.NeoForgeMoreChestBlock;
import dev.lieonlion.mcv.block.NeoForgeMoreTrappedChestBlock;
import dev.lieonlion.mcv.block.entity.NeoForgeMoreChestBlockEntity;
import dev.lieonlion.mcv.block.entity.NeoForgeMoreTrappedChestBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NeoForgeMoreChestVariantsBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoreChestVariants.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MoreChestVariants.MOD_ID);

    public static final DeferredBlock<MoreChestBlock> OAK_CHEST = registerChest("oak", () -> new NeoForgeMoreChestBlock(MapColor.WOOD, "oak"));
    public static final DeferredBlock<MoreChestBlock> SPRUCE_CHEST = registerChest("spruce", () -> new NeoForgeMoreChestBlock(MapColor.PODZOL, "spruce"));
    public static final DeferredBlock<MoreChestBlock> BIRCH_CHEST = registerChest("birch", () -> new NeoForgeMoreChestBlock(MapColor.SAND, "birch"));
    public static final DeferredBlock<MoreChestBlock> JUNGLE_CHEST = registerChest("jungle", () -> new NeoForgeMoreChestBlock(MapColor.DIRT, "jungle"));
    public static final DeferredBlock<MoreChestBlock> ACACIA_CHEST = registerChest("acacia", () -> new NeoForgeMoreChestBlock(MapColor.COLOR_ORANGE, "acacia"));
    public static final DeferredBlock<MoreChestBlock> DARK_OAK_CHEST = registerChest("dark_oak", () -> new NeoForgeMoreChestBlock(MapColor.COLOR_BROWN, "dark_oak"));
    public static final DeferredBlock<MoreChestBlock> MANGROVE_CHEST = registerChest("mangrove", () -> new NeoForgeMoreChestBlock(MapColor.COLOR_RED, "mangrove"));
    public static final DeferredBlock<MoreChestBlock> CHERRY_CHEST = registerChest("cherry", () -> new NeoForgeMoreChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry"));
    public static final DeferredBlock<MoreChestBlock> PALE_OAK_CHEST = registerChest("pale_oak", () -> new NeoForgeMoreChestBlock(MapColor.QUARTZ, "pale_oak"));
    public static final DeferredBlock<MoreChestBlock> BAMBOO_CHEST = registerChest("bamboo", () -> new NeoForgeMoreChestBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo"));
    public static final DeferredBlock<MoreChestBlock> CRIMSON_CHEST = registerChest("crimson", () -> new NeoForgeMoreChestBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson"));
    public static final DeferredBlock<MoreChestBlock> WARPED_CHEST = registerChest("warped", () -> new NeoForgeMoreChestBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped"));

    public static final DeferredBlock<MoreChestBlock> OAK_TRAPPED_CHEST = registerChest("oak_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.WOOD, "oak"));
    public static final DeferredBlock<MoreChestBlock> SPRUCE_TRAPPED_CHEST = registerChest("spruce_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.PODZOL, "spruce"));
    public static final DeferredBlock<MoreChestBlock> BIRCH_TRAPPED_CHEST = registerChest("birch_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.SAND, "birch"));
    public static final DeferredBlock<MoreChestBlock> JUNGLE_TRAPPED_CHEST = registerChest("jungle_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.DIRT, "jungle"));
    public static final DeferredBlock<MoreChestBlock> ACACIA_TRAPPED_CHEST = registerChest("acacia_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.COLOR_ORANGE, "acacia"));
    public static final DeferredBlock<MoreChestBlock> DARK_OAK_TRAPPED_CHEST = registerChest("dark_oak_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.COLOR_BROWN, "dark_oak"));
    public static final DeferredBlock<MoreChestBlock> MANGROVE_TRAPPED_CHEST = registerChest("mangrove_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.COLOR_RED, "mangrove"));
    public static final DeferredBlock<MoreChestBlock> CHERRY_TRAPPED_CHEST = registerChest("cherry_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry"));
    public static final DeferredBlock<MoreChestBlock> PALE_OAK_TRAPPED_CHEST = registerChest("pale_oak_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.QUARTZ, "pale_oak"));
    public static final DeferredBlock<MoreChestBlock> BAMBOO_TRAPPED_CHEST = registerChest("bamboo_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo"));
    public static final DeferredBlock<MoreChestBlock> CRIMSON_TRAPPED_CHEST = registerChest("crimson_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson"));
    public static final DeferredBlock<MoreChestBlock> WARPED_TRAPPED_CHEST = registerChest("warped_trapped", () -> new NeoForgeMoreTrappedChestBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped"));

    public static Supplier<BlockEntityType<NeoForgeMoreChestBlockEntity>> MORE_CHEST_BLOCK_ENTITY;
    public static Supplier<BlockEntityType<NeoForgeMoreTrappedChestBlockEntity>> MORE_TRAPPED_CHEST_BLOCK_ENTITY;
    public static final List<DeferredBlock<MoreChestBlock>> more_chest = new ArrayList<>();
    public static final List<DeferredBlock<MoreChestBlock>> more_trapped_chest = new ArrayList<>();

    public static void register(IEventBus modBus) {
        addToArray(OAK_CHEST, OAK_TRAPPED_CHEST);
        addToArray(SPRUCE_CHEST, SPRUCE_TRAPPED_CHEST);
        addToArray(BIRCH_CHEST, BIRCH_TRAPPED_CHEST);
        addToArray(JUNGLE_CHEST, JUNGLE_TRAPPED_CHEST);
        addToArray(ACACIA_CHEST, ACACIA_TRAPPED_CHEST);
        addToArray(DARK_OAK_CHEST, DARK_OAK_TRAPPED_CHEST);
        addToArray(MANGROVE_CHEST, MANGROVE_TRAPPED_CHEST);
        addToArray(CHERRY_CHEST, CHERRY_TRAPPED_CHEST);
        addToArray(PALE_OAK_CHEST, PALE_OAK_TRAPPED_CHEST);
        addToArray(BAMBOO_CHEST, BAMBOO_TRAPPED_CHEST);
        addToArray(CRIMSON_CHEST, CRIMSON_TRAPPED_CHEST);
        addToArray(WARPED_CHEST, WARPED_TRAPPED_CHEST);

        MORE_CHEST_BLOCK_ENTITY = BLOCKS_ENTITIES.register("chest_tile",
                () -> new BlockEntityType<>(NeoForgeMoreChestBlockEntity::new, more_chest.stream().map(DeferredBlock::get).toArray(Block[]::new)));
        MORE_TRAPPED_CHEST_BLOCK_ENTITY = BLOCKS_ENTITIES.register("trapped_chest_tile",
                () -> new BlockEntityType<>(NeoForgeMoreTrappedChestBlockEntity::new, more_trapped_chest.stream().map(DeferredBlock::get).toArray(Block[]::new)));

        BLOCKS.register(modBus);
        BLOCKS_ENTITIES.register(modBus);
    }

    private static DeferredBlock<MoreChestBlock> registerChest(String name, Supplier<MoreChestBlock> block) {
        return BLOCKS.register(name + "_chest", block);
    }

    private static void addToArray(DeferredBlock<MoreChestBlock> chest, DeferredBlock<MoreChestBlock> trappedChest) {
        more_chest.add(chest);
        more_trapped_chest.add(trappedChest);
    }
}