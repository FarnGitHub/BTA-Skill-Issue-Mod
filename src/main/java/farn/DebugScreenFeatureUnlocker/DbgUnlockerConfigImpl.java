package farn.DebugScreenFeatureUnlocker;

import io.github.prospector.modmenu.api.ModMenuApi;
import net.minecraft.client.gui.GuiScreen;
import java.util.function.Function;

public class DbgUnlockerConfigImpl implements ModMenuApi {
    @Override
    public String getModId() {
        return DbgUnlocker.MOD_ID;
    }

    @Override
    public Function<GuiScreen, ? extends GuiScreen> getConfigScreenFactory() {
        return screen -> new GuiDbgUnlockerConfig(screen);
    }
}
