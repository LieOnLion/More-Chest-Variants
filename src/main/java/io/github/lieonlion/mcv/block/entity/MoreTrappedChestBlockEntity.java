package io.github.lieonlion.mcv.block.entity;

import io.github.lieonlion.mcv.block.MoreTrappedChestBlock;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreTrappedChestBlockEntity extends ChestBlockEntity {
    public MoreTrappedChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    protected void signalOpenCount(Level level, BlockPos pos, BlockState state, int i, int j) {
        super.signalOpenCount(level, pos, state, i, j);
        if (i != j) {
            Block block = state.getBlock();
            level.updateNeighborsAt(pos, block);
            level.updateNeighborsAt(pos.below(), block);
        }
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.lolmcv." + getBlock().getChestType() + "_chest");
    }

    public MoreTrappedChestBlock getBlock() {
        return (MoreTrappedChestBlock) getBlockState().getBlock();
    }
}