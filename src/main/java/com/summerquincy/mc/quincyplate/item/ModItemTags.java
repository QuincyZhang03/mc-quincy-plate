package com.summerquincy.mc.quincyplate.item;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@SuppressWarnings("unused")
public class ModItemTags {
    public static final TagKey<Item> TAG_ROUND_PLATES= TagKey.create(ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID,"round_plates")),ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID,"round_plates"));
    public static final TagKey<Item> TAG_SQUARE_PLATES= TagKey.create(ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID,"square_plates")),ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID,"square_plates"));
    public static final TagKey<Item> TAG_OCTAGON_PLATES= TagKey.create(ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID,"octagon_plates")),ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID,"octagon_plates"));
}
