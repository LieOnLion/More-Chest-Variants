package io.github.lieonlion.mcv.client.renderer.layer;

import net.minecraft.client.model.ChestedHorseModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import org.joml.Vector3f;

public class HorseChestLayer extends ChestLayer<AbstractChestedHorse, ChestedHorseModel<AbstractChestedHorse>> {
    /*
        Big thanks to Khajiitos for the code for this to work, taken from Chested Companions.

        Go check it out! :)
        https://github.com/Khajiitos/ChestedCompanions/
        https://www.curseforge.com/minecraft/mc-mods/chested-companions
        https://modrinth.com/mod/chested-companions
    */
    public HorseChestLayer(RenderLayerParent<AbstractChestedHorse, ChestedHorseModel<AbstractChestedHorse>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    protected Vector3f positionChests() {
        return new Vector3f(6, 3, 5);
    }
}
