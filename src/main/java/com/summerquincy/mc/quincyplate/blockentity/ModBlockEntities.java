package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@SuppressWarnings("DataFlowIssue")
public class ModBlockEntities {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, QuincyPlateMod.MODID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, QuincyPlateMod.MODID);
    public static final Supplier<BlockEntityType<PlateBlockEntity>> PLATE_BLOCK_ENTITY =
            BLOCKENTITIES.register("plate_be", () ->
                    BlockEntityType.Builder.of(PlateBlockEntity::new,
                            ModBlocks.WHITE_PLATE.get(),
                            ModBlocks.BLACK_PLATE.get(),
                            ModBlocks.BLUE_PLATE.get(),
                            ModBlocks.BROWN_PLATE.get(),
                            ModBlocks.CYAN_PLATE.get(),
                            ModBlocks.GRAY_PLATE.get(),
                            ModBlocks.GREEN_PLATE.get(),
                            ModBlocks.LIGHT_BLUE_PLATE.get(),
                            ModBlocks.LIGHT_GRAY_PLATE.get(),
                            ModBlocks.LIME_PLATE.get(),
                            ModBlocks.MAGENTA_PLATE.get(),
                            ModBlocks.ORANGE_PLATE.get(),
                            ModBlocks.PINK_PLATE.get(),
                            ModBlocks.PURPLE_PLATE.get(),
                            ModBlocks.RED_PLATE.get(),
                            ModBlocks.YELLOW_PLATE.get(),
                            ModBlocks.SQUARE_WHITE_PLATE.get(),
                            ModBlocks.SQUARE_OAK_PLATE.get(),
                            ModBlocks.SQUARE_BLACK_PLATE.get(),
                            ModBlocks.SQUARE_BLUE_PLATE.get(),
                            ModBlocks.SQUARE_BROWN_PLATE.get(),
                            ModBlocks.SQUARE_CYAN_PLATE.get(),
                            ModBlocks.SQUARE_GRAY_PLATE.get(),
                            ModBlocks.SQUARE_GREEN_PLATE.get(),
                            ModBlocks.SQUARE_LIGHT_BLUE_PLATE.get(),
                            ModBlocks.SQUARE_LIGHT_GRAY_PLATE.get(),
                            ModBlocks.SQUARE_LIME_PLATE.get(),
                            ModBlocks.SQUARE_MAGENTA_PLATE.get(),
                            ModBlocks.SQUARE_ORANGE_PLATE.get(),
                            ModBlocks.SQUARE_PINK_PLATE.get(),
                            ModBlocks.SQUARE_PURPLE_PLATE.get(),
                            ModBlocks.SQUARE_RED_PLATE.get(),
                            ModBlocks.SQUARE_YELLOW_PLATE.get(),
                            ModBlocks.OCTAGON_WHITE_PLATE.get(),
                            ModBlocks.OCTAGON_BLACK_PLATE.get(),
                            ModBlocks.OCTAGON_BLUE_PLATE.get(),
                            ModBlocks.OCTAGON_BROWN_PLATE.get(),
                            ModBlocks.OCTAGON_CYAN_PLATE.get(),
                            ModBlocks.OCTAGON_GRAY_PLATE.get(),
                            ModBlocks.OCTAGON_GREEN_PLATE.get(),
                            ModBlocks.OCTAGON_LIGHT_BLUE_PLATE.get(),
                            ModBlocks.OCTAGON_LIGHT_GRAY_PLATE.get(),
                            ModBlocks.OCTAGON_LIME_PLATE.get(),
                            ModBlocks.OCTAGON_MAGENTA_PLATE.get(),
                            ModBlocks.OCTAGON_ORANGE_PLATE.get(),
                            ModBlocks.OCTAGON_PINK_PLATE.get(),
                            ModBlocks.OCTAGON_PURPLE_PLATE.get(),
                            ModBlocks.OCTAGON_RED_PLATE.get(),
                            ModBlocks.OCTAGON_YELLOW_PLATE.get(),
                            ModBlocks.OCTAGON_CHERRY_PLATE.get()
                    ).build(null)
            );
    //of方法的参数1是创建方块实体的方法引用，不定长参数2是关联方块。build里的参数可选，大多数时候可以写null

    public static void register(IEventBus eventBus) {
        BLOCKENTITIES.register(eventBus);
        ATTACHMENT_TYPES.register(eventBus);
    }
}
