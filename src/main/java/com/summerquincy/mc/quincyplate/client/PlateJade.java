package com.summerquincy.mc.quincyplate.client;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.PlateBlock;
import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class PlateJade implements IWailaPlugin {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "jade_tooltip");

    @Override
    public void register(IWailaCommonRegistration registration) {
        IWailaPlugin.super.register(registration);
        registration.registerBlockDataProvider(PlateJadeTooltipProvider.INSTANCE, PlateBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        IWailaPlugin.super.registerClient(registration);
        registration.registerBlockComponent(PlateJadeTooltipProvider.INSTANCE, PlateBlock.class);
    }
}
