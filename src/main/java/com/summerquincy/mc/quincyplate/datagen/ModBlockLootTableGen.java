package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModBlockLootTableGen extends BlockLootSubProvider {
    protected ModBlockLootTableGen(Set<Item> exclude, FeatureFlagSet flag) {
        super(exclude,flag);
    }
    private final List<RegistryObject<Block>> dropSelfBlocks=List.of(
            ModBlocks.WHITE_PLATE,
            ModBlocks.SQUARE_WHITE_PLATE,
            ModBlocks.SQUARE_OAK_PLATE,
            ModBlocks.OCTAGON_WHITE_PLATE,
            ModBlocks.OCTAGON_CHERRY_PLATE
    );

    @Override
    protected void generate() {
        for(RegistryObject<Block> registry:dropSelfBlocks){
            dropSelf(registry.get());
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> knownBlocks=new ArrayList<>();
        for(RegistryObject<Block> registry:dropSelfBlocks){
            knownBlocks.add(registry.get());
        }
        return knownBlocks;
    }
}
