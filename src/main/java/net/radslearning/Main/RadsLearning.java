package net.radslearning.Main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.item.Lean;
import net.radslearning.Main.item.RadsLearningItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadsLearning implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("radslearning");
	public static final String MOD_ID = "radslearning";


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		
		register();
		
		//LOGGER.info("Hello Fabric world!");
	}

	public static void register() {

		RadsLearningItems.register();
		//public static final ItemGroup RADS_LEARNING = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "Stuff"), () -> new ItemStack(Items.KELP));
	}
}
