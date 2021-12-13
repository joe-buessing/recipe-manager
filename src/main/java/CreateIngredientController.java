package src.main.java;

public class CreateIngredientController {
  private final IngredientSerialization serialization = new IngredientSerialization();

  public void create(String name, String description, double calorificValue, int fat, int carbohydrates, int protein, int salt){
    serialization.save(new Ingredient(name, description, calorificValue, fat, carbohydrates, protein, salt));
  }



  protected NavigateToCreateRecipeCallback navigateToCreateRecipeCallback;
  
  public void onNavigateToCreateRecipe(NavigateToCreateRecipeCallback navigateToCreateRecipeCallback) {
    this.navigateToCreateRecipeCallback = navigateToCreateRecipeCallback;
  }
}

