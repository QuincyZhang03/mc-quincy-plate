package com.summerquincy.mc.quincyplate.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.summerquincy.mc.quincyplate.blockentity.PlateBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class ForkItem extends Item {
    public static final String FORK_DAMAGE_ATTRIBUTE = "Fork Damage";
    private static final UUID forkDamageAttributeUUID = UUID.nameUUIDFromBytes(FORK_DAMAGE_ATTRIBUTE.getBytes());
    public static final EntityAttributeModifier forkDamageAttribute = new EntityAttributeModifier(forkDamageAttributeUUID, FORK_DAMAGE_ATTRIBUTE, 2.0, EntityAttributeModifier.Operation.ADDITION);


    public ForkItem(Settings settings) {
        super(settings);
    }

    public ForkItem() {
        this(new Item.Settings().maxCount(1));
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            return ImmutableMultimap.of(EntityAttributes.GENERIC_ATTACK_DAMAGE, forkDamageAttribute);
        }
        return ImmutableMultimap.of();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("tooltip.quincyplate.fork_common_1"));
        tooltip.add(Text.translatable("tooltip.quincyplate.fork_common_2"));
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World level = context.getWorld();
        if (!level.isClient) {
            BlockPos platePos = context.getBlockPos();
            Vec3d hit = context.getHitPos();
            BlockEntity blockEntity = level.getBlockEntity(platePos);
            if (blockEntity instanceof PlateBlockEntity plate &&
                    context.getHand() == Hand.MAIN_HAND &&
                    context.getSide() == Direction.UP
            ) {
                ItemStack forkStack = context.getStack();
                PlayerEntity player = context.getPlayer();
                if (player == null) return ActionResult.FAIL;
                double x = hit.x - plate.getPos().getX();
                double z = hit.z - plate.getPos().getZ();
                if (plate.stickFork(player, forkStack.copyWithCount(1), x, z, Math.toRadians(player.getYaw()))) {
                    if (!player.getAbilities().creativeMode) {
                        forkStack.decrement(1);
                    }
                    return ActionResult.SUCCESS;
                }
                return ActionResult.PASS;
            }
        }
        return super.useOnBlock(context);
    }

}
