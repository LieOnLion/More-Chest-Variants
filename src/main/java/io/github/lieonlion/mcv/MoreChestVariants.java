package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.init.McvItemInit;
import net.fabricmc.api.ModInitializer;

public class MoreChestVariants implements ModInitializer {
    public static final String MODID = "lolmcv";

    @Override
    public void onInitialize() {
        McvBlockInit.registerBlocks();
        McvItemInit.registerItems();
    }
}