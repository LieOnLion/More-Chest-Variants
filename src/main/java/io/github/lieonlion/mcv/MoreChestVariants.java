package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.compatibility.YACLCompatibility;
import io.github.lieonlion.mcv.config.IMoreChestVariantsConfig;
import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.init.McvItemInit;
import io.github.lieonlion.mcv.integration.NeoForgeModMenuIntegration;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(MoreChestVariants.MODID)
public class MoreChestVariants {
    public static final String MODID = "lolmcv";

    public static IMoreChestVariantsConfig CONFIG;

    public MoreChestVariants(IEventBus modBus) {
        CONFIG = YACLCompatibility.loadConfig();
        NeoForgeModMenuIntegration.registerConfigScreen();

        McvBlockInit.registerBlocks(modBus);
        McvItemInit.registerItems(modBus);

        modBus.addListener(McvItemInit::addItemsToTab);
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}