package io.github.lieonlion.mcv.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.util.IMinecartChest;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecartContainer;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecartChest.class)
public abstract class MinecartChestMixin extends AbstractMinecartContainer implements IMinecartChest {
    @Unique
    private static final EntityDataAccessor<BlockState> DATA_ID_CHEST = SynchedEntityData.defineId(MinecartChestMixin.class, EntityDataSerializers.BLOCK_STATE);

    public MinecartChestMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_CHEST, mcv$getChestState(McvBlockInit.OAK_CHEST));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.put("Chest", NbtUtils.writeBlockState(this.mcv$getChestType()));
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("Chest", 8)) {
            this.mcv$setChestType(NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compoundTag.getCompound("Chest")));
        }
    }

    @Unique
    public BlockState mcv$getChestType() {
        return this.entityData.get(DATA_ID_CHEST);
    }

    @Unique
    public void mcv$setChestType(BlockState state) {
        this.entityData.set(DATA_ID_CHEST, state);
    }

    @Unique
    public BlockState mcv$getChestState(ChestBlock chest) {
        return chest.defaultBlockState().setValue(ChestBlock.FACING, Direction.NORTH);
    }

    @ModifyReturnValue(method = "getDefaultDisplayBlockState", at = @At(value = "RETURN"))
    public @NotNull BlockState getDefaultDisplayBlockState(BlockState original) {
        return this.mcv$getChestType();
    }
}
