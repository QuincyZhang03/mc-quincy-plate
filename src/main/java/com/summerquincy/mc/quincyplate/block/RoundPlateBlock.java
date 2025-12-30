package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.blockentity.RoundPlateBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.sqrt;

public class RoundPlateBlock extends PlateBlock {
    private static double MAX_PLACE_DISTANCE;//距离中心点超过这个值就禁止放置
    private static double IGNORE_THRESHOLD;//距离中心点超过这个值就直接不处理


    protected RoundPlateBlock(Properties p, double width, double height,
                              double max_place_distance, double ignore_threshold) {
        super(p, width, height);
        MAX_PLACE_DISTANCE = max_place_distance;
        IGNORE_THRESHOLD = ignore_threshold;
    }

    @Override
    protected boolean shouldIgnore(double x, double z) {
        return (x - 0.5) * (x - 0.5) + (z - 0.5) * (z - 0.5) > IGNORE_THRESHOLD * IGNORE_THRESHOLD;
    }

    @Override
    protected PlatePos getModifiedPos(double x, double z) {
        double hitDistance = sqrt((x - 0.5) * (x - 0.5) + (z - 0.5) * (z - 0.5));
        if (hitDistance > MAX_PLACE_DISTANCE) {
            double theta = Math.atan2(z - 0.5, x - 0.5);
            x = 0.5 + MAX_PLACE_DISTANCE * cos(theta);
            z = 0.5 + MAX_PLACE_DISTANCE * sin(theta);
        }
        return new PlatePos(x, z);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new RoundPlateBlockEntity(pPos, pState);
    }
}
