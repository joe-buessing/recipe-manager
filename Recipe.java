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
}

