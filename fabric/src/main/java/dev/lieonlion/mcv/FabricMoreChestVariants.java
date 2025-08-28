package dev.lieonlion.mcv;

import dev.lieonlion.mcv.init.FabricMoreChestVariantsBlocks;
import dev.lieonlion.mcv.init.FabricMoreChestVariantsItems;
import net.fabricmc.api.ModInitializer;

public class FabricMoreChestVariants implements ModInitializer {
    @Override
    public void onInitialize() {
        MoreChestVariants.init();

        FabricMoreChestVariantsBlocks.register();
        FabricMoreChestVariantsItems.register();
    }
}
