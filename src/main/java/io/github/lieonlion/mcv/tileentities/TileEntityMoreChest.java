package io.github.lieonlion.mcv.tileentities;

import io.github.lieonlion.mcv.SCRegistry;
import io.github.lieonlion.mcv.blocks.EnumMoreChest;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityMoreChest extends ChestBlockEntity {

    private EnumMoreChest chestType;

    public TileEntityMoreChest(BlockPos pos, BlockState state) {
        this(EnumMoreChest.SPRUCE, pos, state);
    }

    public TileEntityMoreChest(EnumMoreChest chestType, BlockPos pos, BlockState state) {
        super(SCRegistry.CHEST_TILE_TYPE.get(), pos, state);
        this.chestType = chestType;
    }

    public EnumMoreChest getChestType() {
        return chestType;
    }
}
