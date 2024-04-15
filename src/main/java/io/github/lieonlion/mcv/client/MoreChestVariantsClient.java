package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.client.renderer.MoreChestRenderer;
import io.github.lieonlion.mcv.client.renderer.MoreTrappedChestRenderer;
import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.MoreChestVariants;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = MoreChestVariants.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreChestVariantsClient {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void doClientStuff(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(McvBlockInit.MORE_CHEST_BLOCK_ENTITY.get(), MoreChestRenderer::new);
        BlockEntityRenderers.register(McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(), MoreTrappedChestRenderer::new);
    }
}