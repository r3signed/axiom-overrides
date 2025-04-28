package com.r3signed.overrides.mixins;

import com.moulberry.axiom.screen.CustomCreativeTabButton;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@IfModLoaded("axiom")
@Mixin(value = Screen.class, priority = 1000000)
public class ScreenMixin {
    /**
     * Removes the "Colour Picker" and "Gradient Helper" buttons from the Axiom mod.
     */
    @Inject(
            method = "addDrawableChild",
            at = @At("HEAD"),
            cancellable = true
    )
    private <T extends Element> void onAddDrawableChild(T drawable, CallbackInfoReturnable<T> cir) {
        if (drawable instanceof CustomCreativeTabButton button) {
            String text = button.getMessage().getString();
            if (text.equals("Colour Picker") || text.equals("Gradient Helper")) {
                cir.cancel();
            }
        }
    }

}
