package io.github.lieonlion.mcv.block.entity;

import io.github.lieonlion.mcv.block.MoreTrappedChestBlock;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoreTrappedChestBlockEntity extends ChestBlockEntity {
    public MoreTrappedChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY, blockPos, blockState);
    }

    protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
        super.onViewerCountUpdate(world, pos, state, oldViewerCount, newViewerCount);
        if (oldViewerCount != newViewerCount) {
            Block block = state.getBlock();
            world.updateNeighborsAlways(pos, block);
            world.updateNeighborsAlways(pos.down(), block);
        }
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.lolmcv." + getBlock().getChestType() + "_chest");
    }

    public MoreTrappedChestBlock getBlock() {
        return (MoreTrappedChestBlock) getCachedState().getBlock();
    }
}