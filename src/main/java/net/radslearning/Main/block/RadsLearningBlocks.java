package net.radslearning.Main.block;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.RadsLearning;

public class RadsLearningBlocks {
    
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<Identifier, Block>();
    private static final Map<Identifier, Item> BLOCK_ITEMS = new LinkedHashMap<Identifier, Item>();

    public static final Block TEST_BLOCK = add("test_block", new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f)));
    public static final Block LEMON_WOOD_LOG = add("lemon_wood_log", new Block(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block LEMON_WOOD_PLANKS = add("lemon_wood_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    private static <B extends Block> B add(String name, B block) {
        BLOCKS.put(new Identifier(RadsLearning.MOD_ID, name), block);
        BLOCK_ITEMS.put(new Identifier(RadsLearning.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(RadsLearning.RADS_LEARNING)));
        return block;
    }
    
    public static void register() {
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
        for (Identifier id : BLOCK_ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, BLOCK_ITEMS.get(id));
        }
    }
}
