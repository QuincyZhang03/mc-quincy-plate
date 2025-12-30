package com.summerquincy.mc.quincyplate.blockentity.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class RoundPlateBlockEntityRenderer extends PlateBlockEntityRenderer {
    public static final float ITEM_SIZE = 0.27f;
    public static final float BASE_HEIGHT = 0.045f;
    public static final float LAYER_HEIGHT = 0.004f;
    public static final float THICKNESS = 0.28f;

    public RoundPlateBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context, ITEM_SIZE, BASE_HEIGHT, LAYER_HEIGHT, THICKNESS);
    }
}
