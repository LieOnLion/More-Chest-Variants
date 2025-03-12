package io.github.lieonlion.mcv.client.mixin;

import io.github.lieonlion.mcv.client.mixin.accessor.LlamaModelAccessor;
import net.minecraft.client.model.LlamaModel;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LlamaModel.class)
public class LlamaModelMixin<T extends AbstractChestedHorse> {
    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/animal/horse/AbstractChestedHorse;FFFFF)V", at = @At(value = "TAIL"))
    public void disableChests (T abstractChestedHorse, float f, float g, float h, float i, float j, CallbackInfo ci) {
        ((LlamaModelAccessor) this).getLeftChest().visible = false;
        ((LlamaModelAccessor) this).getRightChest().visible = false;
    }
}
