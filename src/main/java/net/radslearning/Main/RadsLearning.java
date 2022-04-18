package net.radslearning.Main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.radslearning.Main.block.RadsLearningBlocks;
import net.radslearning.Main.item.RadsLearningItems;
import net.radslearning.Main.statuseffects.RadsLearningStatusEffects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadsLearning implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("radslearning");
	public static final String MOD_ID = "radslearning";
	public static final ItemGroup RADS_LEARNING = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "stuff"), () -> new ItemStack(RadsLearningItems.LEAN));

	@Override
	public void onInitialize() {
		register();
	}

	public static void register() {
		RadsLearningItems.register();
		RadsLearningBlocks.register();
		RadsLearningStatusEffects.register();

		
	}
}
