package com.summerquincy.mc.quincyplate.blockentity.data;

import net.minecraft.world.item.ItemStack;

public class PlateContentItem {
    private ItemStack item;
    private double posX;
    private double posZ;
    private double rotation;

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosZ() {
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public PlateContentItem(ItemStack item, double posX, double posZ, double rotation) {
        this.item = item;
        this.posX = posX;
        this.posZ = posZ;
        this.rotation = rotation;
    }

}
