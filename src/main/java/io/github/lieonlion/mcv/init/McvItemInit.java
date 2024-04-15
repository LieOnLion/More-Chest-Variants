package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class McvItemInit {
    public static final BlockItem OAK_CHEST_I = new BlockItem(McvBlockInit.OAK_CHEST, new Item.Settings());
    public static final BlockItem SPRUCE_CHEST_I = new BlockItem(McvBlockInit.SPRUCE_CHEST, new Item.Settings());
    public static final BlockItem BIRCH_CHEST_I = new BlockItem(McvBlockInit.BIRCH_CHEST, new Item.Settings());
    public static final BlockItem JUNGLE_CHEST_I = new BlockItem(McvBlockInit.JUNGLE_CHEST, new Item.Settings());
    public static final BlockItem ACACIA_CHEST_I = new BlockItem(McvBlockInit.ACACIA_CHEST, new Item.Settings());
    public static final BlockItem DARK_OAK_CHEST_I = new BlockItem(McvBlockInit.DARK_OAK_CHEST, new Item.Settings());
    public static final BlockItem MANGROVE_CHEST_I = new BlockItem(McvBlockInit.MANGROVE_CHEST, new Item.Settings());
    public static final BlockItem CHERRY_CHEST_I = new BlockItem(McvBlockInit.CHERRY_CHEST, new Item.Settings());
    public static final BlockItem BAMBOO_CHEST_I = new BlockItem(McvBlockInit.BAMBOO_CHEST, new Item.Settings());
    public static final BlockItem CRIMSON_CHEST_I = new BlockItem(McvBlockInit.CRIMSON_CHEST, new Item.Settings());
    public static final BlockItem WARPED_CHEST_I = new BlockItem(McvBlockInit.WARPED_CHEST, new Item.Settings());
    public static final BlockItem OAK_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.OAK_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem SPRUCE_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.SPRUCE_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem BIRCH_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.BIRCH_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem JUNGLE_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.JUNGLE_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem ACACIA_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.ACACIA_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem DARK_OAK_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.DARK_OAK_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem MANGROVE_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.MANGROVE_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem CHERRY_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.CHERRY_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem BAMBOO_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.BAMBOO_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem CRIMSON_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.CRIMSON_TRAPPED_CHEST, new Item.Settings());
    public static final BlockItem WARPED_TRAPPED_CHEST_I = new BlockItem(McvBlockInit.WARPED_TRAPPED_CHEST, new Item.Settings());

    public static void registerItems() {
        registerItem("oak", OAK_CHEST_I, OAK_TRAPPED_CHEST_I, Items.CHEST, Items.TRAPPED_CHEST);
        registerItem("spruce", SPRUCE_CHEST_I, SPRUCE_TRAPPED_CHEST_I, OAK_CHEST_I, OAK_TRAPPED_CHEST_I);
        registerItem("birch", BIRCH_CHEST_I, BIRCH_TRAPPED_CHEST_I, SPRUCE_CHEST_I, SPRUCE_TRAPPED_CHEST_I);
        registerItem("jungle", JUNGLE_CHEST_I, JUNGLE_TRAPPED_CHEST_I, BIRCH_CHEST_I, BIRCH_TRAPPED_CHEST_I);
        registerItem("acacia", ACACIA_CHEST_I, ACACIA_TRAPPED_CHEST_I, JUNGLE_CHEST_I, JUNGLE_TRAPPED_CHEST_I);
        registerItem("dark_oak", DARK_OAK_CHEST_I, DARK_OAK_TRAPPED_CHEST_I, ACACIA_CHEST_I, ACACIA_TRAPPED_CHEST_I);
        registerItem("mangrove", MANGROVE_CHEST_I, MANGROVE_TRAPPED_CHEST_I, DARK_OAK_CHEST_I, DARK_OAK_TRAPPED_CHEST_I);
        registerItem("cherry", CHERRY_CHEST_I, CHERRY_TRAPPED_CHEST_I, MANGROVE_CHEST_I, MANGROVE_TRAPPED_CHEST_I);
        registerItem("bamboo", BAMBOO_CHEST_I, BAMBOO_TRAPPED_CHEST_I, CHERRY_CHEST_I, CHERRY_TRAPPED_CHEST_I);
        registerItem("crimson", CRIMSON_CHEST_I, CRIMSON_TRAPPED_CHEST_I, BAMBOO_CHEST_I, BAMBOO_TRAPPED_CHEST_I);
        registerItem("warped", WARPED_CHEST_I, WARPED_TRAPPED_CHEST_I, CRIMSON_CHEST_I, CRIMSON_TRAPPED_CHEST_I);
    }

    private static void registerItem(String name, Item chest, Item trappedChest, Item chestAfter, Item trappedAfter) {
        Registry.register(Registries.ITEM, new Identifier(MoreChestVariants.MODID, name + "_chest"), chest);
        Registry.register(Registries.ITEM, new Identifier(MoreChestVariants.MODID, name + "_trapped_chest"), trappedChest);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(chestAfter, chest));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.addAfter(chestAfter,chest));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.addAfter(trappedAfter, trappedChest));
    }
}