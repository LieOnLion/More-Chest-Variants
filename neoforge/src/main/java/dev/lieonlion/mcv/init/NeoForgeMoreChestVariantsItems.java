package dev.lieonlion.mcv.init;

import dev.lieonlion.mcv.MoreChestVariants;
import dev.lieonlion.mcv.block.MoreChestBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoForgeMoreChestVariantsItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreChestVariants.MOD_ID);
    
    public static final DeferredItem<BlockItem> OAK_CHEST_I = registerItem("oak", NeoForgeMoreChestVariantsBlocks.OAK_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_CHEST_I = registerItem("spruce", NeoForgeMoreChestVariantsBlocks.SPRUCE_CHEST);
    public static final DeferredItem<BlockItem> BIRCH_CHEST_I = registerItem("birch", NeoForgeMoreChestVariantsBlocks.BIRCH_CHEST);
    public static final DeferredItem<BlockItem> JUNGLE_CHEST_I = registerItem("jungle", NeoForgeMoreChestVariantsBlocks.JUNGLE_CHEST);
    public static final DeferredItem<BlockItem> ACACIA_CHEST_I = registerItem("acacia", NeoForgeMoreChestVariantsBlocks.ACACIA_CHEST);
    public static final DeferredItem<BlockItem> DARK_OAK_CHEST_I = registerItem("dark_oak", NeoForgeMoreChestVariantsBlocks.DARK_OAK_CHEST);
    public static final DeferredItem<BlockItem> MANGROVE_CHEST_I = registerItem("mangrove", NeoForgeMoreChestVariantsBlocks.MANGROVE_CHEST);
    public static final DeferredItem<BlockItem> CHERRY_CHEST_I = registerItem("cherry", NeoForgeMoreChestVariantsBlocks.CHERRY_CHEST);
    public static final DeferredItem<BlockItem> PALE_OAK_CHEST_I = registerItem("pale_oak", NeoForgeMoreChestVariantsBlocks.PALE_OAK_CHEST);
    public static final DeferredItem<BlockItem> BAMBOO_CHEST_I = registerItem("bamboo", NeoForgeMoreChestVariantsBlocks.BAMBOO_CHEST);
    public static final DeferredItem<BlockItem> CRIMSON_CHEST_I = registerItem("crimson", NeoForgeMoreChestVariantsBlocks.CRIMSON_CHEST);
    public static final DeferredItem<BlockItem> WARPED_CHEST_I = registerItem("warped", NeoForgeMoreChestVariantsBlocks.WARPED_CHEST);

    public static final DeferredItem<BlockItem> OAK_TRAPPED_CHEST_I = registerItem("oak_trapped", NeoForgeMoreChestVariantsBlocks.OAK_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_TRAPPED_CHEST_I = registerItem("spruce_trapped", NeoForgeMoreChestVariantsBlocks.SPRUCE_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> BIRCH_TRAPPED_CHEST_I = registerItem("birch_trapped", NeoForgeMoreChestVariantsBlocks.BIRCH_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> JUNGLE_TRAPPED_CHEST_I = registerItem("jungle_trapped", NeoForgeMoreChestVariantsBlocks.JUNGLE_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> ACACIA_TRAPPED_CHEST_I = registerItem("acacia_trapped", NeoForgeMoreChestVariantsBlocks.ACACIA_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> DARK_OAK_TRAPPED_CHEST_I = registerItem("dark_oak_trapped", NeoForgeMoreChestVariantsBlocks.DARK_OAK_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> MANGROVE_TRAPPED_CHEST_I = registerItem("mangrove_trapped", NeoForgeMoreChestVariantsBlocks.MANGROVE_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> CHERRY_TRAPPED_CHEST_I = registerItem("cherry_trapped", NeoForgeMoreChestVariantsBlocks.CHERRY_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> PALE_OAK_TRAPPED_CHEST_I = registerItem("pale_oak_trapped", NeoForgeMoreChestVariantsBlocks.PALE_OAK_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> BAMBOO_TRAPPED_CHEST_I = registerItem("bamboo_trapped", NeoForgeMoreChestVariantsBlocks.BAMBOO_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> CRIMSON_TRAPPED_CHEST_I = registerItem("crimson_trapped", NeoForgeMoreChestVariantsBlocks.CRIMSON_TRAPPED_CHEST);
    public static final DeferredItem<BlockItem> WARPED_TRAPPED_CHEST_I = registerItem("warped_trapped", NeoForgeMoreChestVariantsBlocks.WARPED_TRAPPED_CHEST);

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }

    public static DeferredItem<BlockItem> registerItem(String name, DeferredBlock<MoreChestBlock> block) {
        return ITEMS.register(name + "_chest", ()-> new BlockItem(block.get(), setProperties(block.get())));
    }

    public static Item.Properties setProperties(MoreChestBlock block) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, BuiltInRegistries.BLOCK.getKey(block))).useBlockDescriptionPrefix();
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
        registerToTab(event, PALE_OAK_CHEST_I.get(), CHERRY_CHEST_I.get());
        registerToTab(event, BAMBOO_CHEST_I.get(), PALE_OAK_CHEST_I.get());
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
        registerToTab(event, PALE_OAK_TRAPPED_CHEST_I.get(), CHERRY_TRAPPED_CHEST_I.get());
        registerToTab(event, BAMBOO_TRAPPED_CHEST_I.get(), PALE_OAK_TRAPPED_CHEST_I.get());
        registerToTab(event, CRIMSON_TRAPPED_CHEST_I.get(), BAMBOO_TRAPPED_CHEST_I.get());
        registerToTab(event, WARPED_TRAPPED_CHEST_I.get(), CRIMSON_TRAPPED_CHEST_I.get());
    } public static void registerToTab(BuildCreativeModeTabContentsEvent event, Item chest, Item chestAfter) {
        event.insertAfter(new ItemStack(chestAfter), new ItemStack(chest), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}