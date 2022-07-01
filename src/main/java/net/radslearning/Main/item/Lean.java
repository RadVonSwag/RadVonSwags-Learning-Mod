package net.radslearning.Main.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.radslearning.Main.statuseffects.RadsStatusEffects;

public class Lean extends Item {

    public Lean(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity) user : null;

        if (!(playerEntity.isCreative())) {
            playerEntity.giveItemStack(new ItemStack(RadsItems.STYROFOAM_CUP));
		}
        
        if (!(playerEntity == null)) {
            playerEntity.addStatusEffect(new StatusEffectInstance(RadsStatusEffects.LEANING, 1200, 0));
        }
        return result;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }
}
