package net.radslearning.Main.statuseffects;

import net.minecraft.client.gl.EffectProgram;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Potion;

public class Leaning extends StatusEffect{

    final Potion NAUSEA = Potion.byId("nausea");

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
            ((PlayerEntity) entity).addExhaustion(1 << amplifier);
            //((PlayerEntity) entity).addStatusEffect(new StaticEffectInstance()));
        }
    }


    
}
