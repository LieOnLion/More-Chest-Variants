package io.github.lieonlion.mcv.compatibility;

import dev.isxander.yacl3.api.YetAnotherConfigLib;
import io.github.lieonlion.mcv.config.IMoreChestVariantsConfig;
import io.github.lieonlion.mcv.config.MoreChestVariantsConfigYACL;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.fml.ModList;

public class YACLCompatibility {
    public static boolean isLoaded() {
        return ModList.get().isLoaded("yet_another_config_lib_v3");
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
