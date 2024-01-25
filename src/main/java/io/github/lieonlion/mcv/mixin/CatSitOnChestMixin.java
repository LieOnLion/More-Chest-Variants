package io.github.lieonlion.mcv.mixin;

import io.github.lieonlion.mcv.blocks.MoreChestBlock;
import io.github.lieonlion.mcv.blocks.MoreChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.CatSitOnBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CatSitOnBlockGoal.class)
public class CatSitOnChestMixin {
    @Inject(method = "isValidTarget", at = @At(value = "HEAD"), cancellable = true)
    private void lootrPlayersUsing(LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        if (!level.isEmptyBlock(pos.above())) {
            info.setReturnValue(false);
        } else {
            BlockState blockState = level.getBlockState(pos);
            if (blockState.getBlock() instanceof MoreChestBlock) {
                info.setReturnValue(MoreChestBlockEntity.getOpenCount(level, pos) < 1);
            }
        }
    }
}