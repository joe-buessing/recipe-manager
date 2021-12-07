package src.main.java;

public class CreateRecipeController
{
  private IngredientSerialization serialization;
  protected NavigateToCreateIngredientCallback navigateToCreateIngredientCallback;
  protected NavigateToRecipeViewerCallback navigateToRecipeViewerCallback;

  public void onNavigateToCreateIngredient(NavigateToCreateIngredientCallback navigateToCreateIngredientCallback)
  {
    this.navigateToCreateIngredientCallback = navigateToCreateIngredientCallback;
  }

  public void onNavigateToRecipeViewer(NavigateToRecipeViewerCallback navigateToRecipeViewerCallback)
  {
    this.navigateToRecipeViewerCallback = navigateToRecipeViewerCallback;
  }
}

