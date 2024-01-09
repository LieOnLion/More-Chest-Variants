package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.init.blockEntityInit;
import io.github.lieonlion.mcv.MoreChestVariants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = MoreChestVariants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MoreChestClient {
    @SubscribeEvent
    public static void doClientStuff(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(blockEntityInit.OAK_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.OAK_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.SPRUCE_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.SPRUCE_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.BIRCH_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.BIRCH_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.JUNGLE_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.JUNGLE_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.ACACIA_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.ACACIA_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.DARK_OAK_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.DARK_OAK_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.MANGROVE_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.MANGROVE_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.CHERRY_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.CHERRY_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.BAMBOO_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.BAMBOO_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.CRIMSON_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.CRIMSON_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);

        event.registerBlockEntityRenderer(blockEntityInit.WARPED_CHEST_E.get(), MoreChestRenderer::new);
        event.registerBlockEntityRenderer(blockEntityInit.WARPED_TPR_CHEST_E.get(), MoreTrappedChestRenderer::new);
    }
}