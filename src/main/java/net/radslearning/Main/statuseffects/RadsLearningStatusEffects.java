package net.radslearning.Main.statuseffects;

import net.minecraft.util.registry.Registry;
import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.radslearning.Main.RadsLearning;

public class RadsLearningStatusEffects {

    private static final Map<Identifier, StatusEffect> STATUS_EFFECTS = new LinkedHashMap<Identifier, StatusEffect>();

    public static final StatusEffect LEANING = add ("leaning", new Leaning());
    
    private static <E extends StatusEffect> E add(String name, E status_effect) {
        STATUS_EFFECTS.put(new Identifier(RadsLearning.MOD_ID, name), status_effect);
        return status_effect;
    }

    public static void register() {
        for (Identifier id : STATUS_EFFECTS.keySet()) {
            Registry.register(Registry.STATUS_EFFECT, id, STATUS_EFFECTS.get(id));
        }
    }
}
