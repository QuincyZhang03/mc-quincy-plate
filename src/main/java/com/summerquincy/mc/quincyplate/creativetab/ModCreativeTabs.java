package com.summerquincy.mc.quincyplate.creativetab;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuincyPlateMod.MODID);

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> QUINCY_PLATE_TAB =
            CREATIVE_MODE_TABS.register("quincy_plate_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab." + QuincyPlateMod.MODID))
                    .icon(() -> new ItemStack(ModBlocks.WHITE_PLATE.get()))
                    .displayItems(((pParameters, pOutput) -> {
                        List<ItemLike> TAB_ITEMS = List.of(
                                ModItems.FORK.get(),
                                ModBlocks.WHITE_PLATE.get(),
                                ModBlocks.BLACK_PLATE.get(),
                                ModBlocks.BLUE_PLATE.get(),
                                ModBlocks.BROWN_PLATE.get(),
                                ModBlocks.CYAN_PLATE.get(),
                                ModBlocks.GRAY_PLATE.get(),
                                ModBlocks.GREEN_PLATE.get(),
                                ModBlocks.LIGHT_BLUE_PLATE.get(),
                                ModBlocks.LIGHT_GRAY_PLATE.get(),
                                ModBlocks.LIME_PLATE.get(),
                                ModBlocks.MAGENTA_PLATE.get(),
                                ModBlocks.ORANGE_PLATE.get(),
                                ModBlocks.PINK_PLATE.get(),
                                ModBlocks.PURPLE_PLATE.get(),
                                ModBlocks.RED_PLATE.get(),
                                ModBlocks.YELLOW_PLATE.get(),
                                ModBlocks.SQUARE_WHITE_PLATE.get(),
                                ModBlocks.SQUARE_BLACK_PLATE.get(),
                                ModBlocks.SQUARE_BLUE_PLATE.get(),
                                ModBlocks.SQUARE_BROWN_PLATE.get(),
                                ModBlocks.SQUARE_CYAN_PLATE.get(),
                                ModBlocks.SQUARE_GRAY_PLATE.get(),
                                ModBlocks.SQUARE_GREEN_PLATE.get(),
                                ModBlocks.SQUARE_LIGHT_BLUE_PLATE.get(),
                                ModBlocks.SQUARE_LIGHT_GRAY_PLATE.get(),
                                ModBlocks.SQUARE_LIME_PLATE.get(),
                                ModBlocks.SQUARE_MAGENTA_PLATE.get(),
                                ModBlocks.SQUARE_ORANGE_PLATE.get(),
                                ModBlocks.SQUARE_PINK_PLATE.get(),
                                ModBlocks.SQUARE_PURPLE_PLATE.get(),
                                ModBlocks.SQUARE_RED_PLATE.get(),
                                ModBlocks.SQUARE_YELLOW_PLATE.get(),
                                ModBlocks.SQUARE_OAK_PLATE.get(),
                                ModBlocks.OCTAGON_WHITE_PLATE.get(),
                                ModBlocks.OCTAGON_BLACK_PLATE.get(),
                                ModBlocks.OCTAGON_BLUE_PLATE.get(),
                                ModBlocks.OCTAGON_BROWN_PLATE.get(),
                                ModBlocks.OCTAGON_CYAN_PLATE.get(),
                                ModBlocks.OCTAGON_GRAY_PLATE.get(),
                                ModBlocks.OCTAGON_GREEN_PLATE.get(),
                                ModBlocks.OCTAGON_LIGHT_BLUE_PLATE.get(),
                                ModBlocks.OCTAGON_LIGHT_GRAY_PLATE.get(),
                                ModBlocks.OCTAGON_LIME_PLATE.get(),
                                ModBlocks.OCTAGON_MAGENTA_PLATE.get(),
                                ModBlocks.OCTAGON_ORANGE_PLATE.get(),
                                ModBlocks.OCTAGON_PINK_PLATE.get(),
                                ModBlocks.OCTAGON_PURPLE_PLATE.get(),
                                ModBlocks.OCTAGON_RED_PLATE.get(),
                                ModBlocks.OCTAGON_YELLOW_PLATE.get(),
                                ModBlocks.OCTAGON_CHERRY_PLATE.get()
                        );
                        for (ItemLike item : TAB_ITEMS) {
                            pOutput.accept(item);
                        }
                    }))
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
