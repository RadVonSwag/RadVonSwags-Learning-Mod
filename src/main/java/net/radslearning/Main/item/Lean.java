package net.radslearning.Main.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.radslearning.Main.statuseffects.Leaning;
import net.minecraft.potion.Potion;

public class Lean extends Item {

    public Lean(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!playerEntity.isCreative()) {
			playerEntity.getStackInHand(hand).decrement(1);
            playerEntity.giveItemStack(new ItemStack(Items.GLASS_BOTTLE));
		}
        new Leaning().applyUpdateEffect(playerEntity, 1);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
