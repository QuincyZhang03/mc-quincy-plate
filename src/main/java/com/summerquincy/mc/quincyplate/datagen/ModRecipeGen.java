package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModRecipeGen extends RecipeProvider {
    public ModRecipeGen(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_PLATE.get(), 3)
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.QUARTZ_BLOCK)
                .unlockedBy(getHasName(Items.QUARTZ_BLOCK), has(Items.QUARTZ_BLOCK))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "white_plate_recipe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SQUARE_WHITE_PLATE.get(), 3)
                .pattern("# #")
                .pattern("X#X")
                .define('#', Items.QUARTZ_BLOCK)
                .define('X',Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ_BLOCK), has(Items.QUARTZ_BLOCK))
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
