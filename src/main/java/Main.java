package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        new ConfigSerialization().createOnFirstStart();

        final RecipeSerialization recSer = new RecipeSerialization();

        for (int i = 0; i < 10; i++) {
            ArrayList<Ingredient> a = new ArrayList<>();
            a.add(new Ingredient("name" + i + 0, "desc" + i + 0, i, i, i, i, i));
            a.add(new Ingredient("name" + i + 1, "desc" + i + 1, i + 1, i + 1, i + 1, i + 1, i + 1));
            a.add(new Ingredient("name" + i + 2, "desc" + i + 2, i + 2, i + 2, i + 2, i + 2, i + 2));
            a.add(new Ingredient("name" + i + 3, "desc" + i + 3, i + 3, i + 3, i + 3, i + 3, i + 3));
            recSer.save(new Recipe("name" + i, "desc" + 1, "prep" + 1, a));
        }

        RecipeViewerController rec = new RecipeViewerController();

        String[] strArr = rec.getAllRecipes();

        System.out.println(Arrays.toString(strArr));

        for (String s : strArr) {
            System.out.println(rec.getRecipe(s).toString());
        }
    }
}
