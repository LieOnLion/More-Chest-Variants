package io.github.lieonlion.mcv.config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.platform.YACLPlatform;
import io.github.lieonlion.mcv.MoreChestVariants;
import net.minecraft.network.chat.Component;

public class MoreChestVariantsConfigYACL implements IMoreChestVariantsConfig {
    public static ConfigClassHandler<MoreChestVariantsConfigYACL> HANDLER = ConfigClassHandler.createBuilder(MoreChestVariantsConfigYACL.class)
        .id(MoreChestVariants.location("more_chest_variants"))
        .serializer(config -> GsonConfigSerializerBuilder.create(config)
            .setPath(YACLPlatform.getConfigDir().resolve("more_chest_variants.json5"))
            .setJson5(true)
            .build())
        .build();

    @SerialEntry
    public static boolean displayStarWarsTextures = DEFAULT.displayStarWarsTextures();

    @Override
    public boolean displayStarWarsTextures() {
        return displayStarWarsTextures;
    }

    public static ConfigCategory getConfigCategory() {
        return ConfigCategory.createBuilder()
            .name(Component.translatable("lolmcv.config.category.main"))
            .option(Option.<Boolean>createBuilder()
                .name(Component.translatable("lolmcv.config.option.displayStarWarsTextures.name"))
                .description(OptionDescription.of(Component.translatable("lolmcv.config.option.displayStarWarsTextures.description")))
                .binding(DEFAULT.displayStarWarsTextures(), () -> displayStarWarsTextures, value -> displayStarWarsTextures = value)
                .controller(BooleanControllerBuilder::create)
                .build())
            .build();
    }
}
