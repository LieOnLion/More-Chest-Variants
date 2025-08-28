package dev.lieonlion.mcv.compatibility;

import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.lieonlion.mcv.config.IMoreChestVariantsConfig;
import dev.lieonlion.mcv.config.MoreChestVariantsConfigYACL;
import dev.lieonlion.mcv.platform.MoreChestVariantsServices;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class YACLCompatibility {
    public static boolean isLoaded() {
        return MoreChestVariantsServices.PLATFORM.isModLoaded("yet_another_config_lib_v3");
    }

    public static IMoreChestVariantsConfig loadConfig() {
        if (isLoaded()) {
            MoreChestVariantsConfigYACL.HANDLER.load();
            return MoreChestVariantsConfigYACL.HANDLER.instance();
        } return IMoreChestVariantsConfig.DEFAULT;
    }

    public static Screen getConfigScreen(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
            .title(Component.translatable("lolmcv.config.title"))
            .category(MoreChestVariantsConfigYACL.getConfigCategory())
            .save(MoreChestVariantsConfigYACL.HANDLER::save)
            .build()
            .generateScreen(parent);
    }
}
