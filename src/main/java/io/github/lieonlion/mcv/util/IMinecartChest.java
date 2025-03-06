package io.github.lieonlion.mcv.util;

import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;

public interface IMinecartChest {
    BlockState mcv$getChestType();
    void mcv$setChestType(BlockState state);
    BlockState mcv$getChestState(ChestBlock chest);
}
