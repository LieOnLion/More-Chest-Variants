package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.client.renderer.MoreChestRenderer;
import io.github.lieonlion.mcv.client.renderer.MoreTrappedChestRenderer;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class MoreChestVariantsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(McvBlockInit.MORE_CHEST_BLOCK_ENTITY, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY, MoreTrappedChestRenderer::new);
    }
}