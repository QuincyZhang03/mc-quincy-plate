package com.summerquincy.mc.quincyplate;

import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.blockentity.ModBlockEntityTypes;
import com.summerquincy.mc.quincyplate.creativetab.ModCreativeTabs;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuincysPlate implements ModInitializer {
	public static final String MOD_ID = "quincyplate";
	@SuppressWarnings("unused")
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final GameRules.Key<GameRules.IntRule> RULE_MAX_PLATE_SIZE = GameRuleRegistry.register("quincyPlateMaxSize", GameRules.Category.MISC, GameRuleFactory.createIntRule(-1));

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();
		ModCreativeTabs.init();
		ModBlockEntityTypes.init();
	}
}