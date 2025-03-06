package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreTrappedChestBlock;
import io.github.lieonlion.mcv.item.MoreChestMinecartItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

public class McvItemInit {
    public static final BlockItem OAK_CHEST = new BlockItem(McvBlockInit.OAK_CHEST, new Item.Properties());
    public static final BlockItem SPRUCE_CHEST = new BlockItem(McvBlockInit.SPRUCE_CHEST, new Item.Properties());
    public static final BlockItem BIRCH_CHEST = new BlockItem(McvBlockInit.BIRCH_CHEST, new Item.Properties());
    public static final BlockItem JUNGLE_CHEST = new BlockItem(McvBlockInit.JUNGLE_CHEST, new Item.Properties());
    public static final BlockItem ACACIA_CHEST = new BlockItem(McvBlockInit.ACACIA_CHEST, new Item.Properties());
    public static final BlockItem DARK_OAK_CHEST = new BlockItem(McvBlockInit.DARK_OAK_CHEST, new Item.Properties());
    public static final BlockItem MANGROVE_CHEST = new BlockItem(McvBlockInit.MANGROVE_CHEST, new Item.Properties());
    public static final BlockItem CHERRY_CHEST = new BlockItem(McvBlockInit.CHERRY_CHEST, new Item.Properties());
    public static final BlockItem BAMBOO_CHEST = new BlockItem(McvBlockInit.BAMBOO_CHEST, new Item.Properties());
    public static final BlockItem CRIMSON_CHEST = new BlockItem(McvBlockInit.CRIMSON_CHEST, new Item.Properties());
    public static final BlockItem WARPED_CHEST = new BlockItem(McvBlockInit.WARPED_CHEST, new Item.Properties());

    public static final BlockItem OAK_TRAPPED_CHEST = new BlockItem(McvBlockInit.OAK_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem SPRUCE_TRAPPED_CHEST = new BlockItem(McvBlockInit.SPRUCE_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem BIRCH_TRAPPED_CHEST = new BlockItem(McvBlockInit.BIRCH_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem JUNGLE_TRAPPED_CHEST = new BlockItem(McvBlockInit.JUNGLE_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem ACACIA_TRAPPED_CHEST = new BlockItem(McvBlockInit.ACACIA_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem DARK_OAK_TRAPPED_CHEST = new BlockItem(McvBlockInit.DARK_OAK_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem MANGROVE_TRAPPED_CHEST = new BlockItem(McvBlockInit.MANGROVE_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem CHERRY_TRAPPED_CHEST = new BlockItem(McvBlockInit.CHERRY_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem BAMBOO_TRAPPED_CHEST = new BlockItem(McvBlockInit.BAMBOO_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem CRIMSON_TRAPPED_CHEST = new BlockItem(McvBlockInit.CRIMSON_TRAPPED_CHEST, new Item.Properties());
    public static final BlockItem WARPED_TRAPPED_CHEST = new BlockItem(McvBlockInit.WARPED_TRAPPED_CHEST, new Item.Properties());
    
    public static final Item WARPED_CHEST_MINECART = new MoreChestMinecartItem(McvBlockInit.WARPED_CHEST, new Item.Properties().stacksTo(1));
    
    public static void registerItems() {
        registerChestItems(OAK_CHEST, OAK_TRAPPED_CHEST, Items.CHEST, Items.TRAPPED_CHEST);
        registerChestItems(SPRUCE_CHEST, SPRUCE_TRAPPED_CHEST, OAK_CHEST, OAK_TRAPPED_CHEST);
        registerChestItems(BIRCH_CHEST, BIRCH_TRAPPED_CHEST, SPRUCE_CHEST, SPRUCE_TRAPPED_CHEST);
        registerChestItems(JUNGLE_CHEST, JUNGLE_TRAPPED_CHEST, BIRCH_CHEST, BIRCH_TRAPPED_CHEST);
        registerChestItems(ACACIA_CHEST, ACACIA_TRAPPED_CHEST, JUNGLE_CHEST, JUNGLE_TRAPPED_CHEST);
        registerChestItems(DARK_OAK_CHEST, DARK_OAK_TRAPPED_CHEST, ACACIA_CHEST, ACACIA_TRAPPED_CHEST);
        registerChestItems(MANGROVE_CHEST, MANGROVE_TRAPPED_CHEST, DARK_OAK_CHEST, DARK_OAK_TRAPPED_CHEST);
        registerChestItems(CHERRY_CHEST, CHERRY_TRAPPED_CHEST, MANGROVE_CHEST, MANGROVE_TRAPPED_CHEST);
        registerChestItems(BAMBOO_CHEST, BAMBOO_TRAPPED_CHEST, CHERRY_CHEST, CHERRY_TRAPPED_CHEST);
        registerChestItems(CRIMSON_CHEST, CRIMSON_TRAPPED_CHEST, BAMBOO_CHEST, BAMBOO_TRAPPED_CHEST);
        registerChestItems(WARPED_CHEST, WARPED_TRAPPED_CHEST, CRIMSON_CHEST, CRIMSON_TRAPPED_CHEST);

        registerItem(WARPED_CHEST_MINECART, "warped_chest_minecart");

        addAfterItem(OAK_CHEST, Items.CHEST, CreativeModeTabs.REDSTONE_BLOCKS);
        addAfterItem(OAK_TRAPPED_CHEST, Items.TRAPPED_CHEST, CreativeModeTabs.REDSTONE_BLOCKS);
    }

    private static void registerChestItems(BlockItem chest, BlockItem trappedChest, Item chestAfter, Item trappedAfter) {
        registerItem(chest, ((MoreChestBlock) chest.getBlock()).chestType + "_chest");
        registerItem(trappedChest, ((MoreTrappedChestBlock) trappedChest.getBlock()).chestType + "_trapped_chest");

        addAfterItem(chest, chestAfter, CreativeModeTabs.FUNCTIONAL_BLOCKS);
        addAfterItem(trappedChest, trappedAfter, CreativeModeTabs.SEARCH);
    }

    private static void registerItem(Item item, String name) {
        Registry.register(BuiltInRegistries.ITEM, MoreChestVariants.asId(name), item);
    }


    private static void addAfterItem(Item item, Item after, ResourceKey<CreativeModeTab> tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.addAfter(after, item));
    }
}