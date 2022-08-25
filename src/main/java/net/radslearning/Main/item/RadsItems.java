package net.radslearning.Main.item;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.radslearning.Main.entities.vehicles.RadsBoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.RadsLearning;
import net.radslearning.Main.block.RadsBlocks;

public class RadsItems {
    
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<Identifier, Item>();
    
    public static final Lean LEAN = add("lean", new Lean(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).maxCount(16).food(new FoodComponent.Builder().hunger(1).alwaysEdible().build())));
    public static final Item COUGH_SYRUP = add("cough_syrup", new Item(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).maxCount(64)));
    public static final DrinkItem LEMON_LIME_SODA = add("lemon_lime_soda", new DrinkItem(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).food(new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 800, 0), 1).build()).maxCount(16)));
    public static final Item GRAPE_JOLLY = add("grape_jolly", new Item(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).food(new FoodComponent.Builder().hunger(1).saturationModifier(1).build())));
    public static final Item STYROFOAM_CUP = add("styrofoam_cup", new Item(new FabricItemSettings().group(RadsLearning.RADS_LEARNING)));
    public static final DebugItem DEBUG = add("debug", new DebugItem(new FabricItemSettings().group(RadsLearning.RADS_LEARNING)));
    public static final DrinkItem CARBONATED_WATER = add("carbonated_water", new DrinkItem(new FabricItemSettings().group(RadsLearning.RADS_LEARNING)));
    public static final Item LEMON = add("lemon", new Item(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).food(new FoodComponent.Builder().hunger(1).saturationModifier(1).build())));
    public static final Item LIME = add("lime", new Item(new FabricItemSettings().group(RadsLearning.RADS_LEARNING).food(new FoodComponent.Builder().hunger(1).saturationModifier(1).build())));
    public static final BoatItem LEMON_WOOD_BOAT = add("lemon_wood_boat", new BoatItem(RadsBoatEntity.LEMON_WOOD, new FabricItemSettings().maxCount(1).group(RadsLearning.RADS_LEARNING)));
    public static final BoatItem LIME_WOOD_BOAT = add("lime_wood_boat", new BoatItem(RadsBoatEntity.LIME_WOOD, new FabricItemSettings().maxCount(1).group(RadsLearning.RADS_LEARNING)));
    public static final SignItem LEMON_WOOD_SIGN = add("lemon_wood_sign", new SignItem(new Item.Settings().maxCount(16).group(RadsLearning.RADS_LEARNING), RadsBlocks.LEMON_WOOD_SIGN, RadsBlocks.LEMON_WOOD_WALL_SIGN));
    public static final Item LEMON_SEEDS = add("lemon_seeds", new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(0).build()).group(RadsLearning.RADS_LEARNING)));


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
