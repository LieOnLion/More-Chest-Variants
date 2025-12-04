package io.github.lieonlion.mcv.events;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.world.level.block.ChestBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import java.util.Objects;

@EventBusSubscriber(modid = MoreChestVariants.MODID)
public class MoreChestVariantsEvents {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, McvBlockInit.MORE_CHEST_BLOCK_ENTITY.get(),
            ((be, direction) -> new InvWrapper(
                Objects.requireNonNull(ChestBlock.getContainer(be.getBlock(), be.getBlockState(), Objects.requireNonNull(be.getLevel()), be.getBlockPos(), true)))
            )
        );
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, McvBlockInit.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(),
            ((be, direction) -> new InvWrapper(
                Objects.requireNonNull(ChestBlock.getContainer(be.getBlock(), be.getBlockState(), Objects.requireNonNull(be.getLevel()), be.getBlockPos(), true)))
            )
        );
    }
}
