package com.summerquincy.mc.quincyplate.util;

public class DistanceHelper {

    public static double getDistanceSquared(double x1, double y1, double x2, double y2) {
        return getSquare(x1 - x2) + getSquare(y1 - y2);
    }

    private static double getSquare(double x) {
        return x * x;
    }

    public static boolean isDistanceWithinScope(double x1, double y1, double x2, double y2, double scope) {
        return getDistanceSquared(x1, y1, x2, y2) <= getSquare(scope);
    }
}
