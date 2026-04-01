package dev.lieonlion.mcv.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import dev.lieonlion.mcv.MoreChestVariants;
import dev.lieonlion.mcv.access.ChestRenderStateAccess;
import dev.lieonlion.mcv.block.MoreChestBlock;
import dev.lieonlion.mcv.block.MoreTrappedChestBlock;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;

@Mixin(ChestRenderer.class)
public class NeoForgeChestRendererMixin {
    @Unique
    private final boolean lolmcv$starwars = lolmcv$starwars();

    @Unique
    private boolean lolmcv$starwars() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(2) + 1 == 5 && calendar.get(5) >= 3 && calendar.get(5) <= 5);
    }

    @WrapOperation(method = "submit(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/Sheets;chooseSprite(Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState$ChestMaterialType;Lnet/minecraft/world/level/block/state/properties/ChestType;)Lnet/minecraft/client/resources/model/sprite/SpriteId;"))
    private SpriteId lolmcv$getChestMaterial(ChestRenderState.ChestMaterialType chestMaterialType, ChestType type, Operation<SpriteId> original, @Local ChestRenderState chestRenderState) {
        if (!ChestRenderer.xmasTextures() && chestRenderState instanceof ChestRenderStateAccess moreChestBlock && moreChestBlock.lolmcv$isMoreChest()) {
            if (lolmcv$starwars && MoreChestVariants.CONFIG.displayStarWarsTextures()) {
                return lolmcv$chooseMaterial(type, "starwars");
            } else if (moreChestBlock.lolmcv$isTrapped()) {
                return lolmcv$chooseMaterial(type, "trapped/" + moreChestBlock.lolmcv$woodVariant());
            } return lolmcv$chooseMaterial(type, moreChestBlock.lolmcv$woodVariant());
        } return original.call(chestMaterialType, type);
    }

    @Inject(method = "extractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V", at = @At(value = "RETURN"))
    private <T extends BlockEntity & LidBlockEntity> void mixin(T blockEntity, ChestRenderState chestRenderState, float f, Vec3 vec3, ModelFeatureRenderer.CrumblingOverlay crumblingOverlay, CallbackInfo ci) {
        var access = ((ChestRenderStateAccess) chestRenderState);
        if (blockEntity.getBlockState().getBlock() instanceof MoreChestBlock moreChestBlock) {
            access.lolmcv$setMoreChest(true);
            access.lolmcv$setTrapped(blockEntity.getBlockState().getBlock() instanceof MoreTrappedChestBlock);
            access.lolmcv$setWoodVariant(moreChestBlock.woodType);
        }
    }

    @Unique
    private static SpriteId lolmcv$getChestPath(String path) {
        return Sheets.CHEST_MAPPER.apply(MoreChestVariants.location(path));
    }

    @Unique
    private static SpriteId lolmcv$chooseMaterial(ChestType type, String path) {
        return switch (type) {
            case LEFT -> lolmcv$getChestPath(path + "_left");
            case RIGHT -> lolmcv$getChestPath(path + "_right");
            default -> lolmcv$getChestPath(path);
        };
    }
}
