package io.github.lieonlion.mcv.util;

import net.minecraft.world.level.block.state.BlockState;

public interface IMinecartChest {
    BlockState mcv$getBlock();
    void mcv$setBlock(BlockState state);
}
