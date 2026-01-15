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
        //v0.3.0 begins
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SQUARE_OAK_PLATE.get(), 2)
                .pattern("# #")
                .pattern("***")
                .define('#', Items.OAK_LOG)
                .define('*', Items.OAK_SLAB)
                .unlockedBy(getHasName(Items.OAK_LOG), has(Items.OAK_LOG))
                .unlockedBy(getHasName(Items.OAK_SLAB), has(Items.OAK_SLAB))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "square_oak_plate_recipe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.OCTAGON_WHITE_PLATE.get(), 1)
                .pattern("## ")
                .pattern("# #")
                .pattern(" ##")
                .define('#', Items.QUARTZ)
                .unlockedBy(getHasName(Items.QUARTZ), has(Items.QUARTZ))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "octagon_white_plate_recipe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.OCTAGON_CHERRY_PLATE.get(), 2)
                .pattern("@# ")
                .pattern("#*#")
                .pattern(" #@")
                .define('@', Items.CHERRY_LOG)
                .define('#', Items.CHERRY_SLAB)
                .define('*', Items.CHERRY_LEAVES)
                .unlockedBy(getHasName(Items.CHERRY_LOG), has(Items.CHERRY_LOG))
                .unlockedBy(getHasName(Items.CHERRY_SLAB), has(Items.CHERRY_SLAB))
                .unlockedBy(getHasName(Items.CHERRY_LEAVES), has(Items.CHERRY_LEAVES))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, "octagon_cherry_plate_recipe"));

    }
}
