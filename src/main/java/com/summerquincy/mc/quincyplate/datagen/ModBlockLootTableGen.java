package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import java.util.List;
import java.util.Set;

public class ModBlockLootTableGen extends BlockLootSubProvider {

    protected ModBlockLootTableGen(Set<Item> explosionResistant, FeatureFlagSet enabledFeatures, HolderLookup.Provider registries) {
        super(explosionResistant, enabledFeatures, registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.WHITE_PLATE.get());
        dropSelf(ModBlocks.SQUARE_WHITE_PLATE.get());
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return List.of(ModBlocks.WHITE_PLATE.get(),ModBlocks.SQUARE_WHITE_PLATE.get());
    }
}
