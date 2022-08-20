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
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SignBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodenButtonBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.Registry;
import net.radslearning.Main.RadsLearning;
import net.radslearning.Main.util.RadsSignType;
import net.radslearning.Main.world.feature.tree.LemonWoodSaplingGenerator;

public class RadsBlocks {
    
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<Identifier, Block>();
    private static final Map<Identifier, Item> BLOCK_ITEMS = new LinkedHashMap<Identifier, Item>();

    public static final Block MISSING_TEXTURE_BLOCK = add("missing_texture_block", new Block(FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE).requiresTool()));

    //Lemon Wood Blocks
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
    public static final Block LEMON_WOOD_TRAPDOOR = add("lemon_wood_trapdoor", new RadsTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_TRAPDOOR).nonOpaque()));
    public static final Block LEMON_WOOD_FENCE_GATE = add("lemon_wood_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_FENCE_GATE)));
    public static final Block LEMON_WOOD_SIGN = addWithoutItem("lemon_wood_sign", new RadsSignBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_SIGN), RadsSignType.LEMON_WOOD));
    public static final Block LEMON_WOOD_WALL_SIGN = addWithoutItem("lemon_wood_wall_sign", new RadsWallSignBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_WALL_SIGN).dropsLike(LEMON_WOOD_SIGN), RadsSignType.LEMON_WOOD));

    //Lime Wood Blocks
    public static final Block LIME_WOOD_LOG = add("lime_wood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block LIME_WOOD = add("lime_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block LIME_WOOD_PLANKS = add("lime_wood_planks", new Block(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)));
    public static final Block STRIPPED_LIME_WOOD_LOG = add("stripped_lime_wood_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_LIME_WOOD = add("stripped_lime_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final Block LIME_WOOD_LEAVES = add("lime_wood_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_LEAVES).nonOpaque()));
    public static final Block LIME_WOOD_SAPLING = add("lime_wood_sapling", new RadsSaplingBlock(new LemonWoodSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).nonOpaque()));
    public static final Block LIME_WOOD_STAIRS = add("lime_wood_stairs", new RadsStairsBlock(LIME_WOOD_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(LIME_WOOD_PLANKS)));
    public static final Block LIME_WOOD_SLAB = add("lime_wood_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_SLAB)));
    public static final Block LIME_WOOD_FENCE = add("lime_wood_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_FENCE)));
    public static final Block LIME_WOOD_BUTTON = add("lime_wood_button", new RadsWoodenButtonBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_BUTTON)));
    public static final Block LIME_WOOD_PRESSURE_PLATE = add("lime_wood_pressure_plate", new RadsPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.BIRCH_PRESSURE_PLATE)));
    public static final Block LIME_WOOD_DOOR = add("lime_wood_door", new RadsDoorBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_DOOR).nonOpaque()));
    public static final Block LIME_WOOD_TRAPDOOR = add("lime_wood_trapdoor", new RadsTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_TRAPDOOR).nonOpaque()));
    public static final Block LIME_WOOD_FENCE_GATE = add("lime_wood_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_FENCE_GATE)));
    public static final Block LIME_WOOD_SIGN = addWithoutItem("lime_wood_sign", new RadsSignBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_SIGN), RadsSignType.LIME_WOOD));
    public static final Block LIME_WOOD_WALL_SIGN = addWithoutItem("lime_wood_wall_sign", new RadsWallSignBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_WALL_SIGN).dropsLike(LIME_WOOD_SIGN), RadsSignType.LIME_WOOD));

    private static <B extends Block> B add(String name, B block) {
        BLOCKS.put(new Identifier(RadsLearning.MOD_ID, name), block);
        BLOCK_ITEMS.put(new Identifier(RadsLearning.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(RadsLearning.RADS_LEARNING)));
        return block;
    }

    private static <B extends Block> B addWithoutItem(String name, B block) {
        BLOCKS.put(new Identifier(RadsLearning.MOD_ID, name), block);
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
        instance.add(LEMON_WOOD_FENCE, 5, 20);
        instance.add(LEMON_WOOD_FENCE_GATE, 5, 20);
        instance.add(LEMON_WOOD_BUTTON, 5, 20);
        instance.add(LEMON_WOOD_PRESSURE_PLATE, 5, 20);
        instance.add(LEMON_WOOD_DOOR, 5, 20);
        instance.add(LEMON_WOOD_TRAPDOOR, 5, 20);
        instance.add(LEMON_WOOD_SIGN, 5, 20);
        instance.add(LEMON_WOOD_WALL_SIGN, 5, 20);

        instance.add(LIME_WOOD_LOG, 5, 5);
        instance.add(LIME_WOOD, 5, 5);
        instance.add(STRIPPED_LIME_WOOD_LOG, 5, 5);
        instance.add(STRIPPED_LIME_WOOD, 5, 5);
        instance.add(LIME_WOOD_PLANKS, 5, 20);
        instance.add(LIME_WOOD_LEAVES, 30, 60);
        instance.add(LIME_WOOD_STAIRS, 5, 20);
        instance.add(LIME_WOOD_SLAB, 5, 20);
        instance.add(LIME_WOOD_FENCE, 5, 20);
        instance.add(LIME_WOOD_FENCE_GATE, 5, 20);
        instance.add(LIME_WOOD_BUTTON, 5, 20);
        instance.add(LIME_WOOD_PRESSURE_PLATE, 5, 20);
        instance.add(LIME_WOOD_DOOR, 5, 20);
        instance.add(LIME_WOOD_TRAPDOOR, 5, 20);
        instance.add(LIME_WOOD_SIGN, 5, 20);
        instance.add(LIME_WOOD_WALL_SIGN, 5, 20);
    }

    private static void registerStrippableBlocks() {
        StrippableBlockRegistry.register(LEMON_WOOD_LOG, STRIPPED_LEMON_WOOD_LOG);
        StrippableBlockRegistry.register(LEMON_WOOD, STRIPPED_LEMON_WOOD);

        StrippableBlockRegistry.register(LIME_WOOD_LOG, STRIPPED_LIME_WOOD_LOG);
        StrippableBlockRegistry.register(LIME_WOOD, STRIPPED_LIME_WOOD);
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

    private static class RadsTrapdoorBlock extends TrapdoorBlock {
        protected RadsTrapdoorBlock(Settings settings) {
            super(settings);
        }
    }

    private static class RadsSignBlock extends SignBlock{
        public RadsSignBlock(Settings settings, SignType signType) {
            super(settings, signType);
        }
        @Override
        public final Identifier getLootTableId() {
            Identifier correctedLootTableId = new Identifier(RadsLearning.MOD_ID, "blocks/" + this.getSignType().getName() + "_sign");
            if (this.lootTableId != correctedLootTableId) {
                this.lootTableId = correctedLootTableId;
            }
            return this.lootTableId;
        }
    }

    private static class RadsWallSignBlock extends WallSignBlock {
        public RadsWallSignBlock(Settings settings, SignType signType) {
            super(settings, signType);
        }
        @Override
        public final Identifier getLootTableId() {
            Identifier correctedLootTableId = new Identifier(RadsLearning.MOD_ID, "blocks/" + this.getSignType().getName() + "_sign");
            if (this.lootTableId != correctedLootTableId) {
                this.lootTableId = correctedLootTableId;
            }
            return this.lootTableId;
        }
    }
}
