package io.github.lieonlion.mcv.client.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;

@Mixin(ChestRenderer.class)
public class ChestRendererMixin {
    @Unique
    private boolean lolmcv$starwars;

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void starwars(BlockEntityRendererProvider.Context context, CallbackInfo ci) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5) {
            this.lolmcv$starwars = true;
        }
    }

    @WrapOperation(method = "getMaterial", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/Sheets;chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;"))
    private Material getChestMaterial(BlockEntity blockEntity, ChestType chestType, boolean bl, Operation<Material> original) {
        if (lolmcv$starwars) {
            return lolmcv$chooseMaterial(chestType, lolmcv$getChestPath("starwars_left"), lolmcv$getChestPath("starwars_right"), lolmcv$getChestPath("starwars"));
        } else if (blockEntity.getBlockState().getBlock() instanceof MoreChestBlock moreChestBlock && !bl) {
            return lolmcv$chooseMaterial(chestType, lolmcv$getChestPath(moreChestBlock.woodType + "_left"),
                    lolmcv$getChestPath(moreChestBlock.woodType + "_right"), lolmcv$getChestPath(moreChestBlock.woodType));
        }
        return original.call(blockEntity, chestType, bl);
    }

    @Unique
    private static Material lolmcv$getChestPath(String path) {
        return new Material(Sheets.CHEST_SHEET, MoreChestVariants.asId("entity/chest/" + path));
    }

    @Unique
    private static Material lolmcv$chooseMaterial(ChestType type, Material left, Material right, Material single) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
    }
}
