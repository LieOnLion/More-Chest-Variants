package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.block.entity.MoreTrappedChestBlockEntity;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MoreTrappedChestBlock extends MoreChestBlock {
    public final String chestType;

    public MoreTrappedChestBlock(MapColor colour, String chestType) {
        super(Properties.ofFullCopy(Blocks.CHEST).mapColor(colour), () -> McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), chestType);
        this.chestType = chestType;

        registerMaterialNameRetriever();
    }

    public MoreTrappedChestBlock(MapColor colour, SoundType sound, String chestType) {
        super(Properties.ofFullCopy(Blocks.CHEST).mapColor(colour).sound(sound), () -> McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), chestType);
        this.chestType = chestType;

        registerMaterialNameRetriever();
    }

    protected Stat<ResourceLocation> getOpenChestStat() {
        return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
    }

    public boolean isSignalSource(BlockState state) {
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
        return new MoreTrappedChestBlockEntity(pos, state);
    }
}