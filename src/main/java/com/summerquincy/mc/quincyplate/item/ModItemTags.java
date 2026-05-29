package com.summerquincy.mc.quincyplate.item;

import com.summerquincy.mc.quincyplate.QuincysPlate;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModItemTags {
    public static final TagKey<Item> TAG_ROUND_PLATES= TagKey.of(RegistryKeys.ITEM, Identifier.of(QuincysPlate.MOD_ID,"round_plates"));
    public static final TagKey<Item> TAG_SQUARE_PLATES= TagKey.of(RegistryKeys.ITEM, Identifier.of(QuincysPlate.MOD_ID,"square_plates"));
    public static final TagKey<Item> TAG_OCTAGON_PLATES= TagKey.of(RegistryKeys.ITEM, Identifier.of(QuincysPlate.MOD_ID,"octagon_plates"));
}
