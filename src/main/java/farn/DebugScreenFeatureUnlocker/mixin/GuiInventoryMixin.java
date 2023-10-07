package farn.DebugScreenFeatureUnlocker.mixin;

import net.minecraft.client.gui.GuiInventory;
import farn.DebugScreenFeatureUnlocker.DbgUnlocker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = GuiInventory.class, remap = false)
public class GuiInventoryMixin {
    @ModifyVariable(method = "updateOverlayButtons", at = @At("STORE"), name="clock")
    private boolean unlockClockFeature(boolean value) {
        return DbgUnlocker.ClockFeature;
    }

    @ModifyVariable(method = "updateOverlayButtons", at = @At("STORE"), name="compass")
    private boolean unlockCompassFeature(boolean value) {
        return DbgUnlocker.CompassFeature;
    }

    @ModifyVariable(method = "updateOverlayButtons", at = @At("STORE"), name="rotaryCalendar")
    private boolean unlockCalenderFeature(boolean value) {
        return DbgUnlocker.CalenderFeature;
    }
}
