package com.github.makubas.better_ladders.mixin;

import com.github.makubas.better_ladders.block.IronLadderBlock;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntityMixin {

    private static final double IRON_LADDER_SPEED = 0.2F;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void applyClimbingSpeed(Vec3d motion, CallbackInfoReturnable<Vec3d> cir) {
        BlockPos blockPos = getBlockPos();
        Block block = getEntityWorld().getBlockState(blockPos).getBlock();
        if (isClimbing()) {
            if (block instanceof IronLadderBlock) {
                MinecraftClient mc = MinecraftClient.getInstance();
                this.fallDistance = 0.0F;
                double d = MathHelper.clamp(motion.x, -0.15000000596046448D, 0.15000000596046448D);
                double e = MathHelper.clamp(motion.z, -0.15000000596046448D, 0.15000000596046448D);
                double g = Math.max(motion.y, -0.15000000596046448D);
                mc.inGameHud.addChatMessage(MessageType.SYSTEM, Text.of(String.valueOf(motion.y)), getUuid());
                if (g < 0.0D && this.isHoldingOntoLadder()) {
                    motion = new Vec3d(d, 0.0D, e);
                } else {
                    motion = new Vec3d(d, IRON_LADDER_SPEED, e);
                }
                cir.setReturnValue(motion);
            }
        }
    }
}
