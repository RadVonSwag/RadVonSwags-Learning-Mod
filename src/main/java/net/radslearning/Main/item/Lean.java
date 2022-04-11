package net.radslearning.Main.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.radslearning.Main.statuseffects.Leaning;
import net.radslearning.Main.statuseffects.RadsLearningStatusEffects;

public class Lean extends Item {

    public Lean(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }
    
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity) user : null;

        if (this.isFood()) {
            return playerEntity.eatFood(world, stack);
        }

        if (!(playerEntity.isCreative())) {
            stack.decrement(1);
            playerEntity.giveItemStack(new ItemStack(RadsLearningItems.STYROFOAM_CUP));
		}
        
        if (world.isClient()) {
            playerEntity.addStatusEffect(new StatusEffectInstance(RadsLearningStatusEffects.LEANING, 1200, 0));
        }

        return stack;
    }
}
