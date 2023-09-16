package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.blocks.MoreChestBlock;
import io.github.lieonlion.mcv.blocks.MoreChestEnum;
import io.github.lieonlion.mcv.client.MoreChestRenderManager;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class blocksInit {
    private blocksInit() {}
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChestVariants.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreChestVariants.MODID);
    public static RegistryObject<MoreChestBlock>[] chestsB = new RegistryObject[MoreChestEnum.VALUES.length];

    public static void registerBlock(){
        for (MoreChestEnum chestType : MoreChestEnum.VALUES) {
            RegistryObject<MoreChestBlock> chestBlock = BLOCKS.register(chestType.getId(), () -> new MoreChestBlock(chestType, chestType.getMapColour()));
            chestsB[chestType.ordinal()] = chestBlock;

            RegistryObject<BlockItem> chestItem = ITEMS.register(chestType.getId(), () -> new BlockItem(chestBlock.get(), new Item.Properties()){
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

            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }
    }
}
