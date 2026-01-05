package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import com.summerquincy.mc.quincyplate.util.DistanceHelper;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class RoundPlateBlock extends PlateBlock {
    private static final double PLACING_RADIUS = (12 - 8) / 16.0 - PlateBlockEntityRenderer.ITEM_SIZE / 2 - 0.01;
    //-0.01是为了防止物品贴图边界超出边框
    private static final double INTERACT_RADIUS = (14 - 8) / 16.0;//距离中心点超过这个值就直接不处理

    protected RoundPlateBlock(Properties p, double width, double height) {
        super(p, width, height);
    }

    @Override
    protected boolean shouldIgnore(double x, double z) {
        return !DistanceHelper.isDistanceWithinScope(x, z, 0.5, 0.5, INTERACT_RADIUS);
    }

    @Override
    protected PlatePos getModifiedPos(double x, double z) {
        if (!DistanceHelper.isDistanceWithinScope(x, z, 0.5, 0.5, PLACING_RADIUS)) {
            double theta = Math.atan2(z - 0.5, x - 0.5);
            x = 0.5 + PLACING_RADIUS * cos(theta);
            z = 0.5 + PLACING_RADIUS * sin(theta);
        }
        return new PlatePos(x, z);
    }
}
