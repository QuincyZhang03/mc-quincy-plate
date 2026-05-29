package com.summerquincy.mc.quincyplate.blockentity;

import com.summerquincy.mc.quincyplate.QuincysPlate;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContent;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import com.summerquincy.mc.quincyplate.util.DistanceHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlateBlockEntity extends BlockEntity {

    private final PlateContent content = new PlateContent();
    public static final double SELECTION_TOLERANCE = 0.32 * Math.sqrt(2) * PlateBlockEntityRenderer.ITEM_SIZE;
    //这是选中物品的最大容差，误差超过这个值就判定为没选中任何物品


    public PlateBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.PLATE_BLOCK_ENTITY, pos, state);
    }

    public boolean addFood(PlayerEntity user, ItemStack food, double x, double z, double rotation) {
        //尝试放入食物，成功返回true，失败返回false
        if (world == null) return false;
        int maxFoodNum = world.getGameRules().getInt(QuincysPlate.RULE_MAX_PLATE_SIZE);
        if (maxFoodNum >= 0 && content.getFoodList().size() >= maxFoodNum) {
            user.sendMessage(Text.translatable("message.quincyplate.plate_full", maxFoodNum).setStyle(Style.EMPTY.withColor(Formatting.RED)));
            return false;
        }
        user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.NEUTRAL,
                0.4f, 1.0f + user.getRandom().nextBetweenExclusive(-2, 2) * 0.1f);
        //参数1为null则所有人都能听到
        content.add(food, x, z, rotation);
        sync();
        return true;
    }

    public boolean retriveItem(PlayerEntity user, double x, double z) {
        //尝试把物品还给玩家，成功返回true，失败返回false
        PlateContentItem retrievedItem = selectItem(x, z, SELECTION_TOLERANCE);
        if (retrievedItem == null) return false;
        if (!user.giveItemStack(retrievedItem.getItem())) {
            return false;
        }
        //参数1为null则所有人都能听到
        user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS,
                0.4f, 1.0f + user.getRandom().nextBetweenExclusive(-2, 2) * 0.1f);
        content.remove(retrievedItem);
        sync();
        return true;
    }

    public boolean eatItem(PlayerEntity user, World world, double x, double z) {
        PlateContentItem selectedItem = selectItem(x, z, SELECTION_TOLERANCE);
        if (selectedItem == null || !selectedItem.getItem().isFood()) return false;
        if (!user.canConsume(FabricLoader.getInstance().isModLoaded("salwayseat")
                || FabricLoader.getInstance().isModLoaded("always_eat"))) return false;
        ItemStack stack = selectedItem.getItem();

        if (!world.isClient) { //以下才是服务端逻辑
            content.remove(selectedItem);
            ItemStack remaining = stack.finishUsing(world, user);
            if (!user.getAbilities().creativeMode && !remaining.isEmpty()) { //e.g.蘑菇煲剩下碗  创造模式因为不消耗所以不返还
                if (!user.giveItemStack(remaining)) {//玩家背包满，掉出来
                    BlockPos pos = getPos();
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), remaining);
                }
            }
            sync();
        }
        return true;
    }

    private void sync() {
        if (world != null) {
            BlockState state = world.getBlockState(getPos());
            markDirty();
            world.updateListeners(pos, state, state, 0);
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

    public void dropEverything() {
        List<PlateContentItem> foodList = content.getFoodList();
        SimpleInventory container = new SimpleInventory(foodList.size());
        for (int i = 0; i < foodList.size(); i++) {
            container.setStack(i, foodList.get(i).getItem());  //复制一个Container出来，方便掉落
        }
        ItemScatterer.spawn(world, getPos(), container);
    }



    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.put("inventory", content.serializeNBT());//游戏保存时，把额外数据存进NBT里
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        content.deserializeNBT(nbt.getList("inventory", NbtElement.COMPOUND_TYPE));
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public PlateContent getContent() {
        return content;
    }

}
