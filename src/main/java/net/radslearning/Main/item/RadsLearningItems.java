package net.radslearning.Main.item;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PotionItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.RadsLearning;
import net.radslearning.Main.statuseffects.Leaning;

public class RadsLearningItems {
    
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap();
    
    //public static final Lean LEAN = add("lean", new Lean(new FabricItemSettings().group(ItemGroup.BREWING).maxCount(1)));//new Lean(new FabricItemSettings().group(ItemGroup.BREWING).maxCount(1));
    public static final Lean LEAN = add("lean", new Lean(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).maxCount(16).food(new FoodComponent.Builder().hunger(1).alwaysEdible().build())));
    public static final Item COUGH_SYRUP = add("cough_syrup", new Item(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).maxCount(64)));
    public static final Item LEMON_LIME_SODA = add("lemon_lime_soda", new PotionItem(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).maxCount(16)));
    public static final Item GRAPE_JOLLY = add("grape_jolly", new Item(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).food(new FoodComponent.Builder().hunger(1).saturationModifier(1).alwaysEdible().build())));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(RadsLearning.MOD_ID, name), item);
        return item;
    }

    public static void register() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
    }
}
