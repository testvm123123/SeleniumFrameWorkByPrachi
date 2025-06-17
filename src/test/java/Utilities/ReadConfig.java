package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties prop;

    public ReadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file.");
        }
    }

    public String getBaseUrl() {
        String value = prop.getProperty("baseUrl");
        if (value != null)
            return value;
        else
            throw new RuntimeException("Base URL not specified in the config file.");
    }

    public String getBrowser() {
        String value = prop.getProperty("browser");
        if (value != null)
            return value;
        else
            throw new RuntimeException("Browser not specified in the config file.");
    }
}
