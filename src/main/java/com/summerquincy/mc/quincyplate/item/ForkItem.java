package com.summerquincy.mc.quincyplate.item;

import com.summerquincy.mc.quincyplate.QuincyPlateMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.List;

public class ForkItem extends Item {
    public ForkItem(Properties pProperties) {
        super(pProperties);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {
        return super.getAttackDamageBonus(target, damage, damageSource);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE,new AttributeModifier(ResourceLocation.fromNamespaceAndPath(QuincyPlateMod.MODID,"fork_damage"),2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext context, List<Component> pTooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(pStack, context, pTooltipComponents, tooltipFlag);
        pTooltipComponents.add(Component.translatable("tooltip.quincyplate.fork_common"));
    }
}
