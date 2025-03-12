package io.github.lieonlion.mcv.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.tag.McvItemTags;
import io.github.lieonlion.mcv.util.IChestEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractChestedHorse.class)
public abstract class AbstractChestedHorseMixin extends AbstractHorse implements IChestEntity {
    @Shadow public abstract boolean hasChest();

    @Shadow public abstract void setChest(boolean bl);

    @Unique
    @SuppressWarnings("all")
    private static final EntityDataAccessor<ItemStack> mcv$DATA_ID_CHEST_ITEM = SynchedEntityData.defineId(AbstractChestedHorse.class, EntityDataSerializers.ITEM_STACK);

    protected AbstractChestedHorseMixin(EntityType<? extends AbstractHorse> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ItemStack mcv$getChestItemStack() {
        return this.getEntityData().get(mcv$DATA_ID_CHEST_ITEM);
    }



    @Override
    public void mcv$setChestItemStack(ItemStack stack) {
        this.getEntityData().set(mcv$DATA_ID_CHEST_ITEM, stack);
    }

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    public void defineSynchedData(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(mcv$DATA_ID_CHEST_ITEM, ItemStack.EMPTY);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    public void addAdditionalSaveData(CompoundTag compoundTag, CallbackInfo ci) {
        if (!this.mcv$getChestItemStack().isEmpty()) {
            compoundTag.put("ChestItem", this.mcv$getChestItemStack().save(this.registryAccess()));
        }
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    public void readAdditionalSaveData(CompoundTag compoundTag, CallbackInfo ci) {
        if (this.hasChest() && compoundTag.contains("ChestItem", CompoundTag.TAG_COMPOUND)) {
            ItemStack stack = ItemStack.parse(this.registryAccess(), compoundTag.getCompound("ChestItem")).orElse(ItemStack.EMPTY);
            this.mcv$setChestItemStack(stack);
        }
    }

    @WrapOperation(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    public boolean isChestItem(ItemStack instance, Item item, Operation<Boolean> original) {
        return instance.is(McvItemTags.PET_CHEST);
    }

    @Inject(method = "equipChest", at = @At("HEAD"))
    private void equipChest(Player player, ItemStack itemStack, CallbackInfo ci) {
        this.mcv$setChestItemStack(itemStack.getItem().getDefaultInstance());
    }
}
