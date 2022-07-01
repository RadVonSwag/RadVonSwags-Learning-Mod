package net.radslearning.Main.entities.vehicles;

import net.minecraft.entity.vehicle.BoatEntity.Type;

import static net.radslearning.Main.block.RadsLearningBlocks.*;
import static net.radslearning.Main.util.EnumExtender.add;

public class RadsBoatEntity {
    public static final Type LEMON_WOOD = add(Type.class, "LEMON_WOOD", LEMON_WOOD_PLANKS, "lemon_wood");
    public static final Type LIME_WOOD = add(Type.class, "LIME_WOOD", LIME_WOOD_PLANKS, "lime_wood");
}
