package io.github.lieonlion.mcv.block.entity;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreChestBlockEntity extends ChestBlockEntity {
    public MoreChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(McvBlockInit.MORE_CHEST_BLOCK_ENTITY, blockPos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.lolmcv." + getBlock().chestType + "_chest");
    }

    public MoreChestBlock getBlock() {
        return (MoreChestBlock) getBlockState().getBlock();
    }
}