package io.github.lieonlion.mcv.block.entity;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreTrappedChestBlock;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

public class MoreTrappedChestBlockEntity extends MoreChestBlockEntity {
    public MoreTrappedChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    protected void signalOpenCount(Level level, BlockPos pos, BlockState state, int i, int j) {
        super.signalOpenCount(level, pos, state, i, j);
        if (i != j) {
            Block block = state.getBlock();
            level.updateNeighborsAt(pos, block);
            level.updateNeighborsAt(pos.below(), block);
        }
    }

    @Override
    public MoreTrappedChestBlock getBlock() {
        return (MoreTrappedChestBlock) getBlockState().getBlock();
    }
}