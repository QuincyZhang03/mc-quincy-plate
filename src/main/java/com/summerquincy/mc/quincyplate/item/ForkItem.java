package com.summerquincy.mc.quincyplate.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ForkItem extends Item {
    public ForkItem(Properties pProperties) {
        super(pProperties);
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
        pTooltipComponents.add(Component.translatable("tooltip.quincyplate.fork_common"));
    }
}
