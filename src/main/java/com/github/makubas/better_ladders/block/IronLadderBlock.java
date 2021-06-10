package com.github.makubas.better_ladders.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class IronLadderBlock extends LadderBlock {

    public IronLadderBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                .breakByHand(false)
                .breakByTool(FabricToolTags.PICKAXES)
                .sounds(BlockSoundGroup.METAL)
                .hardness(1.5F));
    }
}
