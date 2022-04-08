package net.radslearning.Main.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.radslearning.Main.statuseffects.Leaning;

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
        if (this.isFood()) {
            return user.eatFood(world, stack);
        }

        PlayerEntity playerEntity = (PlayerEntity)user;

        if (!(playerEntity.isCreative())) {
            playerEntity.giveItemStack(new ItemStack(Items.GLASS_BOTTLE));
		}
        
        Leaning effect = new Leaning();
        effect.applyUpdateEffect(playerEntity, 2);

        return stack;
    }
}
