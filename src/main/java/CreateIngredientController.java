package src.main.java;

public class CreateIngredientController {
  private IngredientSerialization serialization;
  protected NavigateToCreateRecipeCallback navigateToCreateRecipeCallback;
  
  public void onNavigateToCreateRecipe(NavigateToCreateRecipeCallback navigateToCreateRecipeCallback) {
    this.navigateToCreateRecipeCallback = navigateToCreateRecipeCallback;
  }
}

