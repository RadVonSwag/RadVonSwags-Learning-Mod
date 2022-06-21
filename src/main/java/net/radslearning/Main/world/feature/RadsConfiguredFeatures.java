package net.radslearning.Main.world.feature;

import java.util.List;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.radslearning.Main.block.RadsLearningBlocks;

public class RadsConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> LEMON_WOOD_TREE = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new RadsBlockStateProvider(RadsLearningBlocks.LEMON_WOOD_LOG.getDefaultState()),
                    new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)),
                    new RadsBlockStateProvider(RadsLearningBlocks.LEMON_WOOD_LEAVES.getDefaultState()),
                    new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50),
                    new TwoLayersFeatureSize(1, 0, 1)).build());

    public static final PlacedFeature LEMON_WOOD_CHECKED = PlacedFeatures
            .register("lemon_wood_checked", LEMON_WOOD_TREE
                    .withWouldSurviveFilter(RadsLearningBlocks.LEMON_WOOD_SAPLING));

    public static final ConfiguredFeature<RandomFeatureConfig, ?> LEMON_WOOD_SPAWN = ConfiguredFeatures
            .register("lemon_wood_spawn", Feature.RANDOM_SELECTOR
                    .configure(
                            new RandomFeatureConfig(List.of(
                                    new RandomFeatureEntry(LEMON_WOOD_CHECKED, 0.8f)),
                                    LEMON_WOOD_CHECKED)));

    public static void register() {

    }

}
