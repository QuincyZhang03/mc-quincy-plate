package com.summerquincy.mc.quincyplate.event;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntities;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QuincyPlateMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers e) {
        e.registerBlockEntityRenderer(ModBlockEntities.PLATE_BLOCK_ENTITY.get(), PlateBlockEntityRenderer::new);
    }
}
