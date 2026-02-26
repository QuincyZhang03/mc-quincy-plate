package com.summerquincy.mc.quincyplate;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntities;
import com.summerquincy.mc.quincyplate.creativetab.ModCreativeTabs;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * 1.0.2更新内容：
 * 加入quincyPlateMaxSize游戏规则，可设置盘子最大容量。
 * */
@Mod(QuincyPlateMod.MODID)
public class QuincyPlateMod {
    public static final String MODID = "quincyplate";
    public static final Logger LOGGER = LogManager.getLogger();
            public static final GameRules.Key<GameRules.IntegerValue> RULE_MAX_PLATE_SIZE=GameRules.register("quincyPlateMaxSize", GameRules.Category.MISC, GameRules.IntegerValue.create(-1));

    public QuincyPlateMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        //this::commonSetup是方法引用
        modEventBus.addListener(this::commonSetup);

        //具体的注册逻辑写在各类里
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Quincy's Plate loaded successfully!");
    }
}