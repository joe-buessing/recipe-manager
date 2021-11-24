package src.main.java;

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
        Properties p = new Properties();

        String path = System.getProperty("java.io.tmpdir") + "/recipe_manager/";

        write(p);
    }
}
