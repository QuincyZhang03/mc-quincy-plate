package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(QuincyPlateMod.MODID);
    public static final DeferredBlock<Block> WHITE_PLATE =
            registerBlock("white_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final DeferredBlock<Block> SQUARE_WHITE_PLATE =
            registerBlock("square_white_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final DeferredBlock<Block> SQUARE_OAK_PLATE =
            registerBlock("square_oak_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)
                            .mapColor(MapColor.WOOD)
                    ));
    public static final DeferredBlock<Block> OCTAGON_WHITE_PLATE =
            registerBlock("octagon_white_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE)
                    ));
    public static final DeferredBlock<Block> OCTAGON_CHERRY_PLATE =
            registerBlock("octagon_cherry_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)
                            .mapColor(MapColor.TERRACOTTA_PINK)
                    ));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> supplier) {
        DeferredBlock<T> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
