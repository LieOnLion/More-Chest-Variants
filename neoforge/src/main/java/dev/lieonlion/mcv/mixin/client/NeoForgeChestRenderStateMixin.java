package dev.lieonlion.mcv.mixin.client;

import dev.lieonlion.mcv.access.ChestRenderStateAccess;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ChestRenderState.class)
public class NeoForgeChestRenderStateMixin implements ChestRenderStateAccess {
    @Unique
    public boolean lolmcv$moreChest;
    @Unique
    public boolean lolmcv$trapped;
    @Unique
    public String lolmcv$woodVariant;


    public NeoForgeChestRenderStateMixin() {
        lolmcv$moreChest = false;
        lolmcv$trapped = false;
        lolmcv$woodVariant = "";
    }

    @Override
    public boolean lolmcv$isMoreChest() {
        return lolmcv$moreChest;
    }

    @Override
    public boolean lolmcv$isTrapped() {
        return lolmcv$trapped;
    }

    @Override
    public String lolmcv$woodVariant() {
        return lolmcv$woodVariant;
    }

    @Override
    public void lolmcv$setMoreChest(boolean b) {
        lolmcv$moreChest = b;
    }

    @Override
    public void lolmcv$setTrapped(boolean b) {
        lolmcv$trapped = b;
    }

    @Override
    public void lolmcv$setWoodVariant(String s) {
        lolmcv$woodVariant = s;
    }
}
