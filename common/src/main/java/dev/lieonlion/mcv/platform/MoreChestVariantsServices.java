package dev.lieonlion.mcv.platform;

import dev.lieonlion.mcv.MoreChestVariants;
import dev.lieonlion.mcv.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class MoreChestVariantsServices {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        MoreChestVariants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
