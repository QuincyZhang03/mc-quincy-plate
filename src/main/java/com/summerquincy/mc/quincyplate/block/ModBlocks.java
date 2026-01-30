package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(QuincyPlateMod.MODID);
    public static final DeferredBlock<Block> WHITE_PLATE =
            registerBlock("white_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final DeferredBlock<Block> BLACK_PLATE =
            registerBlock("black_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLACK)
                    ));
    public static final DeferredBlock<Block> BLUE_PLATE =
            registerBlock("blue_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE)
                    ));
    public static final DeferredBlock<Block> BROWN_PLATE =
            registerBlock("brown_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BROWN)
                    ));
    public static final DeferredBlock<Block> CYAN_PLATE =
            registerBlock("cyan_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_CYAN)
                    ));
    public static final DeferredBlock<Block> GRAY_PLATE =
            registerBlock("gray_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GRAY)
                    ));
    public static final DeferredBlock<Block> GREEN_PLATE =
            registerBlock("green_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GREEN)
                    ));
    public static final DeferredBlock<Block> LIGHT_BLUE_PLATE =
            registerBlock("light_blue_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
                    ));
    public static final DeferredBlock<Block> LIGHT_GRAY_PLATE =
            registerBlock("light_gray_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    ));
    public static final DeferredBlock<Block> LIME_PLATE =
            registerBlock("lime_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.GRASS)
                    ));
    public static final DeferredBlock<Block> MAGENTA_PLATE =
            registerBlock("magenta_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_MAGENTA)
                    ));
    public static final DeferredBlock<Block> ORANGE_PLATE =
            registerBlock("orange_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_ORANGE)
                    ));
    public static final DeferredBlock<Block> PINK_PLATE =
            registerBlock("pink_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PINK)
                    ));
    public static final DeferredBlock<Block> PURPLE_PLATE =
            registerBlock("purple_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PURPLE)
                    ));
    public static final DeferredBlock<Block> RED_PLATE =
            registerBlock("red_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_RED)
                    ));
    public static final DeferredBlock<Block> YELLOW_PLATE =
            registerBlock("yellow_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_YELLOW)
                    ));



    public static final DeferredBlock<Block> SQUARE_WHITE_PLATE =
            registerBlock("square_white_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final DeferredBlock<Block> SQUARE_OAK_PLATE =
            registerBlock("square_oak_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)
                            .mapColor(MapColor.WOOD)
                    ));
    public static final DeferredBlock<Block> SQUARE_BLACK_PLATE =
            registerBlock("square_black_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLACK)
                    ));
    public static final DeferredBlock<Block> SQUARE_BLUE_PLATE =
            registerBlock("square_blue_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE)
                    ));
    public static final DeferredBlock<Block> SQUARE_BROWN_PLATE =
            registerBlock("square_brown_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BROWN)
                    ));
    public static final DeferredBlock<Block> SQUARE_CYAN_PLATE =
            registerBlock("square_cyan_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_CYAN)
                    ));
    public static final DeferredBlock<Block> SQUARE_GRAY_PLATE =
            registerBlock("square_gray_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GRAY)
                    ));
    public static final DeferredBlock<Block> SQUARE_GREEN_PLATE =
            registerBlock("square_green_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GREEN)
                    ));
    public static final DeferredBlock<Block> SQUARE_LIGHT_BLUE_PLATE =
            registerBlock("square_light_blue_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
                    ));
    public static final DeferredBlock<Block> SQUARE_LIGHT_GRAY_PLATE =
            registerBlock("square_light_gray_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    ));
    public static final DeferredBlock<Block> SQUARE_LIME_PLATE =
            registerBlock("square_lime_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.GRASS)
                    ));
    public static final DeferredBlock<Block> SQUARE_MAGENTA_PLATE =
            registerBlock("square_magenta_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_MAGENTA)
                    ));
    public static final DeferredBlock<Block> SQUARE_ORANGE_PLATE =
            registerBlock("square_orange_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_ORANGE)
                    ));
    public static final DeferredBlock<Block> SQUARE_PINK_PLATE =
            registerBlock("square_pink_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PINK)
                    ));
    public static final DeferredBlock<Block> SQUARE_PURPLE_PLATE =
            registerBlock("square_purple_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PURPLE)
                    ));
    public static final DeferredBlock<Block> SQUARE_RED_PLATE =
            registerBlock("square_red_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_RED)
                    ));
    public static final DeferredBlock<Block> SQUARE_YELLOW_PLATE =
            registerBlock("square_yellow_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_YELLOW)
                    ));



    public static final DeferredBlock<Block> OCTAGON_WHITE_PLATE =
            registerBlock("octagon_white_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final DeferredBlock<Block> OCTAGON_CHERRY_PLATE =
            registerBlock("octagon_cherry_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)
                            .mapColor(MapColor.TERRACOTTA_PINK)
                    ));
    public static final DeferredBlock<Block> OCTAGON_BLACK_PLATE =
            registerBlock("octagon_black_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLACK)
                    ));
    public static final DeferredBlock<Block> OCTAGON_BLUE_PLATE =
            registerBlock("octagon_blue_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE)
                    ));
    public static final DeferredBlock<Block> OCTAGON_BROWN_PLATE =
            registerBlock("octagon_brown_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BROWN)
                    ));
    public static final DeferredBlock<Block> OCTAGON_CYAN_PLATE =
            registerBlock("octagon_cyan_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_CYAN)
                    ));
    public static final DeferredBlock<Block> OCTAGON_GRAY_PLATE =
            registerBlock("octagon_gray_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GRAY)
                    ));
    public static final DeferredBlock<Block> OCTAGON_GREEN_PLATE =
            registerBlock("octagon_green_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GREEN)
                    ));
    public static final DeferredBlock<Block> OCTAGON_LIGHT_BLUE_PLATE =
            registerBlock("octagon_light_blue_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
                    ));
    public static final DeferredBlock<Block> OCTAGON_LIGHT_GRAY_PLATE =
            registerBlock("octagon_light_gray_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    ));
    public static final DeferredBlock<Block> OCTAGON_LIME_PLATE =
            registerBlock("octagon_lime_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.GRASS)
                    ));
    public static final DeferredBlock<Block> OCTAGON_MAGENTA_PLATE =
            registerBlock("octagon_magenta_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_MAGENTA)
                    ));
    public static final DeferredBlock<Block> OCTAGON_ORANGE_PLATE =
            registerBlock("octagon_orange_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_ORANGE)
                    ));
    public static final DeferredBlock<Block> OCTAGON_PINK_PLATE =
            registerBlock("octagon_pink_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PINK)
                    ));
    public static final DeferredBlock<Block> OCTAGON_PURPLE_PLATE =
            registerBlock("octagon_purple_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PURPLE)
                    ));
    public static final DeferredBlock<Block> OCTAGON_RED_PLATE =
            registerBlock("octagon_red_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_RED)
                    ));
    public static final DeferredBlock<Block> OCTAGON_YELLOW_PLATE =
            registerBlock("octagon_yellow_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_YELLOW)
                    ));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> supplier) {
        DeferredBlock<T> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
