package com.summerquincy.mc.quincyplate.block;

import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.blockentity.renderer.PlateBlockEntityRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
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
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


@SuppressWarnings({"NullableProblems", "deprecation"})
public class PlateBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE =
            Block.box(2, 0, 2, 14, 0.5, 14);
    private static final double MAX_PLACE_DISTANCE = 0.25 - PlateBlockEntityRenderer.ITEM_SIZE / 2;//距离中心点超过这个值就禁止放置
    private static final double IGNORE_THRESHOLD = 0.38;//距离中心点超过这个值就直接不处理

    protected PlateBlock(Properties p) {
        super(p);
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
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PlateBlockEntity(pos, state);
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

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player user, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (hitResult.getDirection() != Direction.UP) //点击的不是盘子上表面
                return InteractionResult.PASS;
            if (hand != InteractionHand.MAIN_HAND) //只允许主手交互
                return InteractionResult.PASS;
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof PlateBlockEntity plate) {
                ItemStack item = user.getItemInHand(hand);
                Vec3 hit = hitResult.getLocation();
                double x = hit.x - pos.getX();
                double z = hit.z - pos.getZ(); //[0,1]
                double rotX = user.getLookAngle().x;
                double rotZ = user.getLookAngle().z;
                if (item.isEmpty()) {//空手，把物品取出来
                    if (plate.retriveItem(user, x, z)) {
                        return InteractionResult.SUCCESS;
                    }
                } else {//手里拿着物品，放进去
                    if (item.getItem() instanceof BlockItem && !item.isEdible()) //不让放不能吃的方块
                        return InteractionResult.CONSUME;
                    double hitDistance = sqrt(pow(x - 0.5, 2) + pow(z - 0.5, 2));
                    if (hitDistance > IGNORE_THRESHOLD)
                        return InteractionResult.CONSUME;
                    if (hitDistance > MAX_PLACE_DISTANCE)
                    //点到盘子有效判定区外面，自动修正为距离中心点最大距离处的同方向点
                    {
                        double theta = atan2(z - 0.5, x - 0.5);
                        x = 0.5 + MAX_PLACE_DISTANCE * cos(theta);
                        z = 0.5 + MAX_PLACE_DISTANCE * sin(theta);
                    }
                    ItemStack toPut = item.copyWithCount(1);
                    if (plate.addFood(user, toPut, x, z, atan2(rotX, rotZ))) {
                        if (!user.isCreative()) {
                            item.shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
                return InteractionResult.PASS;
            }
        }
        return InteractionResult.CONSUME;
    }
}
