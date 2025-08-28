package dev.lieonlion.mcv.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.lieonlion.mcv.compatibility.YACLCompatibility;

public class FabricModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (YACLCompatibility.isLoaded()) {
            return YACLCompatibility::getConfigScreen;
        } else {
            return null;
        }
    }
}
