package dev.lieonlion.mcv.client;

import dev.lieonlion.mcv.MoreChestVariants;
import dev.lieonlion.mcv.init.NeoForgeMoreChestVariantsBlocks;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = MoreChestVariants.MOD_ID, value = Dist.CLIENT)
public class NeoForgeMoreChestVariantsClient {
    @SubscribeEvent
    public static void doClientStuff(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(NeoForgeMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY.get(), ChestRenderer::new);
        event.registerBlockEntityRenderer(NeoForgeMoreChestVariantsBlocks.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), ChestRenderer::new);
    }
}
