package net.radslearning.Main.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;

@Mixin(BrewingRecipeRegistry.class)
public interface BrewingRecipeRegister {
    //For Potions
    @Invoker("registerPotionRecipe")
    static void registerPotionRecipe(Potion input, Item item, Potion output) {
        throw new AssertionError();
    }
}