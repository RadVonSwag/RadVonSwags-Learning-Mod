package net.radslearning.Main.mixin;

import java.util.Arrays;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.Block;
import net.minecraft.entity.vehicle.BoatEntity;
import net.radslearning.Main.RadsLearning;
import net.radslearning.Main.util.EnumExtender;

@Mixin(BoatEntity.Type.class)
public class BoatEntityTypeMixin {
    @SuppressWarnings("ShadowTarget")
    @Shadow
    @Mutable
    @Final
    private static BoatEntity.Type[] field_7724;

    static {
        EnumExtender.register(BoatEntity.Type.class, (name, args) -> {
            BoatEntity.Type entry = (BoatEntity.Type) (Object) new BoatEntityTypeMixin(name, field_7724.length, (Block) args[0], (String) args[1]);
            field_7724 = Arrays.copyOf(field_7724, field_7724.length + 1);
            return field_7724[field_7724.length - 1] = entry;
        });
        RadsLearning.LOGGER.info("Mixed BoatEntityType");
    }

    private BoatEntityTypeMixin(String valueName, int ordinal, Block baseBlock, String name) {
        throw new AssertionError();
    }
}