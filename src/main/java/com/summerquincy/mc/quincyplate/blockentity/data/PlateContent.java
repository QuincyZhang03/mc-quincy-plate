package com.summerquincy.mc.quincyplate.blockentity.data;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import java.util.ArrayList;
import java.util.List;

public class PlateContent {
    private final List<PlateContentItem> contents = new ArrayList<>();

    public NbtList serializeNBT() {
        NbtList data = new NbtList();
        for (PlateContentItem contentItem : contents) {
            NbtCompound itemInfo = new NbtCompound();
            itemInfo.put("item", contentItem.getItem().writeNbt(new NbtCompound()));
            itemInfo.putDouble("posX", contentItem.getPosX());
            itemInfo.putDouble("posZ", contentItem.getPosZ());
            itemInfo.putDouble("rotation", contentItem.getRotation());
            data.add(itemInfo);
        }
        return data;
    }

    public void deserializeNBT(NbtList nbt) {
        contents.clear();
        for (NbtElement value : nbt) {
            if (value instanceof NbtCompound tag) {
                if (tag.get("item") instanceof NbtCompound itemTag) {
                    ItemStack itemStack = ItemStack.fromNbt(itemTag);
                    if (!itemStack.isEmpty()) {
                        PlateContentItem content = new PlateContentItem(
                                ItemStack.fromNbt(itemTag),
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

}
