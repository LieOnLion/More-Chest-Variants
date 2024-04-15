package io.github.lieonlion.mcv.block.entity;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class MoreChestBlockEntity extends ChestBlockEntity {
    public MoreChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(McvBlockInit.MORE_CHEST_BLOCK_ENTITY, blockPos, blockState);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.lolmcv." + getBlock().getChestType() + "_chest");
    }

    public MoreChestBlock getBlock() {
        return (MoreChestBlock) getCachedState().getBlock();
    }
}