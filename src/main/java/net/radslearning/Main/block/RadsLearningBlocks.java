package net.radslearning.Main.block;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.RadsLearning;
import net.radslearning.Main.block.custom.ModSaplingBlock;
import net.radslearning.Main.world.feature.tree.LemonWoodSaplingGenerator;

public class RadsLearningBlocks {
    
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<Identifier, Block>();
    private static final Map<Identifier, Item> BLOCK_ITEMS = new LinkedHashMap<Identifier, Item>();

    public static final Block TEST_BLOCK = add("test_block", new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f)));
    public static final Block LEMON_WOOD_LOG = add("lemon_wood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block LEMON_WOOD = add("lemon_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block LEMON_WOOD_PLANKS = add("lemon_wood_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block STRIPPED_LEMON_WOOD_LOG = add("stripped_lemon_wood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = add("stripped_lemon_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block LEMON_WOOD_LEAVES = add("lemon_wood_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block LEMON_WOOD_SAPLING = add("lemon_wood_sapling", new ModSaplingBlock(new LemonWoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

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

        registerFlammableBlocks();
        registerStrippableBlocks();
    }

    private static void registerFlammableBlocks() {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(LEMON_WOOD_LOG, 5, 5);
        instance.add(LEMON_WOOD, 5, 5);
        instance.add(STRIPPED_LEMON_WOOD_LOG, 5, 5);
        instance.add(STRIPPED_LEMON_WOOD, 5, 5);
        instance.add(LEMON_WOOD_PLANKS, 5, 20);
        instance.add(LEMON_WOOD_LEAVES, 30, 60);
    }

    private static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(LEMON_WOOD_LOG, STRIPPED_LEMON_WOOD_LOG);
    }
}
