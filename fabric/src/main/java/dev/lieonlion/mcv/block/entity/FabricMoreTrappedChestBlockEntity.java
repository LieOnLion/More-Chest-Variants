package dev.lieonlion.mcv.block.entity;

import dev.lieonlion.mcv.init.FabricMoreChestVariantsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class FabricMoreTrappedChestBlockEntity extends MoreTrappedChestBlockEntity {
    public FabricMoreTrappedChestBlockEntity(BlockPos pos, BlockState state) {
        super(FabricMoreChestVariantsBlocks.MORE_TRAPPED_CHEST_BLOCK_ENTITY, pos, state);
    }
}
