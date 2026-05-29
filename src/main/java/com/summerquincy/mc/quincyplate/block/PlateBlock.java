package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import static java.lang.Math.atan2;


@SuppressWarnings({"deprecation"})
public abstract class PlateBlock extends BlockWithEntity {
    public static VoxelShape SHAPE;

    protected static class PlatePos {
        double x;
        double z;

        public PlatePos(double x, double z) {
            this.x = x;
            this.z = z;
        }
    }

    protected PlateBlock(Settings settings, double width, double height) {
        //width和height是碰撞箱体积
        super(settings);
        SHAPE = VoxelShapes.cuboid((8 - width / 2) / 16.0, 0, (8 - width / 2) / 16.0, (8 + width / 2) / 16.0, height / 16.0, (8 + width / 2) / 16.0);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, net.minecraft.util.math.BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlateBlockEntity(pos, state);
    }

    //onBreak是破坏前，onBroken是破坏后
    @Override
    public void onBreak(World world, net.minecraft.util.math.BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                plate.dropEverything();
            }
        }
        super.onBreak(world, pos, state, player);
    }


    protected abstract boolean shouldIgnore(double x, double z);
    //是否点在了盘子外面，与盘子具体形状有关

    protected abstract PlatePos getModifiedPos(double x, double z);
    //将点在了盘子内的有效放置区域外面的x和z修正为距离中心点最大距离处的同方向点
    //与盘子具体形状有关

    @Override
    public ActionResult onUse(BlockState state, World world, net.minecraft.util.math.BlockPos pos, PlayerEntity user, Hand hand, BlockHitResult hitResult) {
        if (!world.isClient) {
            if (hitResult.getSide() != Direction.UP) //点击的不是盘子上表面
                return ActionResult.PASS;
            if (hand != Hand.MAIN_HAND) //只允许主手交互
                return ActionResult.PASS;
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                ItemStack item = user.getMainHandStack();
                Vec3d hit = hitResult.getPos();
                double x = hit.x - pos.getX();
                double z = hit.z - pos.getZ(); //[0,1]
                double rotX = user.getRotationVector().x;
                double rotZ = user.getRotationVector().z;
                if (item.isEmpty()) {//空手，把物品取出来
                    if (plate.retriveItem(user, x, z)) { //尝试取回食物
                        return ActionResult.SUCCESS;
                    }
                } else {//手里拿着物品，放进去
                    if (isCutlery(item)) {
                        if (plate.eatItem(user, world, x, z)) {
                            return ActionResult.SUCCESS;
                        }
                        return ActionResult.CONSUME;
                    }
                    if (item.getItem() instanceof BlockItem && !item.isFood()) //不让放不能吃的方块
                        return ActionResult.CONSUME;
                    if (shouldIgnore(x, z))
                        return ActionResult.CONSUME;
                    PlatePos modifiedPos = getModifiedPos(x, z);
                    x = modifiedPos.x;
                    z = modifiedPos.z;
                    ItemStack toPut = item.copyWithCount(1);
                    if (plate.addFood(user, toPut, x, z, atan2(rotX, rotZ))) {
                        if (!user.getAbilities().creativeMode) {
                            item.decrement(1);
                        }
                        return ActionResult.SUCCESS;
                    }
                    return ActionResult.CONSUME;
                }
                return ActionResult.PASS;
            }
        } else {
            if (hitResult.getSide() != Direction.UP) //点击的不是盘子上表面
                return ActionResult.PASS;
            if (hand != Hand.MAIN_HAND) //只允许主手交互
                return ActionResult.PASS;
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                ItemStack item = user.getMainHandStack();
                Vec3d hit = hitResult.getPos();
                double x = hit.x - pos.getX();
                double z = hit.z - pos.getZ(); //[0,1]
                if (isCutlery(item)) {
                    if (plate.eatItem(user, world, x, z)) { //仅发送事件，不吃
                        return ActionResult.SUCCESS;
                    }
                }
                return ActionResult.CONSUME;
            }
            //给食用动作单独开绿灯，让食用事件单独允许在客户端运行，从而兼容客户端动画。
            //这里在eatItem()方法里也单独对客户端做了特殊处理，仅发送事件。
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    private boolean isCutlery(ItemStack stack) {
        Item item = stack.getItem();
        if (item == ModItems.FORK.asItem()) {
            return true;
        } else {
            Identifier id = Registries.ITEM.getId(item);
            return id.toString().equals("flavor_immersed_daily:chopsticks");
        }
    }
}
