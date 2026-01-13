package com.summerquincy.mc.quincyplate.client;

import com.mojang.logging.LogUtils;
import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
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

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PlateJadeTooltipProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {

    public static final PlateJadeTooltipProvider INSTANCE = new PlateJadeTooltipProvider();
    private static final String PLATE_ITEM_KEY = "items_in_plate";
    private static final String REAL_COUNT_KEY = "real_count";

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof PlateBlockEntity) {
            ListTag itemList = blockAccessor.getServerData().getList(PLATE_ITEM_KEY, Tag.TAG_COMPOUND);
            LogUtils.getLogger().info(itemList.toString());
            IElementHelper elementHelper = IElementHelper.get();
            ListIterator<Tag> it = itemList.listIterator();
            int rows = 0; //前面已有的行数
            while (it.hasNext()) {
                if (it.next() instanceof CompoundTag stackEntry) {
                    ItemStack stack = ItemStack.of(stackEntry);
                    if(stackEntry.contains(REAL_COUNT_KEY)){
                        stack.setCount(stackEntry.getInt(REAL_COUNT_KEY)); //byte会溢出成负数，还原真实值
                    }
                    if (stack.isEmpty()) continue;
                    if (rows < 4 || blockAccessor.getPlayer().isShiftKeyDown()) {
                        //未到达上限或按住Shift，全画
                        IElement icon = elementHelper.item(stack, 0.6f)
                                .size(new Vec2(10, 10))
                                .translate(new Vec2(-1.5f, -1.7f))
                                .message(null);//关闭叙述
                        tooltip.add(icon); //add在新的一行加
                        tooltip.append(elementHelper.spacer(2, 0));//高度由行高决定
                        int count = stack.getCount();
                        if (count > 1) {
                            tooltip.append(Component.literal(count + " x "));
                        }
                        tooltip.append(stack.getHoverName()); //append紧跟着加
                        rows++;
                    } else {//已有4行且玩家未按下Shift键
                        tooltip.add(Component.translatable("tooltip.quincyplate.and_so_on", itemList.size() - 4));
                        break;
                    }
                }
            }
        }
    }

    @Override
    public ResourceLocation getUid() {
        return PlateJade.UID;
    }

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor blockAccessor) { //传递服务端数据的方法
        if (blockAccessor.getBlockEntity() instanceof PlateBlockEntity plate) {
            List<ItemStack> toolTipData = new ArrayList<>();
            List<PlateContentItem> contents = plate.getContent().getFoodList();
            for (PlateContentItem contentItem : contents) {
                ItemStack item = contentItem.getItem().copy();
                boolean merged = false;
                for (var stack : toolTipData) { //有一样的就合并
                    if (ItemStack.isSameItemSameTags(stack, item)) {//不比较数量，只比较物品和数据
                        stack.grow(1);
                        merged = true;
                        break;
                    }
                }
                if (!merged) { //没有一样的，新建
                    toolTipData.add(item);
                }
            }
            ListTag transmittedData = new ListTag();
            for (ItemStack infoStack : toolTipData) { //把整理后的、仅含物品信息不含坐标信息的数据装进data里
                CompoundTag serializedNBT = infoStack.serializeNBT();
                serializedNBT.putInt(REAL_COUNT_KEY, infoStack.getCount());
                transmittedData.add(serializedNBT);
            }
            data.put(PLATE_ITEM_KEY, transmittedData);
        }
    }
}