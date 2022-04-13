package net.radslearning.Main.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class DrinkItem extends Item {

    public DrinkItem(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return getDrinkSound();
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity) user : null;
        
        if (!(playerEntity.isCreative())) {
            playerEntity.giveItemStack(new ItemStack(Items.GLASS_BOTTLE));
		}

        return result;
    }
    
}
