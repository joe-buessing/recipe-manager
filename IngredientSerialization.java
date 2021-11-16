import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IngredientSerialization {
    private FileWriter file;

    //todo: may want to add a custom path

    public void save(Ingredient ingredient) {
        ingredient.setName(new SerializationHelper().makeNameLegal(ingredient.getName()));
        saveIngredient(ingredient, System.getProperty("java.io.tmpdir") + "/recipe_manager/ingredient/" + ingredient.getName() + ".json");
    }

    private void saveIngredient(Ingredient ingredient, String path) {
        JSONObject obj = new JSONObject();

        obj.put("name", ingredient.getName());
        obj.put("description", ingredient.getDescription());
        obj.put("calorificValue", ingredient.getCalorificValue());
        obj.put("fat", ingredient.getFat());
        obj.put("carbohydrates", ingredient.getCarbohydrates());
        obj.put("protein", ingredient.getProtein());
        obj.put("salt", ingredient.getSalt());

        try {
            file = new FileWriter(path);
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

    public Ingredient load(String name) {
        return loadIngredient(System.getProperty("java.io.tmpdir") + "/recipe_manager/ingredient/" + name + ".json"); // todo: check if name is valid (no illegal characters, etc.)
    }

    private Ingredient loadIngredient(String path) {
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

        assert obj != null;
        return new Ingredient(obj.getString("name"), obj.getString("description"),
                obj.getDouble("calorificValue"), obj.getInt("fat"), obj.getInt("carbohydrates"),
                obj.getInt("protein"), obj.getInt("salt"));
    }
}