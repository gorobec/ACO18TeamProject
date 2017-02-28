package com.bestBuy.model;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by fmandryka on 27.02.2017.
 */
public class Configuration extends Properties{

    private static Properties config;

    private Configuration() {
    }

    public static Properties getConfig() throws IOException {
        if (Configuration.config == null) {
            config = new Properties();
            FileInputStream fi = new FileInputStream("BestBuy/resources/config.properties");
            config.load(fi);
        }
        return config;
    }
}
