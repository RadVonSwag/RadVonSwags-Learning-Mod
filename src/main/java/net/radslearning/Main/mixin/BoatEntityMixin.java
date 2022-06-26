package net.radslearning.Main.mixin;

import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.radslearning.Main.RadsLearning;
import net.radslearning.Main.entities.vehicles.RadsBoatEntity;
import net.radslearning.Main.item.RadsLearningItems;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntity.class)
public abstract class BoatEntityMixin {
    @Shadow
    public abstract BoatEntity.Type getBoatType();

    @Inject(method = "asItem", at = @At(value = "FIELD", target = "Lnet/minecraft/item/Items;OAK_BOAT:Lnet/minecraft/item/Item;", opcode = Opcodes.GETSTATIC), cancellable = true)
    private void checkRadsBoats(CallbackInfoReturnable<Item> cir) {
        BoatEntity.Type type = this.getBoatType();
        RadsLearning.LOGGER.info("Mixed BoatEntity");

        if (type != BoatEntity.Type.OAK) {
            if (type == RadsBoatEntity.LEMON_WOOD)
                cir.setReturnValue(RadsLearningItems.LEMON_WOOD_BOAT);
        }
    }
}
