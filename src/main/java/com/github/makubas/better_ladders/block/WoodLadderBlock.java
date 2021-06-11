package com.github.makubas.better_ladders.block;

import com.github.makubas.better_ladders.config.ConfigFile;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class WoodLadderBlock extends LadderBlock {

    public double ladderSpeed = ConfigFile.WOOD_LADDER_SPEED;

    public WoodLadderBlock() {
        super(FabricBlockSettings.of(Material.WOOD)
                .breakByHand(false)
                .breakByTool(FabricToolTags.AXES)
                .sounds(BlockSoundGroup.LADDER)
                .hardness(1.25F));
    }
}
