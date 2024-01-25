package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.init.blockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreTrappedChestBlockEntity extends ChestBlockEntity {
    private MoreChestEnum chestType;

    public MoreTrappedChestBlockEntity(MoreChestEnum chestType, BlockPos pos, BlockState state) {
        super(chestType.getTRPChestEntity(), pos, state);
        this.chestType = chestType;
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
        return Component.translatable("container.lolmcv." + chestType.name() + "_chest");
    }

    public MoreChestEnum getChestType() {
        return chestType;
    }
}