package com.summerquincy.mc.quincyplate.client;

import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContent;
import net.minecraft.nbt.CompoundTag;
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

public class PlateJadeTooltipProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {

    public static final PlateJadeTooltipProvider INSTANCE = new PlateJadeTooltipProvider();
    private final List<ItemStack> toolTipData = new ArrayList<>();

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof PlateBlockEntity) {
            PlateContent contents = PlateContent.ofNBT(blockAccessor.getServerData()
                    .getList("inventory", CompoundTag.TAG_COMPOUND));
            IElementHelper elementHelper = IElementHelper.get();
            toolTipData.clear();
            for (var contentItem : contents.getFoodList()) { //为了合并，先把数据抽取出来做列表
                ItemStack item = contentItem.getItem();
                boolean merged = false;
                for (var data : toolTipData) { //有一样的就合并
                    if (ItemStack.isSameItemSameTags(data, item)) {//不比较数量，只比较物品和数据
                        data.grow(1);
                        merged = true;
                        break;
                    }
                }
                if (!merged) { //没有一样的，新建
                    toolTipData.add(item);
                }
            }

            int rows = 0; //前面已有的行数
            for (var item : toolTipData) { //正式开始绘制
                int itemNum=item.getCount();
                if (rows < 4 || blockAccessor.getPlayer().isShiftKeyDown()) {
                    //未到达上限或按住Shift，全画
                    IElement icon = elementHelper.item(item, 0.6f)
                            .size(new Vec2(10, 10))
                            .translate(new Vec2(-1.5f, -1.7f))
                            .message(null);//关闭叙述
                    tooltip.add(icon); //add在新的一行加
                    tooltip.append(elementHelper.spacer(2,0));//高度由行高决定
                    if (itemNum > 1) {
                        tooltip.append(Component.literal(itemNum + " x "));
                    }
                    tooltip.append(item.getHoverName()); //append紧跟着加
                    rows++;
                } else {//已有4行且玩家未按下Shift键
                    tooltip.add(Component.translatable("tooltip.quincyplate.and_so_on", toolTipData.size() - 4));
                    break;
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
            data.put("inventory", plate.getContent().serializeNBT());
        }
    }
}