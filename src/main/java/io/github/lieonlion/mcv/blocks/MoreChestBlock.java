package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.init.blockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MoreChestBlock extends ChestBlock {
    public final MoreChestEnum chestType;

    public MoreChestBlock(MoreChestEnum chestType) {
        super(Properties.ofFullCopy(Blocks.CHEST).mapColor(chestType.getMapColour()), chestType::getChestEntity);
        this.chestType = chestType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBlockEntity(this.chestType, pos, state);
    }
}