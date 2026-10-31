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
    @Shadow private float foodExhaustion;

    @Inject(method = "update", at = @At("HEAD"))
    private void modifyHungerRates(PlayerEntity player, CallbackInfo ci) {
        if (this.foodExhaustion > 4.0F) {
            this.foodExhaustion -= 2.0F;
        }
    }
}
