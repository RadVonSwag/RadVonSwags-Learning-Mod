package net.radslearning.Main.block;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WoodenButtonBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.RadsLearning;
import net.radslearning.Main.world.feature.tree.LemonWoodSaplingGenerator;

public class RadsLearningBlocks {
    
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<Identifier, Block>();
    private static final Map<Identifier, Item> BLOCK_ITEMS = new LinkedHashMap<Identifier, Item>();

    public static final Block MISSING_TEXTURE_BLOCK = add("missing_texture_block", new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)));
    public static final Block LEMON_WOOD_LOG = add("lemon_wood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block LEMON_WOOD = add("lemon_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block LEMON_WOOD_PLANKS = add("lemon_wood_planks", new Block(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)));
    public static final Block STRIPPED_LEMON_WOOD_LOG = add("stripped_lemon_wood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_LEMON_WOOD = add("stripped_lemon_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final Block LEMON_WOOD_LEAVES = add("lemon_wood_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_LEAVES).nonOpaque()));
    public static final Block LEMON_WOOD_SAPLING = add("lemon_wood_sapling", new RadsSaplingBlock(new LemonWoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));
    public static final Block LEMON_WOOD_STAIRS = add("lemon_wood_stairs", new RadsStairsBlock(LEMON_WOOD_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(LEMON_WOOD_PLANKS)));
    public static final Block LEMON_WOOD_SLAB = add("lemon_wood_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_SLAB)));
    public static final Block LEMON_WOOD_FENCE = add("lemon_wood_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_FENCE)));
    public static final Block LEMON_WOOD_BUTTON = add("lemon_wood_button", new RadsWoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_BUTTON)));
    public static final Block LEMON_WOOD_PRESSURE_PLATE = add("lemon_wood_pressure_plate", new RadsPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.BIRCH_PRESSURE_PLATE)));
    public static final Block LEMON_WOOD_DOOR = add("lemon_wood_door", new RadsDoorBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_DOOR).nonOpaque()));


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
        instance.add(LEMON_WOOD_STAIRS, 5, 20);
        instance.add(LEMON_WOOD_SLAB, 5, 20);
    }

    private static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(LEMON_WOOD_LOG, STRIPPED_LEMON_WOOD_LOG);
    }

    //Custom Classes for protected constructor access

    private static class RadsStairsBlock extends StairsBlock {
        protected RadsStairsBlock(BlockState baseBlockState, Settings settings) {
            super(baseBlockState, settings);
        }
    }
    private static class RadsSaplingBlock extends SaplingBlock {
        public RadsSaplingBlock(SaplingGenerator generator, Settings settings) {
            super(generator, settings);
        }
    }

    private static class RadsWoodenButtonBlock extends WoodenButtonBlock {
        protected RadsWoodenButtonBlock(Settings settings) {
            super(settings);
        }
        
    }

    private static class RadsPressurePlateBlock extends PressurePlateBlock {
        protected RadsPressurePlateBlock(ActivationRule type, Settings settings) {
            super(type, settings);
        }
        
    }

    private static class RadsDoorBlock extends DoorBlock {
        protected RadsDoorBlock(Settings settings) {
            super(settings);
        }
        
    }
}
