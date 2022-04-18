package net.radslearning.Main.crops;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RadsLearningCrops {
    public static final CropBlock LEMON_BUSH = new LemonBush(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));


    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("radslearning","lemon_bush"), LEMON_BUSH);
    }
}
