package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.blocks.*;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class blockInit {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoreChestVariants.MODID);

    public static final DeferredBlock<MoreChestBlock> OAK_CHEST = BLOCKS.register("oak_chest", () -> new MoreChestBlock(MoreChestEnum.oak));
    public static final DeferredBlock<MoreTrappedChestBlock> OAK_TPR_CHEST = BLOCKS.register("oak_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.oak));

    public static final DeferredBlock<MoreChestBlock> SPRUCE_CHEST = BLOCKS.register("spruce_chest", () -> new MoreChestBlock(MoreChestEnum.spruce));
    public static final DeferredBlock<MoreTrappedChestBlock> SPRUCE_TPR_CHEST = BLOCKS.register("spruce_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.spruce));

    public static final DeferredBlock<MoreChestBlock> BIRCH_CHEST = BLOCKS.register("birch_chest", () -> new MoreChestBlock(MoreChestEnum.birch));
    public static final DeferredBlock<MoreTrappedChestBlock> BIRCH_TPR_CHEST = BLOCKS.register("birch_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.birch));

    public static final DeferredBlock<MoreChestBlock> JUNGLE_CHEST = BLOCKS.register("jungle_chest", () -> new MoreChestBlock(MoreChestEnum.jungle));
    public static final DeferredBlock<MoreTrappedChestBlock> JUNGLE_TPR_CHEST = BLOCKS.register("jungle_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.jungle));

    public static final DeferredBlock<MoreChestBlock> ACACIA_CHEST = BLOCKS.register("acacia_chest", () -> new MoreChestBlock(MoreChestEnum.acacia));
    public static final DeferredBlock<MoreTrappedChestBlock> ACACIA_TPR_CHEST = BLOCKS.register("acacia_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.acacia));

    public static final DeferredBlock<MoreChestBlock> DARK_OAK_CHEST = BLOCKS.register("dark_oak_chest", () -> new MoreChestBlock(MoreChestEnum.dark_oak));
    public static final DeferredBlock<MoreTrappedChestBlock> DARK_OAK_TPR_CHEST = BLOCKS.register("dark_oak_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.dark_oak));

    public static final DeferredBlock<MoreChestBlock> MANGROVE_CHEST = BLOCKS.register("mangrove_chest", () -> new MoreChestBlock(MoreChestEnum.mangrove));
    public static final DeferredBlock<MoreTrappedChestBlock> MANGROVE_TPR_CHEST = BLOCKS.register("mangrove_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.mangrove));

    public static final DeferredBlock<MoreChestBlock> CHERRY_CHEST = BLOCKS.register("cherry_chest", () -> new MoreChestBlock(MoreChestEnum.cherry));
    public static final DeferredBlock<MoreTrappedChestBlock> CHERRY_TPR_CHEST = BLOCKS.register("cherry_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.cherry));

    public static final DeferredBlock<MoreChestBlock> BAMBOO_CHEST = BLOCKS.register("bamboo_chest", () -> new MoreChestBlock(MoreChestEnum.bamboo));
    public static final DeferredBlock<MoreTrappedChestBlock> BAMBOO_TPR_CHEST = BLOCKS.register("bamboo_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.bamboo));

    public static final DeferredBlock<MoreChestBlock> CRIMSON_CHEST = BLOCKS.register("crimson_chest", () -> new MoreChestBlock(MoreChestEnum.crimson));
    public static final DeferredBlock<MoreTrappedChestBlock> CRIMSON_TPR_CHEST = BLOCKS.register("crimson_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.crimson));

    public static final DeferredBlock<MoreChestBlock> WARPED_CHEST = BLOCKS.register("warped_chest", () -> new MoreChestBlock(MoreChestEnum.warped));
    public static final DeferredBlock<MoreTrappedChestBlock> WARPED_TPR_CHEST = BLOCKS.register("warped_trapped_chest", () -> new MoreTrappedChestBlock(MoreChestEnum.warped));

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}