package net.radslearning.Main.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * For debugging purposes.
 * Currently debugging: Nothing
 */
public class DebugItem extends Item {

    public DebugItem(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    
}
