package com.summerquincy.mc.quincyplate;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntities;
import com.summerquincy.mc.quincyplate.creativetab.ModCreativeTabs;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
//Mod入口类要用@Mod注解进行标注，参数填mods.toml里的modid。这个类的构造方法里写初始化行为。
@Mod(QuincyPlateMod.MODID)
@SuppressWarnings("unused")
public class QuincyPlateMod {
    public static final String MODID = "quincyplate";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final GameRules.Key<GameRules.IntegerValue> RULE_MAX_PLATE_SIZE = GameRules.register("quincyPlateMaxSize", GameRules.Category.MISC, GameRules.IntegerValue.create(-1));

    public QuincyPlateMod(IEventBus modEventBus, ModContainer container) {
        modEventBus.addListener(this::commonSetup);

        //具体的注册逻辑写在各类里
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Quincy's Plate loaded successfully!");
    }
}