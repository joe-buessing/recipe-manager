package src.main.java;

import java.util.List;

public class Recipe {
    private String name;
    private String description;
    private String preparation;
    private List<Ingredient> ingredients;

    public Recipe(String name, String description, String preparation, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.preparation = preparation;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPreparation() {
        return preparation;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            str.append("\t- ").append(ingredient.toString()).append("\n");
        }
        return "Recipe{\n" +
                "- name='" + name + "'\n" +
                "- description='" + description + "'\n" +
                "- preparation='" + preparation + "'\n" +
                "- ingredients:\n" + str +
                '}';
    }
}

