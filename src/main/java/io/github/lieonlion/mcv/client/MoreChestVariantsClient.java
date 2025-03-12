package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.client.renderer.layer.HorseChestLayer;
import io.github.lieonlion.mcv.client.renderer.MoreChestRenderer;
import io.github.lieonlion.mcv.client.renderer.layer.LlamaChestLayer;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.renderer.entity.ChestedHorseRenderer;
import net.minecraft.client.renderer.entity.LlamaRenderer;

@Environment(EnvType.CLIENT)
public class MoreChestVariantsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(McvBlockInit.MORE_CHEST_BLOCK_ENTITY, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY, MoreChestRenderer::new);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, renderer, registrationHelper, ctx) -> {
            if (renderer instanceof ChestedHorseRenderer chestedHorseRenderer) {
                registrationHelper.register(new HorseChestLayer(chestedHorseRenderer));
            } else if (renderer instanceof LlamaRenderer llamaRenderer) {
                registrationHelper.register(new LlamaChestLayer(llamaRenderer));
            }
        });
    }
}