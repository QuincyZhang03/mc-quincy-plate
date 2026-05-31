package com.summerquincy.mc.quincyplate.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import com.summerquincy.mc.quincyplate.item.ModItems;
import com.summerquincy.mc.quincyplate.util.DistanceHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("NullableProblems")
public class PlateBlockEntityRenderer implements BlockEntityRenderer<PlateBlockEntity> {

    public static final float ITEM_SIZE = 0.27f;
    public static final float BASE_HEIGHT = 0.045f;//最底层的位置
    public static final float LAYER_HEIGHT = 0.004f;//堆叠每层的高度
    public static final float THICKNESS = 0.28f;//物品的厚度

    @SuppressWarnings("unused")
    public PlateBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PlateBlockEntity blockEntity, float tick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();
        List<PlateContentItem> foodList = blockEntity.getContent().getFoodList();
        for (int i = 0; i < foodList.size(); i++) {
            PlateContentItem item = foodList.get(i);
            item.initLayer();
            double x = item.getPosX();
            double z = item.getPosZ();
            ItemStack itemStack = item.getItem();
            for (int j = 0; j < i; j++) {
                //搜索已经渲染的物品，在待渲染位置附近的叠在高度上
                //最终渲染层数=附近最高的物品层数+1
                PlateContentItem prevItem = foodList.get(j);
                if (DistanceHelper.isDistanceWithinScope(x, z, prevItem.getPosX(), prevItem.getPosZ(),
                        item.getItem().is(ModItems.FORK.get()) ?
                                PlateBlockEntity.FORK_ON_FOOD_DISTANCE : 2 * PlateBlockEntity.SELECTION_TOLERANCE))
                {
                    item.ensureStackOn(prevItem);
                }
            }
            poseStack.pushPose();
            /*
            对物品而言，
                ↑ y
                |
                ·——→ x
               /
              z
              但注意平移、旋转和缩放的三个矩阵是独立的，
              旋转坐标轴对缩放使用的坐标轴没有影响。
            */
            if (itemStack.is(ModItems.FORK.get())) {
                poseStack.translate(x, BASE_HEIGHT + LAYER_HEIGHT * item.getRenderLayer() + ITEM_SIZE * 0.4, z);
                poseStack.scale(ITEM_SIZE, ITEM_SIZE, ITEM_SIZE);
                poseStack.mulPose(Axis.YN.rotation((float) item.getRotation()));
                poseStack.mulPose(Axis.ZN.rotationDegrees(135));
            } else {
                poseStack.translate(x, BASE_HEIGHT + LAYER_HEIGHT * item.getRenderLayer(), z);
                poseStack.scale(ITEM_SIZE, THICKNESS, ITEM_SIZE);
                //先绕Y轴旋转，这时元素自身的X轴也跟着旋转了，再绕自身X轴旋转就可以躺在盘子上了
                poseStack.mulPose(Axis.YP.rotation((float) item.getRotation()));
                poseStack.mulPose(Axis.XP.rotationDegrees(90));
            }
            Level level = blockEntity.getLevel();
            if (level != null) {
                renderer.renderStatic(itemStack, ItemDisplayContext.FIXED,
                        getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()),
                        OverlayTexture.NO_OVERLAY, poseStack, buffer, blockEntity.getLevel(), 0
                );
            }
            poseStack.popPose();
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
