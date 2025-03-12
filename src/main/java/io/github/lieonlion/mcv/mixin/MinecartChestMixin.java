package io.github.lieonlion.mcv.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.init.McvBlockInit;
import io.github.lieonlion.mcv.util.IMinecartChest;
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
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecartChest.class)
public abstract class MinecartChestMixin extends AbstractMinecartContainer implements IMinecartChest {
    @Unique
    @SuppressWarnings("all")
    private static final EntityDataAccessor<BlockState> mcv$DATA_ID_BLOCK = SynchedEntityData.defineId(MinecartChest.class, EntityDataSerializers.BLOCK_STATE);

    public MinecartChestMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(mcv$DATA_ID_BLOCK, McvBlockInit.OAK_CHEST.defaultBlockState());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        MoreChestVariants.LOGGER.info(this.mcv$getBlock().toString());
        compoundTag.put("Block", NbtUtils.writeBlockState(this.mcv$getBlock()));
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("Block", CompoundTag.TAG_COMPOUND)) {
            this.mcv$setBlock(NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), compoundTag.getCompound("Block")));
        }
    }

    @Unique
    public BlockState mcv$getBlock() {
        return this.getEntityData().get(mcv$DATA_ID_BLOCK);
    }

    @Unique
    public void mcv$setBlock(BlockState state) {
        this.getEntityData().set(mcv$DATA_ID_BLOCK, state);
    }

    @ModifyReturnValue(method = "getDefaultDisplayBlockState", at = @At(value = "RETURN"))
    public @NotNull BlockState getDefaultDisplayBlockState(BlockState original) {
        return this.mcv$getBlock();
    }
}
