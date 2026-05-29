package com.summerquincy.mc.quincyplate.creativetab;

import com.summerquincy.mc.quincyplate.QuincysPlate;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {
    public static final ItemGroup QUINCY_PLATE_TAB =
            ItemGroup.create(ItemGroup.Row.TOP, 0)
                    .displayName(Text.translatable("creativetab." + QuincysPlate.MOD_ID))
                    .icon(() -> new ItemStack(ModBlocks.WHITE_PLATE))
                    .entries((displayContext, entries) -> {
                        entries.add(new ItemStack(ModItems.FORK));
                        entries.add(ModBlocks.WHITE_PLATE);
                        entries.add(ModBlocks.BLACK_PLATE);
                        entries.add(ModBlocks.BLUE_PLATE);
                        entries.add(ModBlocks.BROWN_PLATE);
                        entries.add(ModBlocks.CYAN_PLATE);
                        entries.add(ModBlocks.GRAY_PLATE);
                        entries.add(ModBlocks.GREEN_PLATE);
                        entries.add(ModBlocks.LIGHT_BLUE_PLATE);
                        entries.add(ModBlocks.LIGHT_GRAY_PLATE);
                        entries.add(ModBlocks.LIME_PLATE);
                        entries.add(ModBlocks.MAGENTA_PLATE);
                        entries.add(ModBlocks.ORANGE_PLATE);
                        entries.add(ModBlocks.PINK_PLATE);
                        entries.add(ModBlocks.PURPLE_PLATE);
                        entries.add(ModBlocks.RED_PLATE);
                        entries.add(ModBlocks.YELLOW_PLATE);
                        entries.add(ModBlocks.SQUARE_WHITE_PLATE);
                        entries.add(ModBlocks.SQUARE_BLACK_PLATE);
                        entries.add(ModBlocks.SQUARE_BLUE_PLATE);
                        entries.add(ModBlocks.SQUARE_BROWN_PLATE);
                        entries.add(ModBlocks.SQUARE_CYAN_PLATE);
                        entries.add(ModBlocks.SQUARE_GRAY_PLATE);
                        entries.add(ModBlocks.SQUARE_GREEN_PLATE);
                        entries.add(ModBlocks.SQUARE_LIGHT_BLUE_PLATE);
                        entries.add(ModBlocks.SQUARE_LIGHT_GRAY_PLATE);
                        entries.add(ModBlocks.SQUARE_LIME_PLATE);
                        entries.add(ModBlocks.SQUARE_MAGENTA_PLATE);
                        entries.add(ModBlocks.SQUARE_ORANGE_PLATE);
                        entries.add(ModBlocks.SQUARE_PINK_PLATE);
                        entries.add(ModBlocks.SQUARE_PURPLE_PLATE);
                        entries.add(ModBlocks.SQUARE_RED_PLATE);
                        entries.add(ModBlocks.SQUARE_YELLOW_PLATE);
                        entries.add(ModBlocks.SQUARE_OAK_PLATE);
                        entries.add(ModBlocks.OCTAGON_WHITE_PLATE);
                        entries.add(ModBlocks.OCTAGON_BLACK_PLATE);
                        entries.add(ModBlocks.OCTAGON_BLUE_PLATE);
                        entries.add(ModBlocks.OCTAGON_BROWN_PLATE);
                        entries.add(ModBlocks.OCTAGON_CYAN_PLATE);
                        entries.add(ModBlocks.OCTAGON_GRAY_PLATE);
                        entries.add(ModBlocks.OCTAGON_GREEN_PLATE);
                        entries.add(ModBlocks.OCTAGON_LIGHT_BLUE_PLATE);
                        entries.add(ModBlocks.OCTAGON_LIGHT_GRAY_PLATE);
                        entries.add(ModBlocks.OCTAGON_LIME_PLATE);
                        entries.add(ModBlocks.OCTAGON_MAGENTA_PLATE);
                        entries.add(ModBlocks.OCTAGON_ORANGE_PLATE);
                        entries.add(ModBlocks.OCTAGON_PINK_PLATE);
                        entries.add(ModBlocks.OCTAGON_PURPLE_PLATE);
                        entries.add(ModBlocks.OCTAGON_RED_PLATE);
                        entries.add(ModBlocks.OCTAGON_YELLOW_PLATE);
                        entries.add(ModBlocks.OCTAGON_CHERRY_PLATE);
                    }).build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(QuincysPlate.MOD_ID, "quincy_plate_tab"), QUINCY_PLATE_TAB);
    }
}
