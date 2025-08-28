package dev.lieonlion.mcv.client;

import dev.lieonlion.mcv.init.FabricMoreChestVariantsBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;

@Environment(EnvType.CLIENT)
public class FabricMoreChestVariantsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(FabricMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY, ChestRenderer::new);
        BlockEntityRenderers.register(FabricMoreChestVariantsBlocks.MORE_TRAPPED_CHEST_BLOCK_ENTITY, ChestRenderer::new);
    }
}
