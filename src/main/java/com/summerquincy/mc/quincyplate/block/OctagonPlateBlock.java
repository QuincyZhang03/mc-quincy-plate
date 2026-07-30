package com.summerquincy.mc.quincyplate.block;

import com.mojang.serialization.MapCodec;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import com.summerquincy.mc.quincyplate.util.DistanceHelper;
import net.minecraft.world.level.block.BaseEntityBlock;
import org.jetbrains.annotations.NotNull;

import static java.lang.Math.*;

public class OctagonPlateBlock extends PlateBlock {
    private static final MapCodec<PlateBlock> CODEC = simpleCodec(RoundPlateBlock::new);

    private static final double PI_OVER_8 = Math.PI / 8;
    private static final double PI_OVER_4 = Math.PI / 4;
    private static final double COS_PI_OVER_8 = cos(PI_OVER_8);

    private static final double MAX_PLACING_RADIUS = (12.725 - 8) / COS_PI_OVER_8 / 16.0 - PlateBlockEntityRenderer.ITEM_SIZE / 2 - 0.02;
    //此处是中心到八边形端点的距离
    private static final double MAX_INTERACT_RADIUS = (14.3 - 8) / COS_PI_OVER_8 / 16.0;//距离中心点超过这个值就直接不处理


    protected OctagonPlateBlock(Properties p) {
        super(p, 14, 0.6);
    }
    @Override
    protected boolean shouldIgnore(double x, double z) {
        return !DistanceHelper.isDistanceWithinScope(x, z, 0.5, 0.5, getMaxDistanceInOctagon(x, z, MAX_INTERACT_RADIUS));
    }

    @Override
    protected PlatePos getModifiedPos(double x, double z) {
        double theta = Math.atan2(x - 0.5, z - 0.5);//theta是关于(0.5,0.5)的旋转角，范围为[0,2pi]
        double maxDistance = getMaxDistanceInOctagon(x, z, MAX_PLACING_RADIUS);
        if (!DistanceHelper.isDistanceWithinScope(x, z, 0.5, 0.5, maxDistance)) {
            x = 0.5 + maxDistance * sin(theta);
            z = 0.5 + maxDistance * cos(theta);
        }
        return new PlatePos(x, z);
    }

    private double getMaxDistanceInOctagon(double x, double z, double r) {
        double theta = Math.atan2(x - 0.5, z - 0.5);//theta是关于(0.5,0.5)的旋转角，范围为[0,2pi]
        if (theta < 0) {
            theta += 2 * PI; //从[-pi,pi]映射到[0,2pi]上
        }
        double alpha = (theta + PI_OVER_8) % PI_OVER_4;
        //alpha是在局部三角形里的偏转角，为(theta+pi/8) mod (pi/4)
        return r * COS_PI_OVER_8 / cos(PI_OVER_8 - alpha);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}
