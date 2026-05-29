package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.QuincysPlate;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block WHITE_PLATE =
            registerBlock("white_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE))
            );
    public static final Block BLACK_PLATE =
            registerBlock("black_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLACK))
            );
    public static final Block BLUE_PLATE =
            registerBlock("blue_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE))
            );
    public static final Block BROWN_PLATE =
            registerBlock("brown_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BROWN))
            );
    public static final Block CYAN_PLATE =
            registerBlock("cyan_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_CYAN))
            );
    public static final Block GRAY_PLATE =
            registerBlock("gray_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GRAY))
            );
    public static final Block GREEN_PLATE =
            registerBlock("green_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GREEN))
            );
    public static final Block LIGHT_BLUE_PLATE =
            registerBlock("light_blue_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE))
            );
    public static final Block LIGHT_GRAY_PLATE =
            registerBlock("light_gray_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
            );
    public static final Block LIME_PLATE =
            registerBlock("lime_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIME))
            );
    public static final Block MAGENTA_PLATE =
            registerBlock("magenta_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_MAGENTA))
            );
    public static final Block ORANGE_PLATE =
            registerBlock("orange_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_ORANGE))
            );
    public static final Block PINK_PLATE =
            registerBlock("pink_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PINK))
            );
    public static final Block PURPLE_PLATE =
            registerBlock("purple_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PURPLE))
            );
    public static final Block RED_PLATE =
            registerBlock("red_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_RED))
            );
    public static final Block YELLOW_PLATE =
            registerBlock("yellow_plate", new RoundPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_YELLOW))
            );


    public static final Block SQUARE_WHITE_PLATE =
            registerBlock("square_white_plate",
                    new SquarePlateBlock(AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final Block SQUARE_OAK_PLATE =
            registerBlock("square_oak_plate",
                    new SquarePlateBlock(AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.WOOD)
                            .mapColor(MapColor.SPRUCE_BROWN)
                    ));
    public static final Block SQUARE_BLACK_PLATE =
            registerBlock("square_black_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLACK))
            );
    public static final Block SQUARE_BLUE_PLATE =
            registerBlock("square_blue_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE))
            );
    public static final Block SQUARE_BROWN_PLATE =
            registerBlock("square_brown_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BROWN))
            );
    public static final Block SQUARE_CYAN_PLATE =
            registerBlock("square_cyan_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_CYAN))
            );
    public static final Block SQUARE_GRAY_PLATE =
            registerBlock("square_gray_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GRAY))
            );
    public static final Block SQUARE_GREEN_PLATE =
            registerBlock("square_green_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GREEN))
            );
    public static final Block SQUARE_LIGHT_BLUE_PLATE =
            registerBlock("square_light_blue_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE))
            );
    public static final Block SQUARE_LIGHT_GRAY_PLATE =
            registerBlock("square_light_gray_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
            );
    public static final Block SQUARE_LIME_PLATE =
            registerBlock("square_lime_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIME))
            );
    public static final Block SQUARE_MAGENTA_PLATE =
            registerBlock("square_magenta_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_MAGENTA))
            );
    public static final Block SQUARE_ORANGE_PLATE =
            registerBlock("square_orange_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_ORANGE))
            );
    public static final Block SQUARE_PINK_PLATE =
            registerBlock("square_pink_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PINK))
            );
    public static final Block SQUARE_PURPLE_PLATE =
            registerBlock("square_purple_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PURPLE))
            );
    public static final Block SQUARE_RED_PLATE =
            registerBlock("square_red_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_RED))
            );
    public static final Block SQUARE_YELLOW_PLATE =
            registerBlock("square_yellow_plate", new SquarePlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_YELLOW))
            );


    public static final Block OCTAGON_WHITE_PLATE =
            registerBlock("octagon_white_plate",
                    new OctagonPlateBlock(AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final Block OCTAGON_CHERRY_PLATE =
            registerBlock("octagon_cherry_plate",
                     new OctagonPlateBlock(AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.WOOD)
                            .mapColor(MapColor.TERRACOTTA_PINK)
                    ));
    public static final Block OCTAGON_BLACK_PLATE =
            registerBlock("octagon_black_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLACK))
            );
    public static final Block OCTAGON_BLUE_PLATE =
            registerBlock("octagon_blue_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE))
            );
    public static final Block OCTAGON_BROWN_PLATE =
            registerBlock("octagon_brown_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BROWN))
            );
    public static final Block OCTAGON_CYAN_PLATE =
            registerBlock("octagon_cyan_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_CYAN))
            );
    public static final Block OCTAGON_GRAY_PLATE =
            registerBlock("octagon_gray_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GRAY))
            );
    public static final Block OCTAGON_GREEN_PLATE =
            registerBlock("octagon_green_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_GREEN))
            );
    public static final Block OCTAGON_LIGHT_BLUE_PLATE =
            registerBlock("octagon_light_blue_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_BLUE))
            );
    public static final Block OCTAGON_LIGHT_GRAY_PLATE =
            registerBlock("octagon_light_gray_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
            );
    public static final Block OCTAGON_LIME_PLATE =
            registerBlock("octagon_lime_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_LIME))
            );
    public static final Block OCTAGON_MAGENTA_PLATE =
            registerBlock("octagon_magenta_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_MAGENTA))
            );
    public static final Block OCTAGON_ORANGE_PLATE =
            registerBlock("octagon_orange_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_ORANGE))
            );
    public static final Block OCTAGON_PINK_PLATE =
            registerBlock("octagon_pink_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PINK))
            );
    public static final Block OCTAGON_PURPLE_PLATE =
            registerBlock("octagon_purple_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_PURPLE))
            );
    public static final Block OCTAGON_RED_PLATE =
            registerBlock("octagon_red_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_RED))
            );
    public static final Block OCTAGON_YELLOW_PLATE =
            registerBlock("octagon_yellow_plate", new OctagonPlateBlock(
                    AbstractBlock.Settings.create()
                            .strength(0.5f)
                            .sounds(BlockSoundGroup.GLASS)
                            .mapColor(MapColor.TERRACOTTA_YELLOW))
            );


    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.BLOCK, Identifier.of(QuincysPlate.MOD_ID, name), block);
        Registry.register(Registries.ITEM, Identifier.of(QuincysPlate.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return block;
    }

    public static void init() {
    }
}
