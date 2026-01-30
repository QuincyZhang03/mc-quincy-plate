package com.summerquincy.mc.quincyplate.item;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> TAG_ROUND_PLATES= ItemTags.create(ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID,"round_plates"));
    public static final TagKey<Item> TAG_SQUARE_PLATES= ItemTags.create(ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID,"square_plates"));
    public static final TagKey<Item> TAG_OCTAGON_PLATES= ItemTags.create(ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID,"octagon_plates"));

}
