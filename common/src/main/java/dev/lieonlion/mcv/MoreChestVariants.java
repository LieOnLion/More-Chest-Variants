package dev.lieonlion.mcv;

import dev.lieonlion.mcv.compatibility.YACLCompatibility;
import dev.lieonlion.mcv.config.IMoreChestVariantsConfig;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreChestVariants {
    public static final String MOD_ID = "lolmcv";
    public static final String MOD_NAME = "More Chest Variants";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static IMoreChestVariantsConfig CONFIG;

    public static void init() {
        CONFIG = YACLCompatibility.loadConfig();
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}