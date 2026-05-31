package com.summerquincy.mc.quincyplate.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ForkItem extends Item {
    public ForkItem(Properties pProperties) {
        super(pProperties);
    }

    public ForkItem() {
        this(new Item.Properties().stacksTo(1));
    }

    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pSlot) {
        if (pSlot == EquipmentSlot.MAINHAND) {
            return ImmutableMultimap.of(Attributes.ATTACK_DAMAGE, new AttributeModifier("Fork Damage", 2.0, AttributeModifier.Operation.ADDITION));
        }
        return ImmutableMultimap.of();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(Component.translatable("tooltip.quincyplate.fork_common_1"));
        pTooltipComponents.add(Component.translatable("tooltip.quincyplate.fork_common_2"));
    }

    //Shift+右键时，不触发方块的use方法，而是对着方块使用物品的useOn方法
    @SuppressWarnings("NullableProblems")
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!level.isClientSide) {
            BlockPos platePos = pContext.getClickedPos();
            Vec3 hit = pContext.getClickLocation();
            BlockEntity blockEntity = level.getBlockEntity(platePos);
            if (blockEntity instanceof PlateBlockEntity plate &&
                    pContext.getHand() == InteractionHand.MAIN_HAND &&
                    pContext.getClickedFace() == Direction.UP
            ) {
                ItemStack forkStack = pContext.getItemInHand();
                Player player = pContext.getPlayer();
                double x = hit.x - plate.getBlockPos().getX();
                double z = hit.z - plate.getBlockPos().getZ();
                double rotation = Math.toRadians(pContext.getRotation());
                if (plate.stickFork(player, forkStack.copyWithCount(1), x, z, rotation)) {
                    if (player!=null && !player.getAbilities().instabuild) {
                        forkStack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
                return InteractionResult.PASS;
            }
        }
        return super.useOn(pContext);
    }
}
