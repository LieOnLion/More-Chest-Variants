package dev.lieonlion.mcv.block.entity;

import dev.lieonlion.mcv.block.MoreTrappedChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class MoreTrappedChestBlockEntity extends MoreChestBlockEntity {
    protected MoreTrappedChestBlockEntity(BlockEntityType<?> blockEntity, BlockPos pos, BlockState state) {
        super(blockEntity, pos, state);
    }

    protected void signalOpenCount(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, int i, int j) {
        super.signalOpenCount(level, pos, state, i, j);
        if (i != j) {
            Block block = state.getBlock();
            level.updateNeighborsAt(pos, block);
            level.updateNeighborsAt(pos.below(), block);
        }
    }

    public MoreTrappedChestBlock getMoreTrappedChestBlock() {
        if (getBlockState().getBlock() instanceof MoreTrappedChestBlock) {
            return (MoreTrappedChestBlock) getBlockState().getBlock();
        } else {
            return null;
        }
    }
}
