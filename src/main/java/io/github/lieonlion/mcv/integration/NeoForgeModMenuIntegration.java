package io.github.lieonlion.mcv.integration;

import io.github.lieonlion.mcv.compatibility.YACLCompatibility;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public class NeoForgeModMenuIntegration {
    public static void registerConfigScreen() {
        if (YACLCompatibility.isLoaded()) {
            ModLoadingContext.get().registerExtensionPoint(
                IConfigScreenFactory.class,
                () -> (container, parent) -> YACLCompatibility.getConfigScreen(parent)
            );
        }
    }
}
