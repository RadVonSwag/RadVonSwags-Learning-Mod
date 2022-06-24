package net.radslearning.Main.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RadsBlockRenderLayerInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("Rad's Learning");

    public static void renderBlockLayers() {
        LOGGER.info("Initializing Block Render Layers...");
        BlockRenderLayerMap.INSTANCE.putBlock(RadsLearningBlocks.LEMON_WOOD_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(RadsLearningBlocks.LEMON_WOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RadsLearningBlocks.LEMON_WOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RadsLearningBlocks.LEMON_WOOD_TRAPDOOR, RenderLayer.getCutout());
        
    }
}
