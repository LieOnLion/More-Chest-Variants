package io.github.lieonlion.mcv.client;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.lieonlion.mcv.MoreChestRegister;
import io.github.lieonlion.mcv.blocks.MoreChestBlock;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import io.github.lieonlion.mcv.blocks.MoreChestBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class MoreChestRenderManager extends BlockEntityWithoutLevelRenderer {
    public static final MoreChestRenderManager INSTANCE = new MoreChestRenderManager();

    private MoreChestBlockEntity[] tiles = new MoreChestBlockEntity[MoreChestEnum.VALUES.length];

    {
        for (MoreChestEnum type : MoreChestEnum.VALUES)
            tiles[type.ordinal()] = new MoreChestBlockEntity(type, BlockPos.ZERO, MoreChestRegister.chests[type.ordinal()].get().defaultBlockState());
    }

    public MoreChestRenderManager() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void onResourceManagerReload(ResourceManager manager) {
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemDisplayContext DisplayContextIn, PoseStack stack, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        Block block = Block.byItem(itemStackIn.getItem());
        if (block instanceof MoreChestBlock) {
            Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(this.tiles[((MoreChestBlock)block).getChestType().ordinal()], stack, bufferIn, combinedLightIn, combinedOverlayIn);
        } else {
            super.renderByItem(itemStackIn, DisplayContextIn, stack, bufferIn, combinedLightIn, combinedOverlayIn);
        }
    }
}
