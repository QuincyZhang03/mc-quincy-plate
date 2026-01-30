package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = QuincyPlateMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GeneralDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        var output = generator.getPackOutput();
        var fileHelper = e.getExistingFileHelper();
        var lookupProvider = e.getLookupProvider();

        generator.addProvider(e.includeClient(), new ModBlockStateGen(output, fileHelper));
        generator.addProvider(e.includeServer(), new ModRecipeGen(output, lookupProvider));
        generator.addProvider(e.includeClient(), new ModItemModelGen(output, fileHelper));
        generator.addProvider(e.includeServer(), new LootTableProvider(output, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(
                        (provider) ->
                                new ModBlockLootTableGen(Set.of(), FeatureFlags.REGISTRY.allFlags(),
                                        provider),
                        LootContextParamSets.BLOCK)
                ),
                lookupProvider
        ));
        ModBlockTagGen blockTagGen = generator.addProvider(e.includeServer(), new ModBlockTagGen(output, lookupProvider, fileHelper));
        generator.addProvider(e.includeServer(), new ModItemTagGen(output, lookupProvider, blockTagGen.contentsGetter(), fileHelper));
    }
}
