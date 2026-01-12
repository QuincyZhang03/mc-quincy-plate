package com.summerquincy.mc.quincyplate.blockentity.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlateContent implements INBTSerializable<ListTag> {
    private final List<PlateContentItem> contents = new ArrayList<>();

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

    public static PlateContent ofNBT(ListTag nbt) {
        PlateContent content = new PlateContent();
        content.deserializeNBT(nbt);
        return content;
    }


    public @UnknownNullability ListTag serializeNBTForJade() {
        ListTag data = new ListTag();
        for (PlateContentItem contentItem : contents) {
            CompoundTag itemInfo = new CompoundTag();
            CompoundTag itemTag = new CompoundTag();
            ItemStack item = contentItem.getItem();
            itemTag.putString("id", BuiltInRegistries.ITEM.getKey(item.getItem()).toString());
            itemTag.putByte("Count", (byte) item.getCount());
            itemInfo.put("item", itemTag);
            //todo
            itemInfo.putDouble("posX", contentItem.getPosX());
            itemInfo.putDouble("posZ", contentItem.getPosZ());
            itemInfo.putDouble("rotation", contentItem.getRotation());
            data.add(itemInfo);
        }
        return data;
    }

    @Override
    public @UnknownNullability ListTag serializeNBT(HolderLookup.@NotNull Provider provider) {
        ListTag data = new ListTag();
        for (PlateContentItem contentItem : contents) {
            CompoundTag itemInfo = new CompoundTag();
            CompoundTag itemTag = new CompoundTag();
            contentItem.getItem().save(provider);
            itemInfo.put("item", itemTag);
            itemInfo.putDouble("posX", contentItem.getPosX());
            itemInfo.putDouble("posZ", contentItem.getPosZ());
            itemInfo.putDouble("rotation", contentItem.getRotation());
            data.add(itemInfo);
        }
        return data;
    }

    @Override
    public void deserializeNBT(HolderLookup.@NotNull Provider provider, ListTag nbt) {
        contents.clear();
        for (Tag value : nbt) {
            if (value instanceof CompoundTag tag) {
                if (tag.get("item") instanceof CompoundTag itemTag) {
                    Optional<ItemStack> taggedItem = ItemStack.parse(provider, itemTag);
                    if (taggedItem.isPresent()) {
                        PlateContentItem content = new PlateContentItem(
                                taggedItem.get(),
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
}
