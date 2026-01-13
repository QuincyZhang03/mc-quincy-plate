package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.block.ModBlocks;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContent;
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
    public static final Supplier<AttachmentType<PlateContent>> PLATE_CONTENT_ATTACHMENT=ATTACHMENT_TYPES.register("plate_content",()->AttachmentType.serializable(PlateContent::new).build());

    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, QuincyPlateMod.MODID);
    public static final Supplier<BlockEntityType<PlateBlockEntity>> PLATE_BLOCK_ENTITY =
            BLOCKENTITIES.register("plate_be", () ->
                    BlockEntityType.Builder.of(PlateBlockEntity::new,
                            ModBlocks.WHITE_PLATE.get(),
                            ModBlocks.SQUARE_WHITE_PLATE.get()
                    ).build(null)
            );
    //of方法的参数1是创建方块实体的方法引用，不定长参数2是关联方块。build里的参数可选，大多数时候可以写null

    public static void register(IEventBus eventBus) {
        BLOCKENTITIES.register(eventBus);
        ATTACHMENT_TYPES.register(eventBus);
    }
}
