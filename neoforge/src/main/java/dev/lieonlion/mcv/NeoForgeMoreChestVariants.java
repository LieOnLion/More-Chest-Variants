package dev.lieonlion.mcv;

import dev.lieonlion.mcv.init.NeoForgeMoreChestVariantsBlocks;
import dev.lieonlion.mcv.init.NeoForgeMoreChestVariantsItems;
import dev.lieonlion.mcv.integration.NeoForgeModMenuIntegration;
import net.minecraft.world.level.block.ChestBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.transfer.item.VanillaContainerWrapper;

import java.util.List;
import java.util.Objects;

@Mod(MoreChestVariants.MOD_ID)
public class NeoForgeMoreChestVariants {
    public NeoForgeMoreChestVariants(IEventBus bus) {
        MoreChestVariants.init();
        NeoForgeModMenuIntegration.registerConfigScreen();

        NeoForgeMoreChestVariantsBlocks.register(bus);
        NeoForgeMoreChestVariantsItems.register(bus);

        bus.addListener(NeoForgeMoreChestVariantsItems::addItemsToTab);
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.Item.BLOCK, NeoForgeMoreChestVariantsBlocks.MORE_CHEST_BLOCK_ENTITY.get(),
            ((be, direction) -> VanillaContainerWrapper.of(
                Objects.requireNonNull(ChestBlock.getContainer(be.getMoreChestBlock(), be.getBlockState(), Objects.requireNonNull(be.getLevel()), be.getBlockPos(), true)))
            )
        );
        event.registerBlockEntity(Capabilities.Item.BLOCK, NeoForgeMoreChestVariantsBlocks.MORE_TRAPPED_CHEST_BLOCK_ENTITY.get(),
            ((be, direction) -> VanillaContainerWrapper.of(
                Objects.requireNonNull(ChestBlock.getContainer(be.getMoreChestBlock(), be.getBlockState(), Objects.requireNonNull(be.getLevel()), be.getBlockPos(), true)))
            )
        );
    }
}