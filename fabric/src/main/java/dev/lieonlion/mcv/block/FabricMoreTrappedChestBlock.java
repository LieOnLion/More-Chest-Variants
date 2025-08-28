package dev.lieonlion.mcv.block;

import dev.lieonlion.mcv.block.entity.FabricMoreTrappedChestBlockEntity;
import dev.lieonlion.mcv.init.FabricMoreChestVariantsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

public class FabricMoreTrappedChestBlock extends MoreTrappedChestBlock {
    public FabricMoreTrappedChestBlock(MapColor colour, String woodType) {
        super(() -> FabricMoreChestVariantsBlocks.MORE_TRAPPED_CHEST_BLOCK_ENTITY, colour, woodType);
    }

    public FabricMoreTrappedChestBlock(MapColor colour, SoundType sound, String woodType) {
        super(() -> FabricMoreChestVariantsBlocks.MORE_TRAPPED_CHEST_BLOCK_ENTITY, colour, sound, woodType);
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FabricMoreTrappedChestBlockEntity(pos, state);
    }
}
