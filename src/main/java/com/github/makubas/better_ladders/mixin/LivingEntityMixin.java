package com.github.makubas.better_ladders.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow public abstract boolean isClimbing();
    @Shadow public abstract boolean isHoldingOntoLadder();
    @Shadow protected boolean jumping;
    @Shadow public abstract boolean isInsideWall();

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("RETURN"), method = "applyClimbingSpeed", cancellable = true)
    protected void applyClimbingSpeed(Vec3d motion, CallbackInfoReturnable<Vec3d> cir) {

    }

}
