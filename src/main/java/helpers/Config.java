package helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Hmayak Atayan on  27, Jun, 2020
 */
public class Config {
    public static String getConfig(String name) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader("src/test/resources/app.properties")) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(name);
    }
}
