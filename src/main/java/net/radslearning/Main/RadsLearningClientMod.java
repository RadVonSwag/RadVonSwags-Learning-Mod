package net.radslearning.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.radslearning.Main.block.RadsLearningBlocks;

public class RadsLearningClientMod implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("Rad's Learning");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Block Render Layers...");
        BlockRenderLayerMap.INSTANCE.putBlock(RadsLearningBlocks.LEMON_WOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RadsLearningBlocks.LEMON_WOOD_SAPLING, RenderLayer.getCutout());
        
    }
    
}
