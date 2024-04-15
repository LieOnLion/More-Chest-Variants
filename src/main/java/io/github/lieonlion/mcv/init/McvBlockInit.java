package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreTrappedChestBlock;
import io.github.lieonlion.mcv.block.entity.MoreChestBlockEntity;
import io.github.lieonlion.mcv.block.entity.MoreTrappedChestBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class McvBlockInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChestVariants.MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoreChestVariants.MODID);

    public static final RegistryObject<Block> OAK_CHEST = registerChest("oak", () -> new MoreChestBlock(MapColor.WOOD, "oak"));
    public static final RegistryObject<Block> SPRUCE_CHEST = registerChest("spruce", () -> new MoreChestBlock(MapColor.PODZOL, "spruce"));
    public static final RegistryObject<Block> BIRCH_CHEST = registerChest("birch", () -> new MoreChestBlock(MapColor.SAND, "birch"));
    public static final RegistryObject<Block> JUNGLE_CHEST = registerChest("jungle", () -> new MoreChestBlock(MapColor.DIRT, "jungle"));
    public static final RegistryObject<Block> ACACIA_CHEST = registerChest("acacia", () -> new MoreChestBlock(MapColor.COLOR_ORANGE, "acacia"));
    public static final RegistryObject<Block> DARK_OAK_CHEST = registerChest("dark_oak", () -> new MoreChestBlock(MapColor.COLOR_BROWN, "dark_oak"));
    public static final RegistryObject<Block> MANGROVE_CHEST = registerChest("mangrove", () -> new MoreChestBlock(MapColor.COLOR_RED, "mangrove"));
    public static final RegistryObject<Block> CHERRY_CHEST = registerChest("cherry", () -> new MoreChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry"));
    public static final RegistryObject<Block> BAMBOO_CHEST = registerChest("bamboo", () -> new MoreChestBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo"));
    public static final RegistryObject<Block> CRIMSON_CHEST = registerChest("crimson", () -> new MoreChestBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson"));
    public static final RegistryObject<Block> WARPED_CHEST = registerChest("warped", () -> new MoreChestBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped"));

    public static final RegistryObject<Block> OAK_TRAPPED_CHEST = registerChest("oak_trapped", () -> new MoreTrappedChestBlock(MapColor.WOOD, "oak"));
    public static final RegistryObject<Block> SPRUCE_TRAPPED_CHEST = registerChest("spruce_trapped", () -> new MoreTrappedChestBlock(MapColor.PODZOL, "spruce"));
    public static final RegistryObject<Block> BIRCH_TRAPPED_CHEST = registerChest("birch_trapped", () -> new MoreTrappedChestBlock(MapColor.SAND, "birch"));
    public static final RegistryObject<Block> JUNGLE_TRAPPED_CHEST = registerChest("jungle_trapped", () -> new MoreTrappedChestBlock(MapColor.DIRT, "jungle"));
    public static final RegistryObject<Block> ACACIA_TRAPPED_CHEST = registerChest("acacia_trapped", () -> new MoreTrappedChestBlock(MapColor.COLOR_ORANGE, "acacia"));
    public static final RegistryObject<Block> DARK_OAK_TRAPPED_CHEST = registerChest("dark_oak_trapped", () -> new MoreTrappedChestBlock(MapColor.COLOR_BROWN, "dark_oak"));
    public static final RegistryObject<Block> MANGROVE_TRAPPED_CHEST = registerChest("mangrove_trapped", () -> new MoreTrappedChestBlock(MapColor.COLOR_RED, "mangrove"));
    public static final RegistryObject<Block> CHERRY_TRAPPED_CHEST = registerChest("cherry_trapped", () -> new MoreTrappedChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry"));
    public static final RegistryObject<Block> BAMBOO_TRAPPED_CHEST = registerChest("bamboo_trapped", () -> new MoreTrappedChestBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo"));
    public static final RegistryObject<Block> CRIMSON_TRAPPED_CHEST = registerChest("crimson_trapped", () -> new MoreTrappedChestBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson"));
    public static final RegistryObject<Block> WARPED_TRAPPED_CHEST = registerChest("warped_trapped", () -> new MoreTrappedChestBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped"));

    public static RegistryObject<BlockEntityType<MoreChestBlockEntity>> MORE_CHEST_BLOCK_ENTITY;
    public static RegistryObject<BlockEntityType<MoreTrappedChestBlockEntity>> MORE_TRAPPED_CHEST_BLOCK_ENTITY;
    public static final List<RegistryObject<Block>> more_chest = new ArrayList<>();
    public static final List<RegistryObject<Block>> more_trapped_chest = new ArrayList<>();

    public static void registerBlocks(IEventBus modBus) {
        addToArray(OAK_CHEST, OAK_TRAPPED_CHEST);
        addToArray(SPRUCE_CHEST, SPRUCE_TRAPPED_CHEST);
        addToArray(BIRCH_CHEST, BIRCH_TRAPPED_CHEST);
        addToArray(JUNGLE_CHEST, JUNGLE_TRAPPED_CHEST);
        addToArray(ACACIA_CHEST, ACACIA_TRAPPED_CHEST);
        addToArray(DARK_OAK_CHEST, DARK_OAK_TRAPPED_CHEST);
        addToArray(MANGROVE_CHEST, MANGROVE_TRAPPED_CHEST);
        addToArray(CHERRY_CHEST, CHERRY_TRAPPED_CHEST);
        addToArray(BAMBOO_CHEST, BAMBOO_TRAPPED_CHEST);
        addToArray(CRIMSON_CHEST, CRIMSON_TRAPPED_CHEST);
        addToArray(WARPED_CHEST, WARPED_TRAPPED_CHEST);

        MORE_CHEST_BLOCK_ENTITY = BLOCKS_ENTITIES.register("chest_tile",
                () -> BlockEntityType.Builder.of(MoreChestBlockEntity::new, more_chest.stream().map(RegistryObject::get).toArray(Block[]::new)).build(null));
        MORE_TRAPPED_CHEST_BLOCK_ENTITY = BLOCKS_ENTITIES.register("trapped_chest_tile",
                () -> BlockEntityType.Builder.of(MoreTrappedChestBlockEntity::new, more_trapped_chest.stream().map(RegistryObject::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(modBus);
        BLOCKS_ENTITIES.register(modBus);
    }

    private static RegistryObject<Block> registerChest(String name, Supplier<Block> block) {
        return BLOCKS.register(name + "_chest", block);
    }

    private static void addToArray(RegistryObject<Block> chest, RegistryObject<Block> trappedChest) {
        more_chest.add(chest);
        more_trapped_chest.add(trappedChest);
    }
}