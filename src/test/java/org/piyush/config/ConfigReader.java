package org.piyush.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static void loadConfig(){
        // ALWAYS KEEP UNDER TRY CATCH SO NO OTHER METHODS WHERE ITS USED NEEDS TO ADD ITS METHOD SIGNATURE
        try{
            FileInputStream fis = new FileInputStream("src/test/java/config.properties");
            properties = new Properties();
            properties.load(fis);
        }catch(IOException e){
            throw new RuntimeException("Failed to load config file");
        }

    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
