package io.github.lieonlion.mcv.mixin;

import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Supplier;

@Mixin(ItemGroups.class)
public abstract class ItemGroupsMixin {
    @ModifyArg(method = "registerAndGetDefault", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemGroup$Builder;icon(Ljava/util/function/Supplier;)Lnet/minecraft/item/ItemGroup$Builder;", ordinal = 13))
    private static Supplier<ItemStack> applyChestTabIcon(Supplier<ItemStack> iconSupplier) {
        return () -> new ItemStack(McvBlockInit.OAK_CHEST);
    }
}