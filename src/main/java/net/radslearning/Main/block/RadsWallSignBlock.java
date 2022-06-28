package net.radslearning.Main.block;

import net.minecraft.block.WallSignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.radslearning.Main.RadsLearning;

public class RadsWallSignBlock extends WallSignBlock {

    public RadsWallSignBlock(Settings settings, SignType signType) {
        super(settings, signType);
    }

    @Override
    public final Identifier getLootTableId() {
        Identifier correctedLootTableId = new Identifier(RadsLearning.MOD_ID, "blocks/" + this.getSignType().getName() + "_sign");
        if (this.lootTableId != correctedLootTableId) {
            this.lootTableId = correctedLootTableId;
        }

        return this.lootTableId;
    }
    
}
