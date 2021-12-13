package src.main.java;

import org.json.JSONObject;

public class IngredientSerialization {

    private final SerializationHelper seHel = new SerializationHelper();

    public Ingredient load(String name, String path) {
        return loadIngredient(path, name); // todo: check if name is valid (no illegal characters, etc.)
    }

    private Ingredient loadIngredient(String path, String name) {
        JSONObject obj = seHel.loader(path + "/ingredient/" + name + ".json");

        assert obj != null;
        return new Ingredient(obj.getString("name"), obj.getString("description"),
                obj.getDouble("calorificValue"), obj.getInt("fat"), obj.getInt("carbohydrates"),
                obj.getInt("protein"), obj.getInt("salt"));
    }

    private final String path = new ConfigSerialization().load().getProperty("path");

    public void save(Ingredient ingredient) {
        saveIngredient(ingredient, path + "/ingredient/"); // TODO: 24/11/2021 get path from config
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

        seHel.saving(path, obj);
    }
}
