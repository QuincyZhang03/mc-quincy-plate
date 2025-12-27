package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
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
    public ModRecipeGen(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_PLATE.get(), 3)
                .pattern("# #")
                .pattern(" # ")
                .define('#', Items.QUARTZ_BLOCK)
                .unlockedBy(getHasName(ModBlocks.WHITE_PLATE.get()), has(ModBlocks.WHITE_PLATE.get()))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "white_plate_recipe"));
    }
}
