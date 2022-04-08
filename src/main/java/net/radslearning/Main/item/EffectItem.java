package net.radslearning.Main.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//Dumpster this class? Probably won't need it...

public class EffectItem extends Item {


    public EffectItem(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }

    public void applySpeedEffect(LivingEntity entity, int amplifier) {       
        if (entity instanceof PlayerEntity) {
           entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 800, 1));
        }
    }
    
}
