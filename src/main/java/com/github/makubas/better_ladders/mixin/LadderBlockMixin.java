package com.github.makubas.better_ladders.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.Waterloggable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LadderBlock.class)
public class LadderBlockMixin extends Block implements Waterloggable {
    public LadderBlockMixin(Settings settings) {
        super(settings);
    }
}
