package net.radslearning.Main.crops;

import javax.swing.text.html.BlockView;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.radslearning.Main.item.RadsLearningItems;

public class LemonBush extends CropBlock {

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D)};
    
    protected LemonBush(Settings settings) {
        super(FabricBlockSettings.copyOf(Blocks.WHEAT));
    }

public ItemConvertible getSeedsItem() {
    return RadsLearningItems.LEMON;
}

/* @Override
protected booleanß canPlantOnTop(net.minecraft.block.BlockState floor, net.minecraft.world.BlockView world, net.minecraft.util.math.BlockPos pos) {
    return true;
  } */

public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    return AGE_TO_SHAPE[(Integer)state.get(this.getAgeProperty())];
}
    
}
