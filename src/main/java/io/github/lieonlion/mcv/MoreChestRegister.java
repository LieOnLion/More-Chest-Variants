package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.blocks.MoreChestBlock;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import io.github.lieonlion.mcv.client.MoreChestRenderManager;
import io.github.lieonlion.mcv.blocks.MoreChestBlockEntity;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.function.Consumer;

public class MoreChestRegister {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChestVariants.MODID);
    private static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoreChestVariants.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreChestVariants.MODID);

    public static RegistryObject<MoreChestBlock>[] chests = new RegistryObject[MoreChestEnum.VALUES.length];
    public static RegistryObject<BlockEntityType<MoreChestBlockEntity>> CHEST_TILE_TYPE;

    public static void register() {
        for (MoreChestEnum type : MoreChestEnum.VALUES) {
            String name = type.getId();

            RegistryObject<MoreChestBlock> chestObject = BLOCKS.register(name, () -> new MoreChestBlock(type, type.getMapColour()));
            chests[type.ordinal()] = chestObject;

            RegistryObject<BlockItem> chestItem = ITEMS.register(name, () -> new BlockItem(chestObject.get(), new Item.Properties()){
                @Override
                public void initializeClient(Consumer<IClientItemExtensions> consumer) {
                    super.initializeClient(consumer);

                    consumer.accept(new IClientItemExtensions() {
                        @Override
                        public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                            return MoreChestRenderManager.INSTANCE;
                        }
                    });
                }
            });
        }

        CHEST_TILE_TYPE = TILE_ENTITIES.register("chest_tile", () -> BlockEntityType.Builder.of(MoreChestBlockEntity::new, Arrays.stream(chests).map(RegistryObject::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
