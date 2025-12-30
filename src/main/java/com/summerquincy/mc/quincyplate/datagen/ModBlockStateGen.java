package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateGen extends BlockStateProvider {
    public ModBlockStateGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, QuincyPlateMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.WHITE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/white_plate")));
        simpleBlockWithItem(ModBlocks.SQUARE_WHITE_PLATE.get(), new ModelFile.UncheckedModelFile(modLoc("block/square_white_plate")));
        //UncheckedModelFile在生成时不会检查是否真的存在，适合用于数据生成。
    }
}
