package net.radslearning.Main.potion;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.RadsLearning;

public class RadsPotions extends Potion {

    private static final Map<Identifier, Potion> POTIONS = new LinkedHashMap<Identifier, Potion>();
    
    public static Potion HOMEMADE_COUGH_SYRUP = add("homemade_cough_syrup", new Potion(new StatusEffectInstance(StatusEffects.REGENERATION, 1200, 1), new StatusEffectInstance(StatusEffects.NAUSEA, 1800, 0)));

    private static <P extends Potion> P add(String name, P potion) {
        POTIONS.put(new Identifier(RadsLearning.MOD_ID, name), potion);
        return potion;
    }

    public static void register() {
        for (Identifier id : POTIONS.keySet()) {
            Registry.register(Registry.POTION, id, POTIONS.get(id));
        }
    }
}
