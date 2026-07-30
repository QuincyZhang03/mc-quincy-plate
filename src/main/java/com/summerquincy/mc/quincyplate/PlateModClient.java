package com.summerquincy.mc.quincyplate;

import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntityTypes;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

@Environment(EnvType.CLIENT)
public class PlateModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(ModBlockEntityTypes.PLATE_BLOCK_ENTITY, PlateBlockEntityRenderer::new);
    }
}
