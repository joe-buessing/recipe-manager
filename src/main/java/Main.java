package src.main.java;

public class Main {
  public static void main(String[] args) {
    IngredientSerialization ingredientSerialization = new IngredientSerialization();
    ingredientSerialization.save(new Ingredient("name", "description", 1.0, 1, 1, 1, 1));
  }
}
