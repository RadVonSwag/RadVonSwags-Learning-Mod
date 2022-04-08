package net.radslearning.Main.statuseffects;

import net.minecraft.client.gl.EffectProgram;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Potion;

public class Leaning extends StatusEffect{

    public Leaning() {
        super(StatusEffectCategory.NEUTRAL, 0x6901b9);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
           entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1200, 0));
           entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1200, 3));
           entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 1200, 0));
        }
    }


    
}
