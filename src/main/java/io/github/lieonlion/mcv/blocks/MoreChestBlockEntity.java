package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.init.blockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreChestBlockEntity extends ChestBlockEntity {
    private final MoreChestEnum chestType;

    public MoreChestBlockEntity(MoreChestEnum chestType, BlockPos blockPos, BlockState blockState) {
        super(chestType.getChestEntity(), blockPos, blockState);
        this.chestType = chestType;
    }

    public MoreChestEnum getChestType() {
        return chestType;
    }
}
