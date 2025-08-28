package dev.lieonlion.mcv.block;

import dev.lieonlion.mcv.block.entity.NeoForgeMoreChestBlockEntity;
import dev.lieonlion.mcv.init.NeoForgeMoreChestVariantsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

public class NeoForgeMoreChestBlock extends MoreChestBlock {
    public NeoForgeMoreChestBlock(MapColor colour, String woodType) {
        super(() -> NeoForgeMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY.get(), colour, woodType);
    }

    public NeoForgeMoreChestBlock(MapColor colour, SoundType sound, String woodType) {
        super(() -> NeoForgeMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY.get(), colour, sound, woodType);
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new NeoForgeMoreChestBlockEntity(pos, state);
    }
}
