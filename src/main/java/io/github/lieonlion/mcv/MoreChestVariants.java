package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.init.McvItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreChestVariants.MODID)
public class MoreChestVariants {
    public static final String MODID = "lolmcv";

    public MoreChestVariants() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        McvBlockInit.registerBlocks(modEventBus);
        McvItemInit.registerItems(modEventBus);

        modEventBus.addListener(McvItemInit::addItemsToTab);

        MinecraftForge.EVENT_BUS.register(this);
    }
}