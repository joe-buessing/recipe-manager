package src.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigSerialization {
    public Properties load() {
        Properties p = new Properties();

        try {
            p.load(new FileReader(System.getProperty("java.io.tmpdir") + "/recipe_manager/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void write(Properties p) {
        try {
            p.store(new FileWriter(System.getProperty("java.io.tmpdir") + "/recipe_manager/config.properties"), "Config for recipe-manager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createOnFirstStart() {
        if (!new File(System.getProperty("java.io.tmpdir") + "/recipe_manager/config.properties").exists()) {
            Properties p = new Properties();

            // TODO: 29/11/2021 set first config
            p.setProperty("path", System.getProperty("java.io.tmpdir") + "/recipe_manager/");

            File directory = new File(System.getProperty("java.io.tmpdir") + "/recipe_manager/");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            write(p);
        }
    }
}
