package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class UtilProperties {

    public static Properties properties;

    static {
        properties = null;
        FileInputStream fileInputStream = null;
        String fileName = "";
        String filePath = System.getProperty("");

    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
