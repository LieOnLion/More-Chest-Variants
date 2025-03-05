package io.github.lieonlion.mcv.client.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.entity.MoreChestBlockEntity;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public class BlockEntityWithoutLevelRendererMixin {
    @Shadow @Final private BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    @Inject(method = "renderByItem", at = @At(value = "HEAD"), cancellable = true)
    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {
        Item item = itemStack.getItem();
        if (item instanceof BlockItem) {
            BlockEntity blockEntity;
            Block block = ((BlockItem)item).getBlock();
            BlockState blockState = block.defaultBlockState();
            if (block instanceof MoreChestBlock) {
                blockEntity = new MoreChestBlockEntity(BlockPos.ZERO, blockState);
                this.blockEntityRenderDispatcher.renderItem(blockEntity, poseStack, multiBufferSource, i, j);
                ci.cancel();
            }
        }
    }
}
