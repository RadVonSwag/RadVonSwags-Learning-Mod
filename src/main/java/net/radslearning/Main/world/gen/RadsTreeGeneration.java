package net.radslearning.Main.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.radslearning.Main.world.feature.RadsPlacedFeatures;
import net.minecraft.world.gen.*;

public class RadsTreeGeneration {

    public static void generateTrees() {
        generateLemonWoodTree();
        generateLimeWoodTree();
    }

    public static void generateLemonWoodTree() {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, BuiltinRegistries.PLACED_FEATURE.getKey(RadsPlacedFeatures.LEMON_WOOD_PLACED).get());
    }

    public static void generateLimeWoodTree() {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, BuiltinRegistries.PLACED_FEATURE.getKey(RadsPlacedFeatures.LIME_WOOD_PLACED).get());
    }
}
