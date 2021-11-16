import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RecipeSerialization {
    private FileWriter file;

    public Recipe load(String name) {
        return loadRecipe(System.getProperty("java.io.tmpdir") + "/recipe_manager/recipe/" + name + ".json"); // todo: check if name is valid (no illegal characters, etc.)
    }

    private Recipe loadRecipe(String path) {
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

        List<Ingredient> ing = new ArrayList<>();

        IngredientSerialization ingSer = new IngredientSerialization();

        for (int i = 0; i < Objects.requireNonNull(obj).getJSONArray("ingredients").length(); i++) {
            Ingredient tempIngr = ingSer.load(obj.getJSONArray("ingredients").get(i).toString());
            ing.add(new Ingredient(tempIngr.getName(), tempIngr.getDescription(), tempIngr.getCalorificValue(),
                    tempIngr.getFat(), tempIngr.getCarbohydrates(), tempIngr.getProtein(), tempIngr.getSalt()));
        }

        return new Recipe(obj.getString("name"), obj.getString("description"), obj.getString("preparation"), ing);
    }

    public void save(Recipe recipe) {
        recipe.setName(new SerializationHelper().makeNameLegal(recipe.getName()));
        saveRecipe(recipe, System.getProperty("java.io.tmpdir") + "/recipe_manager/recipe/" + recipe.getName() + ".json");
    }

    private void saveRecipe(Recipe recipe, String path) {
        JSONObject obj = new JSONObject();

        obj.put("name", recipe.getName());
        obj.put("description", recipe.getDescription());
        obj.put("preparation", recipe.getPreparation());


        JSONArray ingrArr = new JSONArray();

        for (Ingredient ingr : recipe.getIngredients()) {
            ingrArr.put(ingr.getName());
        }

        obj.put("ingredients", ingrArr);

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
}
