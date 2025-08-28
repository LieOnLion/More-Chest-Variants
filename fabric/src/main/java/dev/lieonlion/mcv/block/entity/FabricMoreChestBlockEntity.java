package dev.lieonlion.mcv.block.entity;

import dev.lieonlion.mcv.init.FabricMoreChestVariantsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class FabricMoreChestBlockEntity extends MoreChestBlockEntity {
    public FabricMoreChestBlockEntity(BlockPos pos, BlockState state) {
        super(FabricMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY, pos, state);
    }
}
