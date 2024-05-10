package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.init.McvItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class MoreChestVariants implements ModInitializer {
    public static final String MODID = "lolmcv";

    @Override
    public void onInitialize() {
        McvBlockInit.registerBlocks();
        McvItemInit.registerItems();
    }

    public static Identifier asId(String path) {
        return new Identifier(MODID, path);
    }
}