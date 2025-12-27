package com.summerquincy.mc.quincyplate.client;

import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.blockentity.PlateContent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

public class PlateJadeTooltipProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {

    public static final PlateJadeTooltipProvider INSTANCE = new PlateJadeTooltipProvider();

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof PlateBlockEntity) {
            PlateContent contents = PlateContent.ofNBT(blockAccessor.getServerData()
                    .getList("inventory", CompoundTag.TAG_COMPOUND));
            IElementHelper elementHelper = IElementHelper.get();
            for (var contentItem : contents.getFoodList()) {
                ItemStack item = contentItem.getItem();
                IElement icon = elementHelper.item(item, 0.5f)
                        .size(new Vec2(10,10))
                        .translate(new Vec2(-1, -1))
                        .message(null);//关闭叙述
                tooltip.add(icon); //add在新的一行加
                tooltip.append(item.getHoverName()); //append紧跟着加
            }
        }
    }

    @Override
    public ResourceLocation getUid() {
        return PlateJade.UID;
    }

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor blockAccessor) {
        if (blockAccessor.getBlockEntity() instanceof PlateBlockEntity plate) {
            data.put("inventory", plate.getContent().serializeNBT());
        }
    }
}
