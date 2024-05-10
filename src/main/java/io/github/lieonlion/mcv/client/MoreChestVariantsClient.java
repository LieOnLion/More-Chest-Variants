package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.client.renderer.MoreChestRenderer;
import io.github.lieonlion.mcv.client.renderer.MoreTrappedChestRenderer;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = MoreChestVariants.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MoreChestVariantsClient {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void doClientStuff(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(McvBlockInit.MORE_CHEST_BLOCK_ENTITY.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), MoreTrappedChestRenderer::new);
    }
}