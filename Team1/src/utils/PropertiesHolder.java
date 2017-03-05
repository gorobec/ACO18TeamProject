package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by v21k on 05.03.17.
 */
public class PropertiesHolder {
    public static Properties props;

    static {
        props = new Properties();
        try {
            props.load(new InputStreamReader(new FileInputStream("Team1/resources/app.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return props.getProperty(key);
    }
}
