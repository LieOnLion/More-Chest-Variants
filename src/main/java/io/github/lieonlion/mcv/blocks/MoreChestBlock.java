package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.init.MoreChestInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MoreChestBlock extends ChestBlock {
    private final MoreChestEnum chestType;

    public MoreChestBlock(MoreChestEnum chestType, MapColor colour) {
        super(Properties.copy(Blocks.CHEST).mapColor(colour), () -> MoreChestInit.chest_entity.get());
        this.chestType = chestType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBlockEntity(this.chestType, pos, state);
    }

    public MoreChestEnum getChestType() {
        return this.chestType;
    }
}
