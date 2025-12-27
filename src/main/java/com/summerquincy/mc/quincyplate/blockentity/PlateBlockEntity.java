package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("NullableProblems")
public class PlateBlockEntity extends BlockEntity {

    private final PlateContent content = new PlateContent();
    public static final double LAYOUT_SPACING_THRESHOLD = 0.58 * Math.sqrt(2) * PlateBlockEntityRenderer.ITEM_SIZE;
    //这是两个物品要不重叠的最小距离门槛
    public static final double SELECTION_TOLERANCE = 0.35 * Math.sqrt(2) * PlateBlockEntityRenderer.ITEM_SIZE;
    //这是选中物品的最大容差，误差超超过这个值就判定为没选中任何物品


    public boolean addFood(Player user, ItemStack food, double x, double z, double rotation) {
        //尝试放入食物，成功返回true，失败返回false
        if (selectItem(x, z, PlateBlockEntity.LAYOUT_SPACING_THRESHOLD) != null) {//已经有东西了，放不下
            return false;
        }
        //参数1为null则所有人都能听到
        user.level().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.NEUTRAL,
                0.4f, 1.0f + user.getRandom().nextIntBetweenInclusive(-2, 2) * 0.1f);
        content.add(food, x, z, rotation);
        sync();
        return true;
    }

    public boolean retriveItem(Player user, double x, double z) {
        //尝试把物品还给玩家，成功返回true，失败返回false
        PlateContentItem retrievedItem = selectItem(x, z, SELECTION_TOLERANCE);
        if (retrievedItem == null) return false;
        if (!user.addItem(retrievedItem.getItem())) {
            return false;
        }
        //参数1为null则所有人都能听到
        user.level().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS,
                0.4f, 1.0f + user.getRandom().nextIntBetweenInclusive(-2, 2) * 0.1f);
        content.remove(retrievedItem);
        sync();
        return true;
    }

    private void sync() {
        setChanged();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            level.blockEntityChanged(getBlockPos());
        }
    }

    public PlateContentItem selectItem(double x, double z, double max_distance) {
        //返回(x,z)为中心max_distance半径范围内距离最近的一项，未找到返回null
        double minD = Double.MAX_VALUE;
        PlateContentItem closestItem = null;
        for (PlateContentItem contentItem : content.getFoodList()) {
            double d = getDistance(x, z, contentItem.getPosX(), contentItem.getPosZ());
            if (d < max_distance) {
                if (closestItem == null || d < minD) {
                    closestItem = contentItem;
                    minD = d;
                }
            }
        }
        return closestItem;
    }

    private double getDistance(double x1, double z1, double x2, double z2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(z1 - z2, 2));
    }

    public void dropEverything() {
        List<PlateContentItem> foodList = content.getFoodList();
        SimpleContainer container = new SimpleContainer(foodList.size());
        for (int i = 0; i < foodList.size(); i++) {
            container.setItem(i, foodList.get(i).getItem());  //复制一个Container出来，方便掉落
        }
        Containers.dropContents(getLevel(), getBlockPos(), container);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", content.serializeNBT());//游戏保存时，把额外数据存进NBT里
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        content.deserializeNBT(tag.getList("inventory", Tag.TAG_COMPOUND));
    }

    public PlateBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(ModBlockEntities.PLATE_BLOCK_ENTITY.get(), p_155229_, p_155230_);
        //这里把参数1删去了，为了匹配参数表，方便ModBlockEntities里可以使用PlateBlockEntitiy::new
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    public PlateContent getContent() {
        return content;
    }
}