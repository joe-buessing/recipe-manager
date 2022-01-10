package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class propertiesTest {
    public static void main(String[] args) {

    }

    public Properties load(String path) {
        Properties p = new Properties();
        FileReader f = null;

        try {
            f = new FileReader(path);
            p.load(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p;
    }

    public void write(Properties p) {
        try {
            p.store(new FileWriter(System.getProperty("java.io.tmpdir") + "/recipe_manager/" + "test.properties"), "Config for recipe-manager");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createOnSetup(){
        // TODO: 23/11/2021: create properties on first setup
        // TODO: 23/11/2021: discuss what properties we need
    }
}
