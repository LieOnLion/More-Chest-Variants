package io.github.lieonlion.mcv;

import com.mojang.logging.LogUtils;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(MoreChestVariants.MODID)
public class MoreChestVariants {
    public static final String MODID = "lolmcv";
    private static final Logger LOGGER = LogUtils.getLogger();

    /*
        most code for this mod is taken from DoctorFTB Stone Chest
        Copyright (c) 2018
     */

    public MoreChestVariants() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MoreChestRegister.register();

        modEventBus.addListener((BuildCreativeModeTabContentsEvent e) -> {
            if (e.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || e.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
                MoreChestRegister.ITEMS.getEntries()
                        .stream()
                        .map(RegistryObject::get)
                        .forEach(e::accept);
            }
        });

        MinecraftForge.EVENT_BUS.register(this);
    }

    /*
        allow chests to burn
        Thanks to DaveDuart
    */

    @SubscribeEvent
    public void onFurnaceFuelBurnTime (FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();

        if (isChestItemBurnable(item)) {
            event.setBurnTime(300);
        }
    }
    private boolean isChestItemBurnable(Item item) {
        if (item == null) {return false;}

        for (MoreChestEnum chest: MoreChestEnum.VALUES) {
            ResourceLocation blockLocation = new ResourceLocation(MODID, chest.getId());
            if (!chest.getCanBurn()) {continue;}
            if (item.equals(Item.BY_BLOCK.get(ForgeRegistries.BLOCKS.getValue(blockLocation)))) {return true;}
        }
        return false;
    }
}