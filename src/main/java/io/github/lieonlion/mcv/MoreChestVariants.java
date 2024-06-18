package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.init.McvItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreChestVariants implements ModInitializer {
    public static final String MODID = "lolmcv";
    public static final Logger LOGGER = LoggerFactory.getLogger("MCV");

    @Override
    public void onInitialize() {
        McvBlockInit.registerBlocks();
        McvItemInit.registerItems();
    }

    public static ResourceLocation asId(String path) {
        return new ResourceLocation(MODID, path);
    }
}