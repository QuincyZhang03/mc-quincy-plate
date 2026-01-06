package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGen extends RecipeProvider {


    public ModRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_PLATE.get(), 1)
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "white_plate_recipe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SQUARE_WHITE_PLATE.get(), 1)
                .pattern("# #")
                .pattern("###")
                .define('#', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "square_white_plate_recipe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FORK.get(), 1)
                .pattern("# #")
                .pattern("###")
                .pattern(" # ")
                .define('#', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "fork_recipe"));

    }
}
