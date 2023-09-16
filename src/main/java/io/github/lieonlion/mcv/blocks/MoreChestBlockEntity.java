package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.MoreChestRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MoreChestBlockEntity extends ChestBlockEntity {
    private MoreChestEnum chestType;

    public MoreChestBlockEntity(BlockPos pos, BlockState state) {
        this(MoreChestEnum.SPRUCE, pos, state);
    }

    public MoreChestBlockEntity(MoreChestEnum chestType, BlockPos pos, BlockState state) {
        super(MoreChestRegister.CHEST_TILE_TYPE.get(), pos, state);
        this.chestType = chestType;
    }

    public MoreChestEnum getChestType() {
        return chestType;
    }
}
