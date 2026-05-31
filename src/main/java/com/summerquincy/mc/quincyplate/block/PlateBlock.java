package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import static java.lang.Math.atan2;


@SuppressWarnings({"NullableProblems"})
public abstract class PlateBlock extends BaseEntityBlock {
    public static VoxelShape SHAPE;

    protected static class PlatePos {
        double x;
        double z;

        public PlatePos(double x, double z) {
            this.x = x;
            this.z = z;
        }
    }

    protected PlateBlock(Properties p, double width, double height) {
        //width和height是碰撞箱体积
        super(p);
        SHAPE = Block.box(8 - width / 2, 0, 8 - width / 2, 8 + width / 2, height, 8 + width / 2);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PlateBlockEntity(pPos, pState);
    }

    // 这个onRemove方法的名字有一定的误导性，在早期版本时只有方块被破坏时才被调用，
    // 现在只要blockstate发生变化了就会被调用，因此需要判断是否真的被破坏了。
    @Override
    public void onRemove(BlockState pState, Level level, BlockPos pos, BlockState pNewState, boolean isMoving) {
        if (!pState.is(pNewState.getBlock()) && !level.isClientSide()) {
            //仅在方块类型改变时，在服务端执行
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                plate.dropEverything();
            }
        }
        super.onRemove(pState, level, pos, pNewState, isMoving);
    }

    protected abstract boolean shouldIgnore(double x, double z);
    //是否点在了盘子外面，与盘子具体形状有关

    protected abstract PlatePos getModifiedPos(double x, double z);
    //将点在了盘子内的有效放置区域外面的x和z修正为距离中心点最大距离处的同方向点
    //与盘子具体形状有关


    @Override
    protected ItemInteractionResult useItemOn(ItemStack item, BlockState state, Level level, BlockPos pos, Player user, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (item.isEmpty())
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            if (hitResult.getDirection() != Direction.UP) //点击的不是盘子上表面
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            if (hand != InteractionHand.MAIN_HAND) //只允许主手交互
                return ItemInteractionResult.CONSUME;
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                Vec3 hit = hitResult.getLocation();
                double x = hit.x - pos.getX();
                double z = hit.z - pos.getZ(); //[0,1]
                double rotX = user.getLookAngle().x;
                double rotZ = user.getLookAngle().z;
                //手里拿着物品，吃掉或放进去
                if (isCutlery(item)) {
                    if (plate.eatItem(user, level, x, z)) {
                        return ItemInteractionResult.SUCCESS;
                    }
                    return ItemInteractionResult.CONSUME;
                }
                if (item.getItem() instanceof BlockItem && item.getFoodProperties(user) == null) //不让放不能吃的方块
                    return ItemInteractionResult.CONSUME;
                if (shouldIgnore(x, z))
                    return ItemInteractionResult.CONSUME;
                PlatePos modifiedPos = getModifiedPos(x, z);
                x = modifiedPos.x;
                z = modifiedPos.z;
                ItemStack toPut = item.copyWithCount(1);
                if (plate.addFood(user, toPut, x, z, atan2(rotX, rotZ))) {
                    if (!user.getAbilities().instabuild) {
                        item.shrink(1);
                    }
                    return ItemInteractionResult.SUCCESS;
                }
                return ItemInteractionResult.CONSUME;
            }
        } else {
            if (hitResult.getDirection() != Direction.UP) //点击的不是盘子上表面
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            if (hand != InteractionHand.MAIN_HAND) //只允许主手交互
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                ItemStack handItem = user.getItemInHand(hand);
                Vec3 hit = hitResult.getLocation();
                double x = hit.x - pos.getX();
                double z = hit.z - pos.getZ(); //[0,1]
                if (isCutlery(handItem)) {
                    if (plate.eatItem(user, level, x, z)) {
                        return ItemInteractionResult.SUCCESS;
                    }
                }
                return ItemInteractionResult.CONSUME;
            }
            //给食用动作单独开绿灯，让食用事件单独允许在客户端运行，从而兼容客户端动画。
            //这里在eatItem()方法里也单独对客户端做了特殊处理，仅发送事件。
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.CONSUME;

    }

    //注意useWithoutItem要在useItemOn返回PASS_TO_DEFAULT_BLOCK_INTERACTION后才会被调用
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player user, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (hitResult.getDirection() != Direction.UP) //点击的不是盘子上表面
                return InteractionResult.PASS;
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                Vec3 hit = hitResult.getLocation();
                double x = hit.x - pos.getX();
                double z = hit.z - pos.getZ(); //[0,1]
                if (plate.retrieveItem(user, x, z)) { //尝试取回食物
                    return InteractionResult.SUCCESS;
                }
                return InteractionResult.PASS;
            }
        }
        return InteractionResult.CONSUME;
    }

    private boolean isCutlery(ItemStack stack) {
        Item item = stack.getItem();
        if (item == ModItems.FORK.get()) {
            return true;
        } else {
            ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
            return id.toString().equals("flavor_immersed_daily:chopsticks");
        }
    }
}
