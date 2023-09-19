package io.github.lieonlion.mcv;

import com.mojang.logging.LogUtils;
import io.github.lieonlion.mcv.init.MoreChestInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(MoreChestVariants.MODID)
public class MoreChestVariants {
    public static final String MODID = "lolmcv";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final TagKey<Item> CHEST_IS_FUEL = ItemTags.create(new ResourceLocation(MODID, "chest_is_fuel"));

    /*
        most code for this mod is taken from DoctorFTB's Stone Chest
        Copyright (c) 2018
     */

    public MoreChestVariants() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MoreChestInit.register();

        modEventBus.addListener((BuildCreativeModeTabContentsEvent event) -> {
            if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
                MoreChestInit.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(event::accept);
            }
        });

        MinecraftForge.EVENT_BUS.register(this);
    }

    /*
        allow chests to burn
        Thanks to DaveDuart for some help
    */

    @SubscribeEvent
    public void onFurnaceFuelBurnTime (FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().getItem().builtInRegistryHolder().is(CHEST_IS_FUEL))
            event.setBurnTime(300);
    }
}