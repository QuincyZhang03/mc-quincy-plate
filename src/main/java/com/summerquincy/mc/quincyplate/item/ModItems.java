package com.summerquincy.mc.quincyplate.item;


import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {
    public static Item FORK =register("fork",new ForkItem());


    private static Item register(String regName, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID, regName), item);
    }

    public static void init() {}

}
