package com.summerquincy.mc.quincyplate.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
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
    public static final float LAYER_HEIGHT = 0.005f;//堆叠每层的高度
    public static final float THICKNESS = 0.28f;//物品的厚度

    @SuppressWarnings("unused")
    public PlateBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(PlateBlockEntity blockEntity, float tick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay) {
        ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();
        List<PlateContentItem> foodList = blockEntity.getContent().getFoodList();
        int y = 0;
        for (var item : foodList) {
            poseStack.pushPose();
            poseStack.translate(item.getPosX(), BASE_HEIGHT + LAYER_HEIGHT * y++, item.getPosZ());
            poseStack.scale(ITEM_SIZE, THICKNESS, ITEM_SIZE);
            /*
            对物品而言，厚度是y轴，很奇怪
                ↑ y（厚度）
                |
                ·——→ x
               / 物品平面(xOz)
              z
            */
            poseStack.mulPose(Axis.YP.rotation((float) item.getRotation()));
            //先绕Y轴旋转，这时元素自身的X轴也跟着旋转了，再绕自身X轴旋转就可以躺在盘子上了
            poseStack.mulPose(Axis.XP.rotationDegrees(90));
            renderer.renderStatic(item.getItem(), ItemDisplayContext.FIXED,
                    getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()),
                    OverlayTexture.NO_OVERLAY, poseStack, buffer, blockEntity.getLevel(), 0
            );
            poseStack.popPose();
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
