package com.summerquincy.mc.quincyplate.item;


import com.summerquincy.mc.quincyplate.QuincysPlate;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item FORK =register("fork",new ForkItem());


    private static Item register(String regName, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(QuincysPlate.MOD_ID, regName), item);
    }

    public static void init() {}

}
