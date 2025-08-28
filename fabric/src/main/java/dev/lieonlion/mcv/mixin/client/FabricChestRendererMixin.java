package dev.lieonlion.mcv.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.lieonlion.mcv.MoreChestVariants;
import dev.lieonlion.mcv.block.MoreChestBlock;
import dev.lieonlion.mcv.block.MoreTrappedChestBlock;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Calendar;

@Mixin(ChestRenderer.class)
public class FabricChestRendererMixin {
    @Unique
    private final boolean lolmcv$starwars = lolmcv$starwars();

    @Unique
    private boolean lolmcv$starwars() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5);
    }

    @WrapOperation(method = "render(Lnet/minecraft/world/level/block/entity/BlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;IILnet/minecraft/world/phys/Vec3;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/Sheets;chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;"))
    private Material lolmcv$getChestMaterial(BlockEntity blockEntity, ChestType type, boolean xmas, Operation<Material> original) {
        if (!xmas && blockEntity.getBlockState().getBlock() instanceof MoreChestBlock moreChestBlock) {
            if (lolmcv$starwars) {
                return lolmcv$chooseMaterial(type, "starwars");
            } else if (moreChestBlock instanceof MoreTrappedChestBlock) {
                return lolmcv$chooseMaterial(type, "trapped/" + moreChestBlock.woodType);
            } return lolmcv$chooseMaterial(type, moreChestBlock.woodType);
        } return original.call(blockEntity, type, xmas);
    }

    @Unique
    private static Material lolmcv$getChestPath(String path) {
        return new Material(Sheets.CHEST_SHEET, MoreChestVariants.location("entity/chest/" + path));
    }

    @Unique
    private static Material lolmcv$chooseMaterial(ChestType type, String path) {
        return switch (type) {
            case LEFT -> lolmcv$getChestPath(path + "_left");
            case RIGHT -> lolmcv$getChestPath(path + "_right");
            default -> lolmcv$getChestPath(path);
        };
    }
}
