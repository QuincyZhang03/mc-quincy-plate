package com.summerquincy.mc.quincyplate;

import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntityTypes;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

@Environment(EnvType.CLIENT)
public class PlateModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntityTypes.PLATE_BLOCK_ENTITY, PlateBlockEntityRenderer::new);
    }
}
