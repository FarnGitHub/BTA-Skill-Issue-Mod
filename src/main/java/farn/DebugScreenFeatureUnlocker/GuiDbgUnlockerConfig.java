package farn.DebugScreenFeatureUnlocker;

import net.minecraft.client.gui.*;
import net.minecraft.core.lang.I18n;


public class GuiDbgUnlockerConfig extends GuiScreen {
    private int centerButtonY = this.height / 4 + 48;
    public GuiDbgUnlockerConfig(GuiScreen par) {
        super(par);
    }

    @Override
    public void drawScreen(int x, int y, float renderPartialTicks) {
        this.drawDefaultBackground();
        this.drawStringCentered(this.fontRenderer, "Debug Feature Unlocker Options", this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(x, y, renderPartialTicks);
    }

    @Override
    public void initGui() {
        I18n i18n = I18n.getInstance();
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, centerButtonY + 72 - 60, translateKey("item.tool.compass.name") + ": " + optionBoolString(DbgUnlocker.CompassFeature)));
        this.controlList.add(new GuiButton(1, this.width / 2 - 100, centerButtonY + 72 - 30, translateKey("item.tool.clock.name") + ": " + optionBoolString(DbgUnlocker.ClockFeature)));
        this.controlList.add(new GuiButton(2, this.width / 2 - 100, centerButtonY + 72, translateKey("item.tool.calendar.name") + ": " + optionBoolString(DbgUnlocker.CalenderFeature)));
        this.controlList.add(new GuiButton(3, this.width / 2 - 100, centerButtonY + 72 + 60, translateKey("gui.done")));
    }

    @Override
    protected void buttonPressed(GuiButton guibutton) {
        if(guibutton.id != 3) {
            if (guibutton.id == 0) {
                DbgUnlocker.CompassFeature = !DbgUnlocker.CompassFeature;
                guibutton.displayString = translateKey("item.tool.compass.name") + ": " + optionBoolString(DbgUnlocker.CompassFeature);
            } else if (guibutton.id == 1) {
                DbgUnlocker.ClockFeature = !DbgUnlocker.ClockFeature;
                guibutton.displayString = translateKey("item.tool.clock.name") + ": " + optionBoolString(DbgUnlocker.ClockFeature);
            } else if (guibutton.id == 2) {
                DbgUnlocker.CalenderFeature = !DbgUnlocker.CalenderFeature;
                guibutton.displayString = translateKey("item.tool.calendar.name") + ": " + optionBoolString(DbgUnlocker.CalenderFeature);
            }

            DbgUnlocker.writeConfig();
        } else {
            this.mc.displayGuiScreen(this.getParentScreen());
        }

        if (guibutton.id == 3) {
            DbgUnlocker.writeConfig();
            this.mc.displayGuiScreen(this.getParentScreen());
        }

    }

    public String translateKey(String string) {
        return I18n.getInstance().translateKey(string);
    }

    public String optionBoolString(boolean bool) {
        return bool == true ? translateKey("options.on") : translateKey("options.off");
    }
}
