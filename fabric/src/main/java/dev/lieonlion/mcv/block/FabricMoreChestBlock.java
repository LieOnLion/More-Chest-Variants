package dev.lieonlion.mcv.block;

import dev.lieonlion.mcv.block.entity.FabricMoreChestBlockEntity;
import dev.lieonlion.mcv.init.FabricMoreChestVariantsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;

public class FabricMoreChestBlock extends MoreChestBlock {
    public FabricMoreChestBlock(MapColor colour, String woodType) {
        super(() -> FabricMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY, colour, woodType);
    }

    public FabricMoreChestBlock(MapColor colour, SoundType sound, String woodType) {
        super(() -> FabricMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY, colour, sound, woodType);
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FabricMoreChestBlockEntity(pos, state);
    }
}
