package src.main.java;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipeSerialization {
    private final SerializationHelper seHel = new SerializationHelper();
    private final IngredientSerialization ingSer = new IngredientSerialization();

    public Recipe load(String name, String path) {
        return loadRecipe(path, name); // todo: check if name is valid (no illegal characters, etc.)
    }

    private Recipe loadRecipe(String path, String name) {

        JSONObject obj = seHel.loader(path + "recipe/" + name + ".json");

        List<Ingredient> ing = new ArrayList<>();

        IngredientSerialization ingSer = new IngredientSerialization();

        for (int i = 0; i < Objects.requireNonNull(obj).getJSONArray("ingredients").length(); i++) {
            Ingredient tempIngr = ingSer.load(obj.getJSONArray("ingredients").get(i).toString(), path);
            ing.add(new Ingredient(tempIngr.getName(), tempIngr.getDescription(), tempIngr.getCalorificValue(),
                    tempIngr.getFat(), tempIngr.getCarbohydrates(), tempIngr.getProtein(), tempIngr.getSalt()));
        }

        return new Recipe(obj.getString("name"), obj.getString("description"), obj.getString("preparation"), ing);
    }

    public void save(Recipe recipe) {
        String path = System.getProperty("java.io.tmpdir") + "/recipe_manager/recipe/";
        saveRecipe(recipe, path);
    }

    private void saveRecipe(Recipe recipe, String path) {
        JSONObject obj = new JSONObject();

        obj.put("name", recipe.getName());
        obj.put("description", recipe.getDescription());
        obj.put("preparation", recipe.getPreparation());


        JSONArray ingrArr = new JSONArray();

        for (Ingredient ingr : recipe.getIngredients()) {
            ingrArr.put(ingr.getName());
            ingSer.save(ingr);
        }

        obj.put("ingredients", ingrArr);

        seHel.saving(path, obj);
    }
}
