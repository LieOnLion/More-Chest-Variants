package dev.lieonlion.mcv.block.entity;

import dev.lieonlion.mcv.block.MoreChestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class MoreChestBlockEntity extends ChestBlockEntity {
    protected MoreChestBlockEntity(BlockEntityType<?> blockEntity, BlockPos pos, BlockState state) {
        super(blockEntity, pos, state);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.lolmcv." + getMoreChestBlock().woodType + "_chest");
    }

    public MoreChestBlock getMoreChestBlock() {
        if (getBlockState().getBlock() instanceof MoreChestBlock) {
            return (MoreChestBlock) getBlockState().getBlock();
        } else {
            return null;
        }
    }
}
