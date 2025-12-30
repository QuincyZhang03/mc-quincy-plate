package com.summerquincy.mc.quincyplate.creativetab;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuincyPlateMod.MODID);
    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> QUINCY_PLATE_TAB=
            CREATIVE_MODE_TABS.register("quincy_plate_tab",()-> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab."+QuincyPlateMod.MODID))
                    .icon(()->new ItemStack(ModBlocks.WHITE_PLATE.get()))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.WHITE_PLATE.get());
                        pOutput.accept(ModBlocks.SQUARE_WHITE_PLATE.get());
                        pOutput.accept(ModItems.FORK.get());
                    }))
                    .build());
    public static void register(IEventBus bus){
        CREATIVE_MODE_TABS.register(bus);
    }
}
