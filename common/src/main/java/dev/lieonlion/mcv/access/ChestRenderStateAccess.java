package dev.lieonlion.mcv.access;

public interface ChestRenderStateAccess {
    boolean lolmcv$isMoreChest();
    boolean lolmcv$isTrapped();
    String lolmcv$woodVariant();

    void lolmcv$setMoreChest(boolean b);
    void lolmcv$setTrapped(boolean b);
    void lolmcv$setWoodVariant(String s);
}
