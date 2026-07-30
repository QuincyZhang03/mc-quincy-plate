package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;


public class ModBlockEntityTypes {
    public static final BlockEntityType<PlateBlockEntity> PLATE_BLOCK_ENTITY =
            register("plate_be", BlockEntityType.Builder.of(PlateBlockEntity::new,
                            ModBlocks.WHITE_PLATE,
                            ModBlocks.BLACK_PLATE,
                            ModBlocks.BLUE_PLATE,
                            ModBlocks.BROWN_PLATE,
                            ModBlocks.CYAN_PLATE,
                            ModBlocks.GRAY_PLATE,
                            ModBlocks.GREEN_PLATE,
                            ModBlocks.LIGHT_BLUE_PLATE,
                            ModBlocks.LIGHT_GRAY_PLATE,
                            ModBlocks.LIME_PLATE,
                            ModBlocks.MAGENTA_PLATE,
                            ModBlocks.ORANGE_PLATE,
                            ModBlocks.PINK_PLATE,
                            ModBlocks.PURPLE_PLATE,
                            ModBlocks.RED_PLATE,
                            ModBlocks.YELLOW_PLATE,
                            ModBlocks.SQUARE_WHITE_PLATE,
                            ModBlocks.SQUARE_OAK_PLATE,
                            ModBlocks.SQUARE_BLACK_PLATE,
                            ModBlocks.SQUARE_BLUE_PLATE,
                            ModBlocks.SQUARE_BROWN_PLATE,
                            ModBlocks.SQUARE_CYAN_PLATE,
                            ModBlocks.SQUARE_GRAY_PLATE,
                            ModBlocks.SQUARE_GREEN_PLATE,
                            ModBlocks.SQUARE_LIGHT_BLUE_PLATE,
                            ModBlocks.SQUARE_LIGHT_GRAY_PLATE,
                            ModBlocks.SQUARE_LIME_PLATE,
                            ModBlocks.SQUARE_MAGENTA_PLATE,
                            ModBlocks.SQUARE_ORANGE_PLATE,
                            ModBlocks.SQUARE_PINK_PLATE,
                            ModBlocks.SQUARE_PURPLE_PLATE,
                            ModBlocks.SQUARE_RED_PLATE,
                            ModBlocks.SQUARE_YELLOW_PLATE,
                            ModBlocks.OCTAGON_WHITE_PLATE,
                            ModBlocks.OCTAGON_BLACK_PLATE,
                            ModBlocks.OCTAGON_BLUE_PLATE,
                            ModBlocks.OCTAGON_BROWN_PLATE,
                            ModBlocks.OCTAGON_CYAN_PLATE,
                            ModBlocks.OCTAGON_GRAY_PLATE,
                            ModBlocks.OCTAGON_GREEN_PLATE,
                            ModBlocks.OCTAGON_LIGHT_BLUE_PLATE,
                            ModBlocks.OCTAGON_LIGHT_GRAY_PLATE,
                            ModBlocks.OCTAGON_LIME_PLATE,
                            ModBlocks.OCTAGON_MAGENTA_PLATE,
                            ModBlocks.OCTAGON_ORANGE_PLATE,
                            ModBlocks.OCTAGON_PINK_PLATE,
                            ModBlocks.OCTAGON_PURPLE_PLATE,
                            ModBlocks.OCTAGON_RED_PLATE,
                            ModBlocks.OCTAGON_YELLOW_PLATE,
                            ModBlocks.OCTAGON_CHERRY_PLATE)
                    .build());

    private static <T extends BlockEntity> BlockEntityType<T> register(String regName, BlockEntityType<T> blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MOD_ID, regName), blockEntityType);
    }

    public static void init() {
    }
}
