package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.block.entity.MoreTrappedChestBlockEntity;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class MoreTrappedChestBlock extends ChestBlock {
    public DoubleBlockProperties.PropertyRetriever<ChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER;
    public final String chestType;

    public MoreTrappedChestBlock(MapColor colour, String chestType) {
        super(Settings.copy(Blocks.TRAPPED_CHEST).mapColor(colour), () -> McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY);
        this.chestType = chestType;

        registerMaterialNameRetriever();
    }

    public MoreTrappedChestBlock(MapColor colour, BlockSoundGroup sound, String chestType) {
        super(Settings.copy(Blocks.TRAPPED_CHEST).mapColor(colour).sounds(sound), () -> McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY);
        this.chestType = chestType;

        registerMaterialNameRetriever();
    }

    protected Stat<Identifier> getOpenStat() {
        return Stats.CUSTOM.getOrCreateStat(Stats.TRIGGER_TRAPPED_CHEST);
    }

    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return MathHelper.clamp(ChestBlockEntity.getPlayersLookingInChestCount(world, pos), 0, 15);
    }

    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return direction == Direction.UP ? state.getWeakRedstonePower(world, pos, direction) : 0;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MoreTrappedChestBlockEntity(pos, state);
    }

    protected void registerMaterialNameRetriever() {
        NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
            public Optional<NamedScreenHandlerFactory> getFromBoth(ChestBlockEntity chestBlockEntity, ChestBlockEntity chestBlockEntity2) {
                final Inventory inventory = new DoubleInventory(chestBlockEntity, chestBlockEntity2);
                return Optional.of(new NamedScreenHandlerFactory() {
                    @Nullable
                    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        if (chestBlockEntity.checkUnlocked(playerEntity) && chestBlockEntity2.checkUnlocked(playerEntity)) {
                            chestBlockEntity.generateLoot(playerInventory.player);
                            chestBlockEntity2.generateLoot(playerInventory.player);
                            return GenericContainerScreenHandler.createGeneric9x6(i, playerInventory, inventory);
                        } else {
                            return null;
                        }
                    }

                    public Text getDisplayName() {
                        if (chestBlockEntity.hasCustomName()) {
                            return chestBlockEntity.getDisplayName();
                        } else {
                            return chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() :
                                    Text.translatable("container.lolmcv." + chestType + "_chestDouble");
                        }
                    }
                });
            }

            public Optional<NamedScreenHandlerFactory> getFrom(ChestBlockEntity chestBlockEntity) {
                return Optional.of(chestBlockEntity);
            }

            public Optional<NamedScreenHandlerFactory> getFallback() {
                return Optional.empty();
            }
        };
    }

    @Override
    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return this.getBlockEntitySource(state, world, pos, false)
                .apply(NAME_RETRIEVER).orElse(null);
    }

    public String getChestType() {
        return chestType;
    }
}