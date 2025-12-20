package dev.lieonlion.mcv.block;

import dev.lieonlion.mcv.MoreChestVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class MoreTrappedChestBlock extends MoreChestBlock {
    protected MoreTrappedChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, Properties properties, String woodType) {
        super(blockEntityType, properties.setId(ResourceKey.create(Registries.BLOCK, MoreChestVariants.location(woodType + "_trapped_chest"))), woodType);
    }

    public MoreTrappedChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, MapColor colour, String woodType) {
        this(blockEntityType, Properties.ofFullCopy(Blocks.CHEST).mapColor(colour), woodType);
    }

    public MoreTrappedChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, MapColor colour, SoundType sound, String woodType) {
        this(blockEntityType, Properties.ofFullCopy(Blocks.CHEST).mapColor(colour).sound(sound), woodType);
    }

    protected @NotNull Stat<@NotNull Identifier> getOpenChestStat() {
        return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
    }

    public boolean isSignalSource(@NotNull BlockState state) {
        return true;
    }

    public int getSignal(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull Direction direction) {
        return Mth.clamp(ChestBlockEntity.getOpenCount(getter, pos), 0, 15);
    }

    public int getDirectSignal(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull Direction direction) {
        return direction == Direction.UP ? state.getSignal(getter, pos, direction) : 0;
    }
}
