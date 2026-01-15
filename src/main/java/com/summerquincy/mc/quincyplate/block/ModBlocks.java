package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QuincyPlateMod.MODID);
    public static final RegistryObject<Block> WHITE_PLATE =
            registerBlock("white_plate",
                    () -> new RoundPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE),
                            12, 0.5
                    ));
    public static final RegistryObject<Block> SQUARE_WHITE_PLATE =
            registerBlock("square_white_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE),
                            12, 0.525
                    ));
    public static final RegistryObject<Block> SQUARE_OAK_PLATE =
            registerBlock("square_oak_plate",
                    () -> new SquarePlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)
                            .mapColor(MapColor.WOOD),
                            12, 0.53
                    ));
    public static final RegistryObject<Block> OCTAGON_WHITE_PLATE =
            registerBlock("octagon_white_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.GLASS)
                            .mapColor(MapColor.TERRACOTTA_WHITE),
                            13, 0.53
                    ));
    public static final RegistryObject<Block> OCTAGON_CHERRY_PLATE =
            registerBlock("octagon_cherry_plate",
                    () -> new OctagonPlateBlock(BlockBehaviour.Properties.of()
                            .strength(0.5f)
                            .sound(SoundType.WOOD)
                            .mapColor(MapColor.TERRACOTTA_PINK),
                            13, 0.53
                    ));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
