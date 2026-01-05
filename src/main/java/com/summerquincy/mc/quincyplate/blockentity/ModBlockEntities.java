package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, QuincyPlateMod.MODID);
    public static final RegistryObject<BlockEntityType<PlateBlockEntity>> PLATE_BLOCK_ENTITY =
            BLOCKENTITIES.register("plate_be", () ->
                    BlockEntityType.Builder.of(PlateBlockEntity::new,
                            ModBlocks.WHITE_PLATE.get(),
                            ModBlocks.SQUARE_WHITE_PLATE.get()
                    ).build(null)
            );
    //of方法的参数1是创建方块实体的方法引用，不定长参数2是关联方块。build里的参数可选，大多数时候可以写null

    public static void register(IEventBus eventBus) {
        BLOCKENTITIES.register(eventBus);
    }
}
