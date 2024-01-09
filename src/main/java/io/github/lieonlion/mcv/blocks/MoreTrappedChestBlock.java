package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.init.blockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MoreTrappedChestBlock extends ChestBlock {
    private final MoreChestEnum chestType;

    public MoreTrappedChestBlock(MoreChestEnum chestType) {
        super(Properties.ofFullCopy(Blocks.CHEST).mapColor(chestType.getMapColour()), chestType::getTRPChestEntity);
        this.chestType = chestType;
    }

    protected Stat<ResourceLocation> getOpenChestStat() {
        return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
    }

    public boolean isSignalSource(BlockState p_57587_) {
        return true;
    }

    public int getSignal(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
        return Mth.clamp(ChestBlockEntity.getOpenCount(getter, pos), 0, 15);
    }

    public int getDirectSignal(BlockState state, BlockGetter getter, BlockPos pos, Direction direction) {
        return direction == Direction.UP ? state.getSignal(getter, pos, direction) : 0;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreTrappedChestBlockEntity(this.chestType, pos, state);
    }
}
