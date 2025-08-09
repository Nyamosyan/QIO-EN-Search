package com.nyamosyan.mixin;

import com.nyamosyan.common.util.EnUsLangCache;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Locale;

@Mixin(targets = "mekanism.common.content.qio.SearchQueryParser$QueryType$1", remap = false)
public abstract class MixinQueryType {
    @Inject(method = "matches", at = @At("HEAD"), cancellable = true)
    private void matches_en(Level level, Player player, String key, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if(key == null || key.isEmpty()) return;

        String translationKey = stack.getItem().getDescriptionId(stack);
        String enName = EnUsLangCache.getEnUsName(translationKey).toLowerCase(Locale.ROOT);
        if(enName.contains(key)) {
            cir.setReturnValue(true);
        }
    }
}
