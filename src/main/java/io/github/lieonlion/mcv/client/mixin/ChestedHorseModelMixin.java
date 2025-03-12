package io.github.lieonlion.mcv.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.model.ChestedHorseModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChestedHorseModel.class)
public class ChestedHorseModelMixin {
    @ModifyExpressionValue(method = "setupAnim(Lnet/minecraft/world/entity/animal/horse/AbstractChestedHorse;FFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/horse/AbstractChestedHorse;hasChest()Z"))
    public boolean disableChests (boolean original) {
        return false;
    }
}
