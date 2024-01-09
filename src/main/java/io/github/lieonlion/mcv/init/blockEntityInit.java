package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.blocks.MoreChestBlockEntity;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import io.github.lieonlion.mcv.blocks.MoreTrappedChestBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class blockEntityInit {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MoreChestVariants.MODID);

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> OAK_CHEST_E =
            BLOCK_ENTITIES.register("oak_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.oak, pos, state),
                        blockInit.OAK_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> OAK_TPR_CHEST_E =
            BLOCK_ENTITIES.register("oak_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.oak, pos, state),
                            blockInit.OAK_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> SPRUCE_CHEST_E =
            BLOCK_ENTITIES.register("spruce_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.spruce, pos, state),
                            blockInit.SPRUCE_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> SPRUCE_TPR_CHEST_E =
            BLOCK_ENTITIES.register("spruce_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.spruce, pos, state),
                            blockInit.SPRUCE_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> BIRCH_CHEST_E =
            BLOCK_ENTITIES.register("birch_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.birch, pos, state),
                            blockInit.BIRCH_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> BIRCH_TPR_CHEST_E =
            BLOCK_ENTITIES.register("birch_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.birch, pos, state),
                            blockInit.BIRCH_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> JUNGLE_CHEST_E =
            BLOCK_ENTITIES.register("jungle_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.jungle, pos, state),
                            blockInit.JUNGLE_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> JUNGLE_TPR_CHEST_E =
            BLOCK_ENTITIES.register("jungle_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.jungle, pos, state),
                            blockInit.JUNGLE_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> ACACIA_CHEST_E =
            BLOCK_ENTITIES.register("acacia_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.acacia, pos, state),
                            blockInit.ACACIA_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> ACACIA_TPR_CHEST_E =
            BLOCK_ENTITIES.register("acacia_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.acacia, pos, state),
                            blockInit.ACACIA_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> DARK_OAK_CHEST_E =
            BLOCK_ENTITIES.register("dark_oak_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.dark_oak, pos, state),
                            blockInit.DARK_OAK_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> DARK_OAK_TPR_CHEST_E =
            BLOCK_ENTITIES.register("dark_oak_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.dark_oak, pos, state),
                            blockInit.DARK_OAK_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> MANGROVE_CHEST_E =
            BLOCK_ENTITIES.register("mangrove_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.mangrove, pos, state),
                            blockInit.MANGROVE_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> MANGROVE_TPR_CHEST_E =
            BLOCK_ENTITIES.register("mangrove_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.mangrove, pos, state),
                            blockInit.MANGROVE_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> CHERRY_CHEST_E =
            BLOCK_ENTITIES.register("cherry_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.cherry, pos, state),
                            blockInit.CHERRY_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> CHERRY_TPR_CHEST_E =
            BLOCK_ENTITIES.register("cherry_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.cherry, pos, state),
                            blockInit.CHERRY_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> BAMBOO_CHEST_E =
            BLOCK_ENTITIES.register("bamboo_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.bamboo, pos, state),
                            blockInit.BAMBOO_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> BAMBOO_TPR_CHEST_E =
            BLOCK_ENTITIES.register("bamboo_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.bamboo, pos, state),
                            blockInit.BAMBOO_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> CRIMSON_CHEST_E =
            BLOCK_ENTITIES.register("crimson_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.crimson, pos, state),
                            blockInit.CRIMSON_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> CRIMSON_TPR_CHEST_E =
            BLOCK_ENTITIES.register("crimson_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.crimson, pos, state),
                            blockInit.CRIMSON_TPR_CHEST.get()).build(null));

    public static final Supplier<BlockEntityType<MoreChestBlockEntity>> WARPED_CHEST_E =
            BLOCK_ENTITIES.register("warped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreChestBlockEntity(MoreChestEnum.warped, pos, state),
                            blockInit.WARPED_CHEST.get()).build(null));
    public static final Supplier<BlockEntityType<MoreTrappedChestBlockEntity>> WARPED_TPR_CHEST_E =
            BLOCK_ENTITIES.register("warped_trapped_chest", () ->
                    BlockEntityType.Builder.of((pos, state) -> new MoreTrappedChestBlockEntity(MoreChestEnum.warped, pos, state),
                            blockInit.WARPED_TPR_CHEST.get()).build(null));

    public static void register() {
        BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}