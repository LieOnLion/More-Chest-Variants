package dev.lieonlion.mcv.integration;

import dev.lieonlion.mcv.compatibility.YACLCompatibility;
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
