package io.github.lieonlion.mcv.blocks;

import io.github.lieonlion.mcv.init.blockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class MoreChestBlock extends ChestBlock {
    public static final Map<MoreChestEnum, DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>>> MENU_PROVIDER_COMBINER = new LinkedHashMap<>();
    public final MoreChestEnum chestType;

    public MoreChestBlock(MoreChestEnum chestType) {
        super(Properties.ofFullCopy(Blocks.CHEST).mapColor(chestType.getMapColour()), chestType::getChestEntity);
        this.chestType = chestType;

        registerMaterialNameRetriever(chestType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBlockEntity(this.chestType, pos, state);
    }

    protected static DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> registerMaterialNameRetriever(MoreChestEnum type) {
        if (!MENU_PROVIDER_COMBINER.containsKey(type)) {
            DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> nameRetriever = new DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>>() {
                public Optional<MenuProvider> acceptDouble(ChestBlockEntity chestBlockEntity, ChestBlockEntity chestBlockEntity2) {
                    final Container container = new CompoundContainer(chestBlockEntity, chestBlockEntity2);
                    return Optional.of(new MenuProvider() {
                        @Nullable
                        public AbstractContainerMenu createMenu(int p_51622_, Inventory p_51623_, Player p_51624_) {
                            if (chestBlockEntity.canOpen(p_51624_) && chestBlockEntity2.canOpen(p_51624_)) {
                                chestBlockEntity.unpackLootTable(p_51623_.player);
                                chestBlockEntity2.unpackLootTable(p_51623_.player);
                                return ChestMenu.sixRows(p_51622_, p_51623_, container);
                            } else {
                                return null;
                            }
                        }

                        public Component getDisplayName() {
                            if (chestBlockEntity.hasCustomName()) {
                                return chestBlockEntity.getDisplayName();
                            } else {
                                return (Component) (chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() :
                                        Component.translatable("container.lolmcv." + type.name() + "_chestDouble"));
                            }
                        }
                    });
                }

                public Optional<MenuProvider> acceptSingle(ChestBlockEntity chestBlockEntity) {
                    return Optional.of(chestBlockEntity);
                }

                public Optional<MenuProvider> acceptNone() {
                    return Optional.empty();
                }
            };
            MENU_PROVIDER_COMBINER.put(type, nameRetriever);
        }
        return MENU_PROVIDER_COMBINER.get(type);
    }

    @Override
    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return ((Optional<MenuProvider>)this.combine(state, level, pos, false)
                .apply(MENU_PROVIDER_COMBINER.get(this.chestType))).orElse((MenuProvider)null);
    }
}