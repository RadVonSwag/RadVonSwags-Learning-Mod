package net.radslearning.Main.item;

import net.minecraft.item.Item;

import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class Lemon_Lime_Soda extends Item {

    public Lemon_Lime_Soda(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
}
