package net.radslearning.Main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.item.Lean;
import net.radslearning.Main.item.RadsLearningItems;
import net.radslearning.Main.statuseffects.Leaning;
import net.radslearning.Main.statuseffects.RadsLearningStatusEffects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadsLearning implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("radslearning");
	public static final String MOD_ID = "radslearning";
	public static final ItemGroup RADS_LEARNING = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "stuff"), () -> new ItemStack(Items.KELP));

	@Override
	public void onInitialize() {
		register();
	}

	public static void register() {

		RadsLearningItems.register();
		RadsLearningStatusEffects.register();
		
	}
}
