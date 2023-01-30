package net.radslearning.Main.world.feature.tree;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.radslearning.Main.world.feature.RadsConfiguredFeatures;

public class LimeWoodSaplingGenerator extends SaplingGenerator {
    
    @Nullable
    @Override
    protected ConfiguredFeature<?, ?> getTreeFeature(Random var1, boolean var2) {
        return RadsConfiguredFeatures.LIME_WOOD_TREE;
    }
    
}
