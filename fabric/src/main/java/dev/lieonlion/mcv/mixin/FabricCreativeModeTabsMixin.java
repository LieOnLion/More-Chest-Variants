package dev.lieonlion.mcv.mixin;

import dev.lieonlion.mcv.init.FabricMoreChestVariantsItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Supplier;

@Mixin(CreativeModeTabs.class)
public class FabricCreativeModeTabsMixin {
    @ModifyArg(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/CreativeModeTab$Builder;icon(Ljava/util/function/Supplier;)Lnet/minecraft/world/item/CreativeModeTab$Builder;", ordinal = 13))
    private static Supplier<ItemStack> applyChestTabIcon(Supplier<ItemStack> iconSupplier) {
        return () -> new ItemStack(FabricMoreChestVariantsItems.OAK_CHEST_I);
    }
}
