package farn.DebugScreenFeatureUnlocker.mixin;

import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.Gui;
import farn.DebugScreenFeatureUnlocker.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = GuiIngame.class, remap = false)
public class GuiIngameMixin extends Gui {
    @ModifyVariable(method = "renderGameOverlay", at = @At("STORE"), ordinal = 1)
    private boolean unlockClockFeature(boolean value) {
        return Main.ClockFeature;
    }

    @ModifyVariable(method = "renderGameOverlay", at = @At("STORE"), ordinal = 2)
    private boolean unlockCompassFeature(boolean value) {
        return Main.CompassFeature;
    }

    @ModifyVariable(method = "renderGameOverlay", at = @At("STORE"), ordinal = 3)
    private boolean unlockCalenderFeature(boolean value) {
        return Main.CalenderFeature;
    }
}
