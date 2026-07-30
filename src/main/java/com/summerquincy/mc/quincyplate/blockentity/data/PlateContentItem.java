package com.summerquincy.mc.quincyplate.blockentity.data;

import net.minecraft.world.item.ItemStack;

public class PlateContentItem {
    private final ItemStack item;
    private final double posX;
    private final double posZ;
    private final double rotation;
    private int renderLayer = 0; //渲染时的层数，不需要持久保存，渲染时会动态计算。

    public ItemStack getItem() {
        return item;
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

    public void initLayer() {
        this.renderLayer = 0;
    }

    public void ensureStackOn(PlateContentItem onTopOf) { //确保该物品叠在onTopOf上面
        if (onTopOf.renderLayer >= renderLayer) {
            renderLayer = onTopOf.renderLayer + 1;
        }
    }

    public int getRenderLayer() {
        return renderLayer;
    }

    public PlateContentItem(ItemStack item, double posX, double posZ, double rotation) {
        this.item = item;
        this.posX = posX;
        this.posZ = posZ;
        this.rotation = rotation;
    }

}
