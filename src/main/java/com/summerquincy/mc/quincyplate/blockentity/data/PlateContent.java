package com.summerquincy.mc.quincyplate.blockentity.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.INBTSerializable;
import java.util.ArrayList;
import java.util.List;

public class PlateContent implements INBTSerializable<ListTag> {
    private final List<PlateContentItem> contents = new ArrayList<>();

    @Override
    public ListTag serializeNBT() {
        ListTag data = new ListTag();
        for (PlateContentItem contentItem : contents) {
            CompoundTag itemInfo = new CompoundTag();
            itemInfo.put("item", contentItem.getItem().serializeNBT());
            itemInfo.putDouble("posX", contentItem.getPosX());
            itemInfo.putDouble("posZ", contentItem.getPosZ());
            itemInfo.putDouble("rotation", contentItem.getRotation());
            data.add(itemInfo);
        }
        return data;
    }

    @Override
    public void deserializeNBT(ListTag nbt) {
        contents.clear();
        for (Tag value : nbt) {
            if (value instanceof CompoundTag tag) {
                if (tag.get("item") instanceof CompoundTag itemTag) {
                    ItemStack itemStack = ItemStack.of(itemTag);
                    if (!itemStack.isEmpty()) {
                        PlateContentItem content = new PlateContentItem(
                                ItemStack.of(itemTag),
                                tag.getDouble("posX"),
                                tag.getDouble("posZ"),
                                tag.getDouble("rotation")
                        );
                        contents.add(content);
                    }
                }
            }
        }
    }

    public void add(ItemStack item, double x, double z, double rotation) {
        PlateContentItem contentItem = new PlateContentItem(item, x, z, rotation);
        contents.add(contentItem);
    }

    public void remove(PlateContentItem contentItem) {
        contents.remove(contentItem);
    }

    public List<PlateContentItem> getFoodList() {
        return contents;
    }

    public static PlateContent ofNBT(ListTag nbt){
        PlateContent content=new PlateContent();
        content.deserializeNBT(nbt);
        return content;
    }
}
