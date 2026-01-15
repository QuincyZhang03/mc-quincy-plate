package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModBlockLootTableGen extends BlockLootSubProvider {
    private final List<DeferredBlock<Block>> dropSelfBlocks=List.of(
            ModBlocks.WHITE_PLATE,
            ModBlocks.SQUARE_WHITE_PLATE,
            ModBlocks.SQUARE_OAK_PLATE,
            ModBlocks.OCTAGON_WHITE_PLATE,
            ModBlocks.OCTAGON_CHERRY_PLATE
    );

    protected ModBlockLootTableGen(Set<Item> explosionResistant, FeatureFlagSet enabledFeatures, HolderLookup.Provider registries) {
        super(explosionResistant, enabledFeatures, registries);
    }

    @Override
    protected void generate() {
        for(DeferredBlock<Block> registry:dropSelfBlocks){
            dropSelf(registry.get());
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> knownBlocks=new ArrayList<>();
        for(DeferredBlock<Block> registry:dropSelfBlocks){
            knownBlocks.add(registry.get());
        }
        return knownBlocks;
    }
}
