package com.summerquincy.mc.quincyplate.blockentity.renderer;

import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import com.summerquincy.mc.quincyplate.blockentity.data.PlateContentItem;
import com.summerquincy.mc.quincyplate.util.DistanceHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

import java.util.List;

@Environment(EnvType.CLIENT)
public class PlateBlockEntityRenderer implements BlockEntityRenderer<PlateBlockEntity> {

    public static final float ITEM_SIZE = 0.27f;
    public static final float BASE_HEIGHT = 0.045f;//最底层的位置
    public static final float LAYER_HEIGHT = 0.004f;//堆叠每层的高度
    public static final float THICKNESS = 0.28f;//物品的厚度

    @SuppressWarnings("unused")
    public PlateBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(PlateBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        if (blockEntity.getWorld() != null) {
            List<PlateContentItem> foodList = blockEntity.getContent().getFoodList();

            for (int i = 0; i < foodList.size(); i++) {
                PlateContentItem item = foodList.get(i);
                item.initLayer();
                double x = item.getPosX();
                double z = item.getPosZ();
                for (int j = 0; j < i; j++) {
                    //搜索已经渲染的物品，在待渲染位置附近的叠在高度上
                    //最终渲染层数=附近最高的物品层数+1
                    PlateContentItem prevItem = foodList.get(j);
                    if (DistanceHelper.isDistanceWithinScope(x, z, prevItem.getPosX(), prevItem.getPosZ(),
                            2 * PlateBlockEntity.SELECTION_TOLERANCE)) {
                        item.ensureStackOn(prevItem);
                    }
                }
                matrices.push();
                matrices.translate(x, BASE_HEIGHT + LAYER_HEIGHT * item.getRenderLayer(), z);
                matrices.scale(ITEM_SIZE, THICKNESS, ITEM_SIZE);
            /*
            对物品而言，厚度是y轴，很奇怪
                ↑ y（厚度）
                |
                ·——→ x
               / 物品平面(xOz)
              z
            */
                matrices.multiply(RotationAxis.POSITIVE_Y.rotation((float) item.getRotation()));
                //先绕Y轴旋转，这时元素自身的X轴也跟着旋转了，再绕自身X轴旋转就可以躺在盘子上了
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
                World world = blockEntity.getWorld();
                int lightAbove = WorldRenderer.getLightmapCoordinates(world, blockEntity.getPos().up());
                MinecraftClient.getInstance().getItemRenderer().renderItem(item.getItem(), ModelTransformationMode.FIXED, lightAbove,
                        OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 0);
                matrices.pop();
            }
        }
    }
}
