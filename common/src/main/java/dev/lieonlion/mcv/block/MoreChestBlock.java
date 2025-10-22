package dev.lieonlion.mcv.block;

import dev.lieonlion.mcv.MoreChestVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

public class MoreChestBlock extends ChestBlock {
    public DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> NAME_RETRIEVER = new DoubleBlockCombiner.Combiner<>() {
        public @NotNull Optional<MenuProvider> acceptDouble(@NotNull ChestBlockEntity chestBlockEntity, @NotNull ChestBlockEntity chestBlockEntity2) {
            final Container container = new CompoundContainer(chestBlockEntity, chestBlockEntity2);
            return Optional.of(new MenuProvider() {
                public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
                    if (chestBlockEntity.canOpen(player) && chestBlockEntity2.canOpen(player)) {
                        chestBlockEntity.unpackLootTable(inventory.player);
                        chestBlockEntity2.unpackLootTable(inventory.player);
                        return ChestMenu.sixRows(id, inventory, container);
                    } else {
                        return null;
                    }
                }

                public @NotNull Component getDisplayName() {
                    if (chestBlockEntity.hasCustomName()) {
                        return chestBlockEntity.getDisplayName();
                    } else {
                        return chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() : Component.translatable("container.lolmcv." + woodType + "_chestDouble");
                    }
                }
            });
        }

        public @NotNull Optional<MenuProvider> acceptSingle(@NotNull ChestBlockEntity chestBlockEntity) {
            return Optional.of(chestBlockEntity);
        }

        public @NotNull Optional<MenuProvider> acceptNone() {
            return Optional.empty();
        }
    };

    public final String woodType;

    public MoreChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, Properties properties, String woodType) {
        super(blockEntityType, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, properties);
        this.woodType = woodType;
    }

    public MoreChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, MapColor colour, String woodType) {
        this(blockEntityType, Properties.ofFullCopy(Blocks.CHEST).mapColor(colour).setId(ResourceKey.create(Registries.BLOCK, MoreChestVariants.location(woodType + "_chest"))), woodType);
    }

    public MoreChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, MapColor colour, SoundType sound, String woodType) {
        this(blockEntityType, Properties.ofFullCopy(Blocks.CHEST).mapColor(colour).sound(sound).setId(ResourceKey.create(Registries.BLOCK, MoreChestVariants.location(woodType + "_chest"))), woodType);
    }

    @Override
    public MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
        return this.combine(state, level, pos, false).apply(NAME_RETRIEVER).orElse(null);
    }
}
