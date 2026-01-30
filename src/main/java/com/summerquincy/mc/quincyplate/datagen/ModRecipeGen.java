package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.item.ModItemTags;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
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
        
        generateDyedPlateRecipes(ModBlocks.BLACK_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.BLACK_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.BLUE_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.BLUE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.BROWN_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.BROWN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.CYAN_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.CYAN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.GRAY_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.GRAY_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.GREEN_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.GREEN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.LIGHT_BLUE_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.LIGHT_BLUE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.LIGHT_GRAY_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.LIGHT_GRAY_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.LIME_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.LIME_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.MAGENTA_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.MAGENTA_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.ORANGE_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.ORANGE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.PINK_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.PINK_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.PURPLE_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.PURPLE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.RED_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.RED_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.WHITE_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.WHITE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.YELLOW_PLATE.get(), ModItemTags.TAG_ROUND_PLATES, "round", Items.YELLOW_DYE, pWriter);

        generateDyedPlateRecipes(ModBlocks.SQUARE_BLACK_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.BLACK_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_BLUE_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.BLUE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_BROWN_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.BROWN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_CYAN_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.CYAN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_GRAY_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.GRAY_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_GREEN_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.GREEN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_LIGHT_BLUE_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.LIGHT_BLUE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_LIGHT_GRAY_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.LIGHT_GRAY_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_LIME_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.LIME_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_MAGENTA_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.MAGENTA_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_ORANGE_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.ORANGE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_PINK_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.PINK_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_PURPLE_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.PURPLE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_RED_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.RED_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_WHITE_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.WHITE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.SQUARE_YELLOW_PLATE.get(), ModItemTags.TAG_SQUARE_PLATES, "square", Items.YELLOW_DYE, pWriter);

        generateDyedPlateRecipes(ModBlocks.OCTAGON_BLACK_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.BLACK_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_BLUE_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.BLUE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_BROWN_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.BROWN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_CYAN_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.CYAN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_GRAY_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.GRAY_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_GREEN_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.GREEN_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_LIGHT_BLUE_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.LIGHT_BLUE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_LIGHT_GRAY_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.LIGHT_GRAY_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_LIME_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.LIME_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_MAGENTA_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.MAGENTA_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_ORANGE_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.ORANGE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_PINK_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.PINK_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_PURPLE_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.PURPLE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_RED_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.RED_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_WHITE_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.WHITE_DYE, pWriter);
        generateDyedPlateRecipes(ModBlocks.OCTAGON_YELLOW_PLATE.get(), ModItemTags.TAG_OCTAGON_PLATES, "octagon", Items.YELLOW_DYE, pWriter);

    }

    private void generateDyedPlateRecipes(ItemLike result, TagKey<Item> plateShapeTag, String shapeName, ItemLike dye, @NotNull Consumer<FinishedRecipe> pWriter) {
        var resultResourceLocation = ForgeRegistries.ITEMS.getKey(result.asItem());
        if (resultResourceLocation != null) {
            String resultItemID = resultResourceLocation.getPath();
            ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, result)
                    .requires(plateShapeTag)
                    .requires(dye)
                    .unlockedBy("has_" + shapeName + "_plates", has(plateShapeTag))
                    .unlockedBy(getHasName(dye), has(dye))
                    .save(pWriter, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID, resultItemID + "_dyeing_recipe"));
        }
    }
}
