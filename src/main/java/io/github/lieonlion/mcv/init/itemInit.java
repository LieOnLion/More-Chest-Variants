package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class itemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreChestVariants.MODID);

    public static final DeferredItem OAK_CHEST_I = ITEMS.register("oak_chest", () -> new BlockItem(blockInit.OAK_CHEST.get(), new Item.Properties()));
    public static final DeferredItem OAK_TPR_CHEST_I = ITEMS.register("oak_trapped_chest", () -> new BlockItem(blockInit.OAK_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem SPRUCE_CHEST_I = ITEMS.register("spruce_chest", () -> new BlockItem(blockInit.SPRUCE_CHEST.get(), new Item.Properties()));
    public static final DeferredItem SPRUCE_TPR_CHEST_I = ITEMS.register("spruce_trapped_chest", () -> new BlockItem(blockInit.SPRUCE_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem BIRCH_CHEST_I = ITEMS.register("birch_chest", () -> new BlockItem(blockInit.BIRCH_CHEST.get(), new Item.Properties()));
    public static final DeferredItem BIRCH_TPR_CHEST_I = ITEMS.register("birch_trapped_chest", () -> new BlockItem(blockInit.BIRCH_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem JUNGLE_CHEST_I = ITEMS.register("jungle_chest", () -> new BlockItem(blockInit.JUNGLE_CHEST.get(), new Item.Properties()));
    public static final DeferredItem JUNGLE_TPR_CHEST_I = ITEMS.register("jungle_trapped_chest", () -> new BlockItem(blockInit.JUNGLE_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem ACACIA_CHEST_I = ITEMS.register("acacia_chest", () -> new BlockItem(blockInit.ACACIA_CHEST.get(), new Item.Properties()));
    public static final DeferredItem ACACIA_TPR_CHEST_I = ITEMS.register("acacia_trapped_chest", () -> new BlockItem(blockInit.ACACIA_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem DARK_OAK_CHEST_I = ITEMS.register("dark_oak_chest", () -> new BlockItem(blockInit.DARK_OAK_CHEST.get(), new Item.Properties()));
    public static final DeferredItem DARK_OAK_TPR_CHEST_I = ITEMS.register("dark_oak_trapped_chest", () -> new BlockItem(blockInit.DARK_OAK_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem MANGROVE_CHEST_I = ITEMS.register("mangrove_chest", () -> new BlockItem(blockInit.MANGROVE_CHEST.get(), new Item.Properties()));
    public static final DeferredItem MANGROVE_TPR_CHEST_I = ITEMS.register("mangrove_trapped_chest", () -> new BlockItem(blockInit.MANGROVE_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem CHERRY_CHEST_I = ITEMS.register("cherry_chest", () -> new BlockItem(blockInit.CHERRY_CHEST.get(), new Item.Properties()));
    public static final DeferredItem CHERRY_TPR_CHEST_I = ITEMS.register("cherry_trapped_chest", () -> new BlockItem(blockInit.CHERRY_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem BAMBOO_CHEST_I = ITEMS.register("bamboo_chest", () -> new BlockItem(blockInit.BAMBOO_CHEST.get(), new Item.Properties()));
    public static final DeferredItem BAMBOO_TPR_CHEST_I = ITEMS.register("bamboo_trapped_chest", () -> new BlockItem(blockInit.BAMBOO_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem CRIMSON_CHEST_I = ITEMS.register("crimson_chest", () -> new BlockItem(blockInit.CRIMSON_CHEST.get(), new Item.Properties()));
    public static final DeferredItem CRIMSON_TPR_CHEST_I = ITEMS.register("crimson_trapped_chest", () -> new BlockItem(blockInit.CRIMSON_TPR_CHEST.get(), new Item.Properties()));

    public static final DeferredItem WARPED_CHEST_I = ITEMS.register("warped_chest", () -> new BlockItem(blockInit.WARPED_CHEST.get(), new Item.Properties()));
    public static final DeferredItem WARPED_TPR_CHEST_I = ITEMS.register("warped_trapped_chest", () -> new BlockItem(blockInit.WARPED_TPR_CHEST.get(), new Item.Properties()));

    public static void addItemsToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        addToTab(event, WARPED_TPR_CHEST_I.asItem());
        addToTab(event, WARPED_CHEST_I.asItem());

        addToTab(event, CRIMSON_TPR_CHEST_I.asItem());
        addToTab(event, CRIMSON_CHEST_I.asItem());

        addToTab(event, BAMBOO_TPR_CHEST_I.asItem());
        addToTab(event, BAMBOO_CHEST_I.asItem());

        addToTab(event, CHERRY_TPR_CHEST_I.asItem());
        addToTab(event, CHERRY_CHEST_I.asItem());

        addToTab(event, MANGROVE_TPR_CHEST_I.asItem());
        addToTab(event, MANGROVE_CHEST_I.asItem());

        addToTab(event, DARK_OAK_TPR_CHEST_I.asItem());
        addToTab(event, DARK_OAK_CHEST_I.asItem());

        addToTab(event, ACACIA_TPR_CHEST_I.asItem());
        addToTab(event, ACACIA_CHEST_I.asItem());

        addToTab(event, JUNGLE_TPR_CHEST_I.asItem());
        addToTab(event, JUNGLE_CHEST_I.asItem());

        addToTab(event, BIRCH_TPR_CHEST_I.asItem());
        addToTab(event, BIRCH_CHEST_I.asItem());

        addToTab(event, SPRUCE_TPR_CHEST_I.asItem());
        addToTab(event, SPRUCE_CHEST_I.asItem());

        addToTab(event, OAK_TPR_CHEST_I.asItem());
        addToTab(event, OAK_CHEST_I.asItem());
    } public static void addToTab(BuildCreativeModeTabContentsEvent event, Item item) {
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS)
            event.getEntries().putAfter (new ItemStack(Blocks.CHEST), new ItemStack(item), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
