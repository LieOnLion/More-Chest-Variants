package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.block.entity.MoreChestBlockEntity;
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
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class MoreChestBlock extends ChestBlock {
    public DoubleBlockProperties.PropertyRetriever<ChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER;
    public final String chestType;

    public MoreChestBlock(MapColor colour, String chestType) {
        super(Settings.copy(Blocks.CHEST).mapColor(colour), () -> McvBlockInit.MORE_CHEST_BLOCK_ENTITY);
        this.chestType = chestType;

        registerMaterialNameRetriever();
    }

    public MoreChestBlock(MapColor colour, BlockSoundGroup sound, String chestType) {
        super(Settings.copy(Blocks.CHEST).mapColor(colour).sounds(sound), () -> McvBlockInit.MORE_CHEST_BLOCK_ENTITY);
        this.chestType = chestType;

        registerMaterialNameRetriever();
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBlockEntity(pos, state);
    }

    protected void registerMaterialNameRetriever() {
        NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
            public Optional<NamedScreenHandlerFactory> getFromBoth(ChestBlockEntity chestBlockEntity, ChestBlockEntity chestBlockEntity2) {
                final Inventory inventory = new DoubleInventory(chestBlockEntity, chestBlockEntity2);
                return Optional.of(new NamedScreenHandlerFactory() {
                    @Nullable
                    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        if (chestBlockEntity.checkUnlocked(playerEntity) && chestBlockEntity2.checkUnlocked(playerEntity)) {
                            chestBlockEntity.checkLootInteraction(playerInventory.player);
                            chestBlockEntity2.checkLootInteraction(playerInventory.player);
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