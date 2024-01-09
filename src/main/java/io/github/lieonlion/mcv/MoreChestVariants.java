package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.client.MoreChestClient;
import io.github.lieonlion.mcv.client.MoreChestRenderer;
import io.github.lieonlion.mcv.client.MoreTrappedChestRenderer;
import io.github.lieonlion.mcv.init.blockEntityInit;
import io.github.lieonlion.mcv.init.blockInit;
import io.github.lieonlion.mcv.init.itemInit;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.function.Supplier;

@Mod(MoreChestVariants.MODID)
public class MoreChestVariants {
    public static final String MODID = "lolmcv";

    public MoreChestVariants(IEventBus modEventBus) {
        blockInit.register();
        blockEntityInit.register();
        itemInit.register();

        modEventBus.addListener(itemInit::addItemsToCreativeTab);
        modEventBus.addListener(MoreChestClient::doClientStuff);

//        NeoForge.EVENT_BUS.register(this);
    }
}