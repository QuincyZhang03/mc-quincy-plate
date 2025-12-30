package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;

import static java.lang.Math.abs;

public class SquarePlateBlock extends PlateBlock {
    private static final double PLACING_WIDTH = (8 - 3.5) / 16.0 - PlateBlockEntityRenderer.ITEM_SIZE / 2 - 0.01;
    //-0.005是为了防止物品贴图边缘超出边框
    private static final double INTERACT_WIDTH = (8 - 2) / 16.0;

    protected SquarePlateBlock(Properties p, double width, double height) {
        super(p, width, height);
    }

    @Override
    protected boolean shouldIgnore(double x, double z) {
        return abs(x - 0.5) > INTERACT_WIDTH || abs(z - 0.5) > INTERACT_WIDTH;
    }

    @Override
    protected PlatePos getModifiedPos(double x, double z) {
        if (abs(x - 0.5) > PLACING_WIDTH)
            x = 0.5 + PLACING_WIDTH * (x > 0.5 ? 1 : -1);
        if (abs(z - 0.5) > PLACING_WIDTH)
            z = 0.5 + PLACING_WIDTH * (z > 0.5 ? 1 : -1);
        return new PlatePos(x, z);
    }
}
