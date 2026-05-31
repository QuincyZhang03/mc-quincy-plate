package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContent;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import com.summerquincy.mc.quincyplate.item.ModItems;
import com.summerquincy.mc.quincyplate.util.DistanceHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
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
    public static final double FORK_PREVENT_DISTANCE = SELECTION_TOLERANCE * 1.4; //在这个范围内有叉子则禁止放置食物
    public static final double FORK_ON_FOOD_DISTANCE = SELECTION_TOLERANCE * 0.7; //叉子距离食物在这个范围内才允许插上去

    //这是选中物品的最大容差，误差超过这个值就判定为没选中任何物品

    public boolean addItem(Player user, ItemStack item, double x, double z, double rotation) {
        if (level == null) return false;
        int maxFoodNum = level.getGameRules().getInt(QuincyPlateMod.RULE_MAX_PLATE_SIZE);
        if (maxFoodNum >= 0 && content.getFoodList().size() >= maxFoodNum) {
            user.sendSystemMessage(Component.translatable("message.quincyplate.plate_full", maxFoodNum).withStyle(ChatFormatting.RED));
            return false;
        }
        user.level().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.NEUTRAL,
                0.4f, 1.0f + user.getRandom().nextIntBetweenInclusive(-2, 2) * 0.1f);
        //参数1为null则所有人都能听到
        content.add(item, x, z, rotation);
        sync();
        return true;
    }

    public void removeItem(PlateContentItem item) {
        content.remove(item);
        BlockPos pos = getBlockPos();
        List<PlateContentItem> foodList = content.getFoodList();
        for (int i = foodList.size() - 1; i >= 0; i--) { //掉落浮空叉子
            PlateContentItem contentItem = foodList.get(i);
            if (contentItem.getItem().is(ModItems.FORK.get())) {
                if (selectItem(contentItem.getPosX(), contentItem.getPosZ(), FORK_ON_FOOD_DISTANCE, true) == null) {
                    content.remove(contentItem);
                    if (level != null)
                        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), contentItem.getItem());
                }
            }
        }
        sync();
    }

    public boolean addFood(Player user, ItemStack food, double x, double z, double rotation) {
        //尝试放入食物，成功返回true，失败返回false
        if (forkExistsWithinScope(x, z, FORK_PREVENT_DISTANCE)) {
            user.sendSystemMessage(Component.translatable("message.quincyplate.prevented_by_fork").withStyle(ChatFormatting.RED));
            return false;
        }
        return addItem(user, food, x, z, rotation);
    }

    public boolean retrieveItem(Player user, double x, double z) {
        //尝试把物品还给玩家，成功返回true，失败返回false
        PlateContentItem retrievedItem = selectItem(x, z, SELECTION_TOLERANCE);
        if (retrievedItem == null || !retrievedItem.getItem().is(ModItems.FORK.get())) {//有叉子先拿叉子
            List<PlateContentItem> list = content.getFoodList();
            double minDistance = -1;
            PlateContentItem minDistanceFork = null;
            for (PlateContentItem item : list) { //选出距离最近的叉子
                if (item.getItem().is(ModItems.FORK.get())) {
                    double distance = DistanceHelper.getDistanceSquared(x, z, item.getPosX(), item.getPosZ());
                    if (minDistanceFork == null || minDistance > distance) {
                        minDistanceFork = item;
                        minDistance = distance;
                    }
                }
            }
            if (minDistanceFork != null) retrievedItem = minDistanceFork;
        }
        if (retrievedItem == null) return false; //还是没有就不拿
        if (!user.addItem(retrievedItem.getItem())) {
            return false;
        }
        //参数1为null则所有人都能听到
        user.level().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS,
                0.4f, 1.0f + user.getRandom().nextIntBetweenInclusive(-2, 2) * 0.1f);
        removeItem(retrievedItem);
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
            removeItem(selectedItem);
            ItemStack remaining = stack.finishUsingItem(level, user);
            if (!user.getAbilities().instabuild && !remaining.isEmpty()) { //e.g.蘑菇煲剩下碗  创造模式因为不消耗所以不返还
                if (!user.addItem(remaining)) {//玩家背包满，掉出来
                    BlockPos pos = getBlockPos();
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), remaining);
                }
            }
        }
        return true;
    }

    public boolean stickFork(Player user, ItemStack fork, double x, double z, double rotation) {
        PlateContentItem underneathItem = selectItem(x, z, FORK_ON_FOOD_DISTANCE);
        if (underneathItem == null) return false;
        if (underneathItem.getItem().is(ModItems.FORK.get())) return false;
        return addItem(user, fork, x, z, rotation);
    }

    private void sync() {
        setChanged();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            level.blockEntityChanged(getBlockPos());
        }
    }

    public PlateContentItem selectItem(double x, double z, double max_distance, boolean foodOnly) {
        //返回(x,z)为中心max_distance半径范围内y值最大的一项（索引最大的一项），未找到返回null
        List<PlateContentItem> foodList = content.getFoodList();
        for (int i = foodList.size() - 1; i >= 0; i--) {
            PlateContentItem contentItem = foodList.get(i);
            if (foodOnly && contentItem.getItem().is(ModItems.FORK.get())) {
                continue;
            }
            if (DistanceHelper.isDistanceWithinScope(x, z, contentItem.getPosX(), contentItem.getPosZ(), max_distance)) {
                return contentItem;
            }
        }
        return null;
    }

    public PlateContentItem selectItem(double x, double z, double max_distance) {
        return selectItem(x, z, max_distance, false);
    }


    private boolean forkExistsWithinScope(double x, double z, double max_distance) {
        //返回(x,z)为中心max_distance半径范围内是否存在叉子
        List<PlateContentItem> foodList = content.getFoodList();
        for (PlateContentItem contentItem : foodList) {
            if (contentItem.getItem().is(ModItems.FORK.get()) &&
                    DistanceHelper.isDistanceWithinScope(x, z, contentItem.getPosX(), contentItem.getPosZ(), max_distance)
            ) {
                return true;
            }
        }
        return false;
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