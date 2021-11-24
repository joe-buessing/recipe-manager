package src.main.java;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SerializationHelper {
    public JSONObject loader(String path){

        StringBuilder data = new StringBuilder();
        JSONObject obj = null;
        try {
            File myObj = new File(path);
            Scanner scanner = new Scanner(myObj);

            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
            }

            scanner.close();
            obj = new JSONObject(data.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  obj;
    }

    private FileWriter file;

    public void saving(String path, JSONObject obj){
        try {
            File directory = new File(path + "");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            file = new FileWriter(directory + "/" + obj.get("name").toString() + ".json");
            file.write(obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
