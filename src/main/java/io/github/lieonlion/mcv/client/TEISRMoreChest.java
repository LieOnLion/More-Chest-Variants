package io.github.lieonlion.mcv.client;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.lieonlion.mcv.SCRegistry;
import io.github.lieonlion.mcv.blocks.BlockMoreChest;
import io.github.lieonlion.mcv.blocks.EnumMoreChest;
import io.github.lieonlion.mcv.tileentities.TileEntityMoreChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class TEISRMoreChest extends BlockEntityWithoutLevelRenderer {
    public static final TEISRMoreChest INSTANCE = new TEISRMoreChest();

    private TileEntityMoreChest[] tiles = new TileEntityMoreChest[EnumMoreChest.VALUES.length];

    {
        for (EnumMoreChest type : EnumMoreChest.VALUES)
            tiles[type.ordinal()] = new TileEntityMoreChest(type, BlockPos.ZERO, SCRegistry.chests[type.ordinal()].get().defaultBlockState());
    }

    public TEISRMoreChest() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void onResourceManagerReload(ResourceManager manager) {
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemDisplayContext DisplayContextIn, PoseStack stack, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        Block block = Block.byItem(itemStackIn.getItem());
        if (block instanceof BlockMoreChest) {
            Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(this.tiles[((BlockMoreChest)block).getChestType().ordinal()], stack, bufferIn, combinedLightIn, combinedOverlayIn);
        } else {
            super.renderByItem(itemStackIn, DisplayContextIn, stack, bufferIn, combinedLightIn, combinedOverlayIn);
        }
    }
}
