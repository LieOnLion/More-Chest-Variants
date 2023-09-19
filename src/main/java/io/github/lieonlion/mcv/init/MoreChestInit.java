package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.blocks.MoreChestBlock;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import io.github.lieonlion.mcv.blocks.MoreChestBlockEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class MoreChestInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChestVariants.MODID);
    private static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoreChestVariants.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreChestVariants.MODID);

    public static RegistryObject<MoreChestBlock>[] chests = new RegistryObject[MoreChestEnum.VALUES.length];
    public static RegistryObject<BlockEntityType<MoreChestBlockEntity>> chest_entity;

    public static void register() {
        for (MoreChestEnum type : MoreChestEnum.VALUES) {
            RegistryObject<MoreChestBlock> chest_block = BLOCKS.register(type.getId(), () -> new MoreChestBlock(type, type.getMapColour()));
            chests[type.ordinal()] = chest_block;

            ITEMS.register(type.getId(), () -> new BlockItem(chest_block.get(), new Item.Properties()));
        }

        chest_entity = TILE_ENTITIES.register("chest_tile", () -> BlockEntityType.Builder.of(MoreChestBlockEntity::new, Arrays.stream(chests).map(RegistryObject::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
