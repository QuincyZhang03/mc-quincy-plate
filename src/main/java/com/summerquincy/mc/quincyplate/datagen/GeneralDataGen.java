package com.summerquincy.mc.quincyplate.datagen;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = QuincyPlateMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GeneralDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        var output = generator.getPackOutput();
        var fileHelper = e.getExistingFileHelper();

        generator.addProvider(e.includeClient(), new ModBlockStateGen(output, fileHelper));
        generator.addProvider(e.includeServer(), new ModRecipeGen(output));
        generator.addProvider(e.includeServer(), new LootTableProvider(output, Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(
                        () -> new ModBlockLootTableGen(Set.of(), FeatureFlags.REGISTRY.allFlags()),
                        LootContextParamSets.BLOCK))
        ));
    }
}
