package net.radslearning.Main.world.feature;

import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class RadsPlacedFeatures {

    public static final PlacedFeature LEMON_WOOD_PLACED = PlacedFeatures
            .register("lemon_wood_placed", RadsConfiguredFeatures.LEMON_WOOD_SPAWN
                    .withPlacement(VegetationPlacedFeatures
                            .modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1))));

     public static final PlacedFeature LIME_WOOD_PLACED = PlacedFeatures
            .register("lime_wood_placed", RadsConfiguredFeatures.LIME_WOOD_SPAWN
                    .withPlacement(VegetationPlacedFeatures
                            .modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1))));                       

}
