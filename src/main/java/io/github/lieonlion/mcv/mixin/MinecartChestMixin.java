package io.github.lieonlion.mcv.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.lieonlion.mcv.init.McvBlockInit;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecartContainer;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecartChest.class)
public abstract class MinecartChestMixin extends AbstractMinecartContainer {
    @Unique
    private static final EntityDataAccessor<String> DATA_ID_CHEST_TYPE = SynchedEntityData.defineId(MinecartChestMixin.class, EntityDataSerializers.STRING);

    public MinecartChestMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public MinecartChestMixin(EntityType<?> entityType, Level level, String chestType) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_CHEST_TYPE, "oak");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putString("ChestType", this.getChestType());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("ChestType", 8)) {
            this.setChestType(compoundTag.getString("ChestType"));
        }
    }

    @Unique
    public void setChestType(String type) {
        this.entityData.set(DATA_ID_CHEST_TYPE, type);
    }

    @Unique
    public String getChestType() {
        return this.entityData.get(DATA_ID_CHEST_TYPE);
    }

    @ModifyReturnValue(method = "getDefaultDisplayBlockState", at = @At(value = "RETURN"))
    public @NotNull BlockState getDefaultDisplayBlockState(BlockState original) {
        Block chest;

        switch (this.getChestType()) {
            case "acacia" -> chest = McvBlockInit.ACACIA_CHEST;
            case "bamboo" -> chest = McvBlockInit.BAMBOO_CHEST;
            case "birch" -> chest = McvBlockInit.BIRCH_CHEST;
            case "cherry" -> chest = McvBlockInit.CHERRY_CHEST;
            case "crimson" -> chest = McvBlockInit.CRIMSON_CHEST;
            case "dark_oak" -> chest = McvBlockInit.DARK_OAK_CHEST;
            case "jungle" -> chest = McvBlockInit.JUNGLE_CHEST;
            case "mangrove" -> chest = McvBlockInit.MANGROVE_CHEST;
            case "spruce" -> chest = McvBlockInit.SPRUCE_CHEST;
            case "warped" -> chest = McvBlockInit.WARPED_CHEST;
            default -> chest = McvBlockInit.OAK_CHEST;
        }

        return chest.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH);
    }
}
