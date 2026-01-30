package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGen extends ItemTagsProvider {

    public ModItemTagGen(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, QuincyPlateMod.MODID, existingFileHelper);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModItemTags.TAG_ROUND_PLATES).add(
                ModBlocks.WHITE_PLATE.get().asItem(),
                ModBlocks.BLACK_PLATE.get().asItem(),
                ModBlocks.BLUE_PLATE.get().asItem(),
                ModBlocks.BROWN_PLATE.get().asItem(),
                ModBlocks.CYAN_PLATE.get().asItem(),
                ModBlocks.GRAY_PLATE.get().asItem(),
                ModBlocks.GREEN_PLATE.get().asItem(),
                ModBlocks.LIGHT_BLUE_PLATE.get().asItem(),
                ModBlocks.LIGHT_GRAY_PLATE.get().asItem(),
                ModBlocks.LIME_PLATE.get().asItem(),
                ModBlocks.MAGENTA_PLATE.get().asItem(),
                ModBlocks.ORANGE_PLATE.get().asItem(),
                ModBlocks.PINK_PLATE.get().asItem(),
                ModBlocks.PURPLE_PLATE.get().asItem(),
                ModBlocks.RED_PLATE.get().asItem(),
                ModBlocks.YELLOW_PLATE.get().asItem()
        );
        tag(ModItemTags.TAG_SQUARE_PLATES).add(
                ModBlocks.SQUARE_WHITE_PLATE.get().asItem(),
                ModBlocks.SQUARE_BLACK_PLATE.get().asItem(),
                ModBlocks.SQUARE_BLUE_PLATE.get().asItem(),
                ModBlocks.SQUARE_BROWN_PLATE.get().asItem(),
                ModBlocks.SQUARE_CYAN_PLATE.get().asItem(),
                ModBlocks.SQUARE_GRAY_PLATE.get().asItem(),
                ModBlocks.SQUARE_GREEN_PLATE.get().asItem(),
                ModBlocks.SQUARE_LIGHT_BLUE_PLATE.get().asItem(),
                ModBlocks.SQUARE_LIGHT_GRAY_PLATE.get().asItem(),
                ModBlocks.SQUARE_LIME_PLATE.get().asItem(),
                ModBlocks.SQUARE_MAGENTA_PLATE.get().asItem(),
                ModBlocks.SQUARE_ORANGE_PLATE.get().asItem(),
                ModBlocks.SQUARE_PINK_PLATE.get().asItem(),
                ModBlocks.SQUARE_PURPLE_PLATE.get().asItem(),
                ModBlocks.SQUARE_RED_PLATE.get().asItem(),
                ModBlocks.SQUARE_YELLOW_PLATE.get().asItem(),
                ModBlocks.SQUARE_OAK_PLATE.get().asItem()
        );
        tag(ModItemTags.TAG_OCTAGON_PLATES).add(
                ModBlocks.OCTAGON_WHITE_PLATE.get().asItem(),
                ModBlocks.OCTAGON_BLACK_PLATE.get().asItem(),
                ModBlocks.OCTAGON_BLUE_PLATE.get().asItem(),
                ModBlocks.OCTAGON_BROWN_PLATE.get().asItem(),
                ModBlocks.OCTAGON_CYAN_PLATE.get().asItem(),
                ModBlocks.OCTAGON_GRAY_PLATE.get().asItem(),
                ModBlocks.OCTAGON_GREEN_PLATE.get().asItem(),
                ModBlocks.OCTAGON_LIGHT_BLUE_PLATE.get().asItem(),
                ModBlocks.OCTAGON_LIGHT_GRAY_PLATE.get().asItem(),
                ModBlocks.OCTAGON_LIME_PLATE.get().asItem(),
                ModBlocks.OCTAGON_MAGENTA_PLATE.get().asItem(),
                ModBlocks.OCTAGON_ORANGE_PLATE.get().asItem(),
                ModBlocks.OCTAGON_PINK_PLATE.get().asItem(),
                ModBlocks.OCTAGON_PURPLE_PLATE.get().asItem(),
                ModBlocks.OCTAGON_RED_PLATE.get().asItem(),
                ModBlocks.OCTAGON_YELLOW_PLATE.get().asItem(),
                ModBlocks.OCTAGON_CHERRY_PLATE.get().asItem()
        );
    }
}
