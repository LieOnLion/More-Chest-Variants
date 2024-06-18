package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.init.McvItemInit;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(MoreChestVariants.MODID)
public class MoreChestVariants {
    public static final String MODID = "lolmcv";

    public MoreChestVariants(IEventBus modBus) {
        McvBlockInit.registerBlocks(modBus);
        McvItemInit.registerItems(modBus);

        modBus.addListener(McvItemInit::addItemsToTab);
    }

    public static ResourceLocation asId(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}