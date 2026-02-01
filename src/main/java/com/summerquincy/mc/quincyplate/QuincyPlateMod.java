package com.summerquincy.mc.quincyplate;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntities;
import com.summerquincy.mc.quincyplate.creativetab.ModCreativeTabs;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
* 1.0.1更新内容：
* 餐叉现在可以+2攻击伤害
* 调整CreativeTab里的物品顺序
* 为餐叉添加了Tooltip
* 替换了餐叉的纹理
* 替换了蓝色、青色盘子的盘底纹理
* 替换了黄色盘子的盘沿纹理
* 优化jar包结构，减小jar包体积5%
* */
@Mod(QuincyPlateMod.MODID)
public class QuincyPlateMod
{
    public static final String MODID = "quincyplate";
    public static final Logger LOGGER= LogManager.getLogger();
    public QuincyPlateMod(FMLJavaModLoadingContext context)
    {
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

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Quincy's Plate loaded successfully!");
    }
}