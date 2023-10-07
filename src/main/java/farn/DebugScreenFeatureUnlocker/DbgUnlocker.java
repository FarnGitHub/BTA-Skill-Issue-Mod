package farn.DebugScreenFeatureUnlocker;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class DbgUnlocker implements ModInitializer {
    public static final String MOD_ID = "Debug_screen_feature_unlocker";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static boolean CompassFeature = true;
    public static boolean ClockFeature = true;
    public static boolean CalenderFeature = true;

    private static File configFile = new File(FabricLoader.getInstance().getConfigDir() + "Debug_screen_feature_unlocker.cfg");

    private Properties prop = new Properties();

    @Override
    public void onInitialize() {
        LOGGER.info("init Debug Screen feature Unlocker mod");
        initConfig();
    }

    public static void initConfig() {
        Properties prop = new Properties();
        if(!configFile.exists()) {
            writeConfig();
        }

        try {
            prop.load(new FileInputStream(configFile));
            CompassFeature = Boolean.parseBoolean(prop.getProperty("Compass_Feature", "true"));
            ClockFeature = Boolean.parseBoolean(prop.getProperty("Clock_Feature", "true"));
            CalenderFeature = Boolean.parseBoolean(prop.getProperty("Calender_Feature", "true"));
        } catch (Exception e) {
            LOGGER.error("failed to read config file");
            e.printStackTrace();
        }

    }

    public static void writeConfig() {
        try {
            BufferedWriter configWriter = new BufferedWriter(new FileWriter(configFile));
            configWriter.write("#This is a configuration file for Farn's Debug Screen feature Unlocker mod" + System.getProperty("line.separator"));
            configWriter.write("#This File contain a option that allowed allowed you to Disable or Enable debug screen feature" + System.getProperty("line.separator"));
            configWriter.write("Compass_Feature=" + CompassFeature + System.getProperty("line.separator"));
            configWriter.write("Clock_Feature=" + ClockFeature + System.getProperty("line.separator"));
            configWriter.write("Calender_Feature=" + CalenderFeature + System.getProperty("line.separator"));
            configWriter.close();
        } catch (Exception e) {
            LOGGER.error("failed to make config file");
            e.printStackTrace();
        }
    }
}
