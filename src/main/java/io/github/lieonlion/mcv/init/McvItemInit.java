package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class McvItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreChestVariants.MODID);
    
    public static final DeferredItem<BlockItem> OAK_CHEST_I = registerItem("oak", McvBlockInit.OAK_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_CHEST_I = registerItem("spruce", McvBlockInit.SPRUCE_CHEST);
    public static final DeferredItem<BlockItem> BIRCH_CHEST_I = registerItem("birch", McvBlockInit.BIRCH_CHEST);
    public static final DeferredItem<BlockItem> JUNGLE_CHEST_I = registerItem("jungle", McvBlockInit.JUNGLE_CHEST);
    public static final DeferredItem<BlockItem> ACACIA_CHEST_I = registerItem("acacia", McvBlockInit.ACACIA_CHEST);
    public static final DeferredItem<BlockItem> DARK_OAK_CHEST_I = registerItem("dark_oak", McvBlockInit.DARK_OAK_CHEST);
    public static final DeferredItem<BlockItem> MANGROVE_CHEST_I = registerItem("mangrove", McvBlockInit.MANGROVE_CHEST);
    public static final DeferredItem<BlockItem> CHERRY_CHEST_I = registerItem("cherry", McvBlockInit.CHERRY_CHEST);
    public static final DeferredItem<BlockItem> BAMBOO_CHEST_I = registerItem("bamboo", McvBlockInit.BAMBOO_CHEST);
    public static final DeferredItem<BlockItem> CRIMSON_CHEST_I = registerItem("crimson", McvBlockInit.CRIMSON_CHEST);
    public static final DeferredItem<BlockItem> WARPED_CHEST_I = registerItem("warped", McvBlockInit.WARPED_CHEST);

    public static final DeferredItem<BlockItem> OAK_TRAPPED_CHEST_I = registerItem("oak_trapped", McvBlockInit.OAK_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_TRAPPED_CHEST_I = registerItem("spruce_trapped", McvBlockInit.SPRUCE_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> BIRCH_TRAPPED_CHEST_I = registerItem("birch_trapped", McvBlockInit.BIRCH_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> JUNGLE_TRAPPED_CHEST_I = registerItem("jungle_trapped", McvBlockInit.JUNGLE_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> ACACIA_TRAPPED_CHEST_I = registerItem("acacia_trapped", McvBlockInit.ACACIA_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> DARK_OAK_TRAPPED_CHEST_I = registerItem("dark_oak_trapped", McvBlockInit.DARK_OAK_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> MANGROVE_TRAPPED_CHEST_I = registerItem("mangrove_trapped", McvBlockInit.MANGROVE_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> CHERRY_TRAPPED_CHEST_I = registerItem("cherry_trapped", McvBlockInit.CHERRY_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> BAMBOO_TRAPPED_CHEST_I = registerItem("bamboo_trapped", McvBlockInit.BAMBOO_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> CRIMSON_TRAPPED_CHEST_I = registerItem("crimson_trapped", McvBlockInit.CRIMSON_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> WARPED_TRAPPED_CHEST_I = registerItem("warped_trapped", McvBlockInit.WARPED_TRAPPED_CHEST);

    public static void registerItems(IEventBus modBus) {
        ITEMS.register(modBus);
    }

    public static DeferredItem<BlockItem> registerItem(String name, DeferredBlock<Block> block) {
        return ITEMS.register(name + "_chest", ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void addItemsToTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() != CreativeModeTabs.FUNCTIONAL_BLOCKS && event.getTabKey() != CreativeModeTabs.REDSTONE_BLOCKS) return;
        registerToTab(event, OAK_CHEST_I.get(), Items.CHEST);
        registerToTab(event, SPRUCE_CHEST_I.get(), OAK_CHEST_I.get());
        registerToTab(event, BIRCH_CHEST_I.get(), SPRUCE_CHEST_I.get());
        registerToTab(event, JUNGLE_CHEST_I.get(), BIRCH_CHEST_I.get());
        registerToTab(event, ACACIA_CHEST_I.get(), JUNGLE_CHEST_I.get());
        registerToTab(event, DARK_OAK_CHEST_I.get(), ACACIA_CHEST_I.get());
        registerToTab(event, MANGROVE_CHEST_I.get(), DARK_OAK_CHEST_I.get());
        registerToTab(event, CHERRY_CHEST_I.get(), MANGROVE_CHEST_I.get());
        registerToTab(event, BAMBOO_CHEST_I.get(), CHERRY_CHEST_I.get());
        registerToTab(event, CRIMSON_CHEST_I.get(), BAMBOO_CHEST_I.get());
        registerToTab(event, WARPED_CHEST_I.get(), CRIMSON_CHEST_I.get());

        if (event.getTabKey() != CreativeModeTabs.REDSTONE_BLOCKS) return;
        registerToTab(event, OAK_TRAPPED_CHEST_I.get(), Items.TRAPPED_CHEST);
        registerToTab(event, SPRUCE_TRAPPED_CHEST_I.get(), OAK_TRAPPED_CHEST_I.get());
        registerToTab(event, BIRCH_TRAPPED_CHEST_I.get(), SPRUCE_TRAPPED_CHEST_I.get());
        registerToTab(event, JUNGLE_TRAPPED_CHEST_I.get(), BIRCH_TRAPPED_CHEST_I.get());
        registerToTab(event, ACACIA_TRAPPED_CHEST_I.get(), JUNGLE_TRAPPED_CHEST_I.get());
        registerToTab(event, DARK_OAK_TRAPPED_CHEST_I.get(), ACACIA_TRAPPED_CHEST_I.get());
        registerToTab(event, MANGROVE_TRAPPED_CHEST_I.get(), DARK_OAK_TRAPPED_CHEST_I.get());
        registerToTab(event, CHERRY_TRAPPED_CHEST_I.get(), MANGROVE_TRAPPED_CHEST_I.get());
        registerToTab(event, BAMBOO_TRAPPED_CHEST_I.get(), CHERRY_TRAPPED_CHEST_I.get());
        registerToTab(event, CRIMSON_TRAPPED_CHEST_I.get(), BAMBOO_TRAPPED_CHEST_I.get());
        registerToTab(event, WARPED_TRAPPED_CHEST_I.get(), CRIMSON_TRAPPED_CHEST_I.get());

    } public static void registerToTab(BuildCreativeModeTabContentsEvent event, Item chest, Item chestAfter) {
        event.getEntries().putAfter(new ItemStack(chestAfter), new ItemStack(chest), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}