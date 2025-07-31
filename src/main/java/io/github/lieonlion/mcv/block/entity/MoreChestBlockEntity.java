package io.github.lieonlion.mcv.block.entity;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MoreChestBlockEntity extends ChestBlockEntity {
    public MoreChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(McvBlockInit.MORE_CHEST_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public MoreChestBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.lolmcv." + getBlock().woodType + "_chest");
    }

    public MoreChestBlock getBlock() {
        return (MoreChestBlock) getBlockState().getBlock();
    }

    public Container getContainer() {
        assert this.getLevel() != null;
        return ChestBlock.getContainer(
            this.getBlock(),
            this.getBlockState(),
            this.getLevel(),
            this.getBlockPos(),
            false
        );
    }
}