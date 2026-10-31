package com.example.customhunger.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public class HungerManagerMixin {
    @Shadow private float exhaustion;

    @Inject(method = "update", at = @At("HEAD"))
    private void modifyHungerRates(PlayerEntity player, CallbackInfo ci) {
        // Замедление траты голода в 2 раза
        if (this.exhaustion > 4.0F) {
            this.exhaustion -= 2.0F;
        }
    }
}
