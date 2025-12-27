package com.summerquincy.mc.quincyplate.item;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = QuincyPlateMod.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(ForgeRegistries.ITEMS, QuincyPlateMod.MODID);
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    @SubscribeEvent
    public static void addToCreativeTab(BuildCreativeModeTabContentsEvent e){
        if(e.getTabKey()== CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            e.accept(ModBlocks.WHITE_PLATE);
        }
    }
}
