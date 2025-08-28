package dev.lieonlion.mcv.block.entity;

import dev.lieonlion.mcv.init.NeoForgeMoreChestVariantsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class NeoForgeMoreTrappedChestBlockEntity extends MoreTrappedChestBlockEntity {
    public NeoForgeMoreTrappedChestBlockEntity(BlockPos pos, BlockState state) {
        super(NeoForgeMoreChestVariantsBlocks.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), pos, state);
    }
}
