package io.github.lieonlion.mcv.util;

import net.minecraft.world.item.ItemStack;

public interface IChestEntity {
    ItemStack mcv$getChestItemStack();
    void mcv$setChestItemStack(ItemStack stack);
    default Boolean mcv$hasChestItemStack() {
        return !this.mcv$getChestItemStack().isEmpty();
    }
}
