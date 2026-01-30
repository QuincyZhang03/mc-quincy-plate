package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.blockentity.data.PlateContent;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import com.summerquincy.mc.quincyplate.util.DistanceHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("NullableProblems")
public class PlateBlockEntity extends BlockEntity {

    private final PlateContent content = new PlateContent();
    public static final double SELECTION_TOLERANCE = 0.32 * Math.sqrt(2) * PlateBlockEntityRenderer.ITEM_SIZE;
    //这是选中物品的最大容差，误差超过这个值就判定为没选中任何物品


    public boolean addFood(Player user, ItemStack food, double x, double z, double rotation) {
        //尝试放入食物，成功返回true，失败返回false
        user.level().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.NEUTRAL,
                0.4f, 1.0f + user.getRandom().nextIntBetweenInclusive(-2, 2) * 0.1f);
        //参数1为null则所有人都能听到
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

    public boolean eatItem(Player user, Level level, double x, double z) {
        PlateContentItem selectedItem = selectItem(x, z, SELECTION_TOLERANCE);
        if (selectedItem == null || !selectedItem.getItem().isEdible()) return false;
        if (!user.canEat(ModList.get().isLoaded("salwayseat"))) return false;
        ItemStack stack = selectedItem.getItem();
        ForgeEventFactory.onItemUseFinish(user, stack,
                stack.getUseDuration(), ItemStack.EMPTY);//兼容生活调味料等mod，这个事件在双端都要触发
        if (!level.isClientSide()) { //以下才是服务端逻辑
            content.remove(selectedItem);
            ItemStack remaining = stack.finishUsingItem(level, user);
            if (!user.getAbilities().instabuild && !remaining.isEmpty()) { //e.g.蘑菇煲剩下碗  创造模式因为不消耗所以不返还
                if (!user.addItem(remaining)) {//玩家背包满，掉出来
                    BlockPos pos = getBlockPos();
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), remaining);
                }
            }
            sync();
        }
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
        //返回(x,z)为中心max_distance半径范围内y值最大的一项（索引最大的一项），未找到返回null
        List<PlateContentItem> foodList = content.getFoodList();
        for (int i = foodList.size() - 1; i >= 0; i--) {
            PlateContentItem contentItem = foodList.get(i);
            if (DistanceHelper.isDistanceWithinScope(x, z, contentItem.getPosX(), contentItem.getPosZ(), max_distance)) {
                return contentItem;
            }
        }
        return null;
    }

    @SuppressWarnings("DataFlowIssue")
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

    public PlateBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.PLATE_BLOCK_ENTITY.get(), pPos, pBlockState);
//        //这里把参数1删去了，为了匹配参数表，方便ModBlockEntities里可以使用PlateBlockEntitiy::new
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