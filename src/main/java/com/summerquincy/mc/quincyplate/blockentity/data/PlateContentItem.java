package com.summerquincy.mc.quincyplate.blockentity.data;

import net.minecraft.world.item.ItemStack;

public class PlateContentItem {
    private ItemStack item;
    private final double posX;
    private final double posZ;
    private final double rotation;

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosZ() {
        return posZ;
    }

    public double getRotation() {
        return rotation;
    }

    public PlateContentItem(ItemStack item, double posX, double posZ, double rotation) {
        this.item = item;
        this.posX = posX;
        this.posZ = posZ;
        this.rotation = rotation;
    }

}
