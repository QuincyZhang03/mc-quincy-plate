package com.summerquincy.mc.quincyplate.creativetab;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class ModCreativeTabs {
    public static final CreativeModeTab QUINCY_PLATE_TAB =
            FabricItemGroup.builder()
                    .title(Component.translatable("creativetab." + QuincyPlateMod.MOD_ID))
                    .icon(() -> new ItemStack(ModBlocks.WHITE_PLATE))
                    .displayItems(((pParameters, pOutput) -> {
                        List<ItemLike> TAB_ITEMS = List.of(
                                ModItems.FORK,
                                ModBlocks.WHITE_PLATE,
                                ModBlocks.BLACK_PLATE,
                                ModBlocks.BLUE_PLATE,
                                ModBlocks.BROWN_PLATE,
                                ModBlocks.CYAN_PLATE,
                                ModBlocks.GRAY_PLATE,
                                ModBlocks.GREEN_PLATE,
                                ModBlocks.LIGHT_BLUE_PLATE,
                                ModBlocks.LIGHT_GRAY_PLATE,
                                ModBlocks.LIME_PLATE,
                                ModBlocks.MAGENTA_PLATE,
                                ModBlocks.ORANGE_PLATE,
                                ModBlocks.PINK_PLATE,
                                ModBlocks.PURPLE_PLATE,
                                ModBlocks.RED_PLATE,
                                ModBlocks.YELLOW_PLATE,
                                ModBlocks.SQUARE_WHITE_PLATE,
                                ModBlocks.SQUARE_BLACK_PLATE,
                                ModBlocks.SQUARE_BLUE_PLATE,
                                ModBlocks.SQUARE_BROWN_PLATE,
                                ModBlocks.SQUARE_CYAN_PLATE,
                                ModBlocks.SQUARE_GRAY_PLATE,
                                ModBlocks.SQUARE_GREEN_PLATE,
                                ModBlocks.SQUARE_LIGHT_BLUE_PLATE,
                                ModBlocks.SQUARE_LIGHT_GRAY_PLATE,
                                ModBlocks.SQUARE_LIME_PLATE,
                                ModBlocks.SQUARE_MAGENTA_PLATE,
                                ModBlocks.SQUARE_ORANGE_PLATE,
                                ModBlocks.SQUARE_PINK_PLATE,
                                ModBlocks.SQUARE_PURPLE_PLATE,
                                ModBlocks.SQUARE_RED_PLATE,
                                ModBlocks.SQUARE_YELLOW_PLATE,
                                ModBlocks.SQUARE_OAK_PLATE,
                                ModBlocks.OCTAGON_WHITE_PLATE,
                                ModBlocks.OCTAGON_BLACK_PLATE,
                                ModBlocks.OCTAGON_BLUE_PLATE,
                                ModBlocks.OCTAGON_BROWN_PLATE,
                                ModBlocks.OCTAGON_CYAN_PLATE,
                                ModBlocks.OCTAGON_GRAY_PLATE,
                                ModBlocks.OCTAGON_GREEN_PLATE,
                                ModBlocks.OCTAGON_LIGHT_BLUE_PLATE,
                                ModBlocks.OCTAGON_LIGHT_GRAY_PLATE,
                                ModBlocks.OCTAGON_LIME_PLATE,
                                ModBlocks.OCTAGON_MAGENTA_PLATE,
                                ModBlocks.OCTAGON_ORANGE_PLATE,
                                ModBlocks.OCTAGON_PINK_PLATE,
                                ModBlocks.OCTAGON_PURPLE_PLATE,
                                ModBlocks.OCTAGON_RED_PLATE,
                                ModBlocks.OCTAGON_YELLOW_PLATE,
                                ModBlocks.OCTAGON_CHERRY_PLATE
                        );
                        for (ItemLike item : TAB_ITEMS) {
                            pOutput.accept(item);
                        }
                    }))
                    .build();

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID, "quincy_plate_tab"), QUINCY_PLATE_TAB);
    }
}
