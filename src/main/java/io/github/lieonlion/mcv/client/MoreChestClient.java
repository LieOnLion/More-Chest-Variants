package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.init.MoreChestInit;
import io.github.lieonlion.mcv.MoreChestVariants;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = MoreChestVariants.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreChestClient {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void doClientStuff(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(MoreChestInit.chest_entity.get(), MoreChestRenderer::new);
    }
}