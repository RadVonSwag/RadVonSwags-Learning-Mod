package net.radslearning.Main.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.radslearning.Main.statuseffects.RadsLearningStatusEffects;

public class DebugItem extends Item {

    public DebugItem(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!(user.isCreative())) {
            user.giveItemStack(new ItemStack(RadsLearningItems.STYROFOAM_CUP));
            user.getStackInHand(hand).decrement(1);
		}
        
       if (!(user == null)) {
            user.addStatusEffect(new StatusEffectInstance(RadsLearningStatusEffects.LEANING, 1200, 0));
        }
        
        return TypedActionResult.success(user.getStackInHand(hand));
        
    }
    
}
