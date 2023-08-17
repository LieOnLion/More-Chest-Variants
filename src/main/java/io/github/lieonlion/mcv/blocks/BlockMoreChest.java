package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.SCRegistry;
import io.github.lieonlion.mcv.tileentities.TileEntityMoreChest;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockMoreChest extends ChestBlock {
    private final EnumMoreChest chestType;

    public BlockMoreChest(EnumMoreChest chestType) {
        super(Properties.copy(Blocks.CHEST), () -> SCRegistry.CHEST_TILE_TYPE.get());
        this.chestType = chestType;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityMoreChest(this.chestType, pos, state);
    }

    public EnumMoreChest getChestType() {
        return this.chestType;
    }
}
