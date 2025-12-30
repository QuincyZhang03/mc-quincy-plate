package com.summerquincy.mc.quincyplate;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntities;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
//Mod入口类要用@Mod注解进行标注，参数填mods.toml里的modid。这个类的构造方法里写初始化行为。
@Mod(QuincyPlateMod.MODID)
public class QuincyPlateMod
{
    public static final String MODID = "quincyplate";
    public static final Logger LOGGER= LogManager.getLogger();
//    private static final Logger LOGGER = LogUtils.getLogger();
    public QuincyPlateMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        //this::commonSetup是方法引用
        modEventBus.addListener(this::commonSetup);

        //具体的注册逻辑写在各类里
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Quincy's Plate loaded successfully!");
    }
}