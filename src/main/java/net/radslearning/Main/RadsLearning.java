package net.radslearning.Main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.radslearning.Main.block.RadsBlockRenderLayerInitializer;
import net.radslearning.Main.block.RadsLearningBlocks;
import net.radslearning.Main.item.RadsLearningItems;
import net.radslearning.Main.statuseffects.RadsLearningStatusEffects;
import net.radslearning.Main.world.gen.RadsWorldGen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadsLearning implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Rad's Learning");
	public static final String MOD_ID = "radslearning";
	public static final ItemGroup RADS_LEARNING = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "stuff"), () -> new ItemStack(RadsLearningItems.LEAN));

	@Override
	public void onInitialize() {

		register();
		RadsWorldGen.generateRadsWorldGen();
		RadsBlockRenderLayerInitializer.renderBlockLayers();
	}

	public static void register() {
		LOGGER.info("Registering Rad's Stuff");
		//RadsLearningItems.register();
		RadsLearningBlocks.register();
		RadsLearningStatusEffects.register();

		
	}
}
