package farn.DebugScreenFeatureUnlocker;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class Main implements ModInitializer {
    public static final String MOD_ID = "Debug_screen_feature_unlocker";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static boolean CompassFeature = true;
    public static boolean ClockFeature = true;
    public static boolean CalenderFeature = true;

    @Override
    public void onInitialize() {
        LOGGER.info("init Debug Screen feature Unlocker mod");
        initConfig();
    }

    public void initConfig() {
        File configFile = new File(FabricLoader.getInstance().getConfigDir() + "Debug_screen_feature_unlocker.cfg");
        Properties prop = new Properties();
        if(!configFile.exists()) {
            try {
                BufferedWriter configWriter = new BufferedWriter(new FileWriter(configFile));
                configWriter.write("#This is a configuration file for Farn's Debug Screen feature Unlocker mod" + newLine());
                configWriter.write("#This File contain a option that allowed allowed you to Disable or Enable debug screen feature" + newLine());
                configWriter.write("Compass_Feature=" + CompassFeature + newLine());
                configWriter.write("Clock_Feature=" + ClockFeature + newLine());
                configWriter.write("Calender_Feature=" + CalenderFeature + newLine());
                configWriter.close();
                LOGGER.info("successfully make config file");
            } catch (Exception e) {
                LOGGER.error("failed to make config file");
                e.printStackTrace();
            }
        }

        try {
            prop.load(new FileInputStream(configFile));
            CompassFeature = Boolean.parseBoolean(prop.getProperty("Compass_Feature"));
            ClockFeature = Boolean.parseBoolean(prop.getProperty("Clock_Feature"));
            CalenderFeature = Boolean.parseBoolean(prop.getProperty("Calender_Feature"));
            LOGGER.info("successfully make config file");
        } catch (Exception e) {
            LOGGER.error("failed to read config file");
            e.printStackTrace();
        }

    }

    public static String newLine() {
        return System.getProperty("line.separator");
    }
}
