package io.github.lieonlion.mcv.config;

public interface IMoreChestVariantsConfig {
    IMoreChestVariantsConfig DEFAULT = () -> true;

    boolean displayStarWarsTextures();
}
