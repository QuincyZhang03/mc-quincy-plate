package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateGen extends BlockStateProvider {
    public ModBlockStateGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, QuincyPlateMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.WHITE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/white_plate")));
        simpleBlockWithItem(ModBlocks.BLACK_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_plate")));
        simpleBlockWithItem(ModBlocks.BLUE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_plate")));
        simpleBlockWithItem(ModBlocks.BROWN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/brown_plate")));
        simpleBlockWithItem(ModBlocks.CYAN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_plate")));
        simpleBlockWithItem(ModBlocks.GRAY_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gray_plate")));
        simpleBlockWithItem(ModBlocks.GREEN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/green_plate")));
        simpleBlockWithItem(ModBlocks.LIGHT_BLUE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/light_blue_plate")));
        simpleBlockWithItem(ModBlocks.LIGHT_GRAY_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/light_gray_plate")));
        simpleBlockWithItem(ModBlocks.LIME_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/lime_plate")));
        simpleBlockWithItem(ModBlocks.MAGENTA_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/magenta_plate")));
        simpleBlockWithItem(ModBlocks.ORANGE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/orange_plate")));
        simpleBlockWithItem(ModBlocks.PINK_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/pink_plate")));
        simpleBlockWithItem(ModBlocks.PURPLE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_plate")));
        simpleBlockWithItem(ModBlocks.RED_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_plate")));
        simpleBlockWithItem(ModBlocks.YELLOW_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/yellow_plate")));

        simpleBlockWithItem(ModBlocks.SQUARE_WHITE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_white_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_BLACK_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_black_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_BLUE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_blue_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_BROWN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_brown_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_CYAN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_cyan_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_GRAY_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_gray_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_GREEN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_green_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_LIGHT_BLUE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_light_blue_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_LIGHT_GRAY_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_light_gray_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_LIME_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_lime_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_MAGENTA_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_magenta_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_ORANGE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_orange_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_PINK_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_pink_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_PURPLE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_purple_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_RED_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_red_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_YELLOW_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_yellow_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_OAK_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_oak_plate")));

        simpleBlockWithItem(ModBlocks.OCTAGON_WHITE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_white_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_BLACK_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_black_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_BLUE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_blue_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_BROWN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_brown_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_CYAN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_cyan_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_GRAY_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_gray_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_GREEN_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_green_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_LIGHT_BLUE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_light_blue_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_LIGHT_GRAY_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_light_gray_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_LIME_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_lime_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_MAGENTA_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_magenta_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_ORANGE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_orange_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_PINK_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_pink_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_PURPLE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_purple_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_RED_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_red_plate")));
        simpleBlockWithItem(ModBlocks.OCTAGON_YELLOW_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_yellow_plate")));

        simpleBlockWithItem(ModBlocks.OCTAGON_CHERRY_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/octagon_cherry_plate")));
    }
}
