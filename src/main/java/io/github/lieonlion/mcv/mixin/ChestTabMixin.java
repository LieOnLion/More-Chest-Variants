package io.github.lieonlion.mcv.mixin;

import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Supplier;

@Mixin(CreativeModeTabs.class)
public class ChestTabMixin {
    @ModifyArg(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/CreativeModeTab$Builder;icon(Ljava/util/function/Supplier;)Lnet/minecraft/world/item/CreativeModeTab$Builder;", ordinal = 13))
    private static Supplier<ItemStack> bootstrap(Supplier<ItemStack> iconSupplier) {
        return () -> new ItemStack(McvBlockInit.OAK_CHEST.get());
    }
}