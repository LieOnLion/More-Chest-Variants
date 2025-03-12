package io.github.lieonlion.mcv.tag;

import io.github.lieonlion.mcv.MoreChestVariants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class McvItemTags {
    public static final TagKey<Item> PET_CHEST = createTag("pet_chest");

    private static TagKey<Item> createTag(String name) {
        return TagKey.create(Registries.ITEM, MoreChestVariants.asId(name));
    }
}
