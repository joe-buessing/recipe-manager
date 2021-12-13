package src.main.java;

import java.io.File;
import java.util.Objects;

public class RecipeViewerController {

  private IngredientSerialization serialization;
  protected NavigateToCreateRecipeCallback navigateToCreateRecipeCallback;

  public void onNavigateToCreateRecipe(NavigateToCreateRecipeCallback navigateToCreateRecipeCallback) {
    this.navigateToCreateRecipeCallback = navigateToCreateRecipeCallback;
  }

  private final String path = new ConfigSerialization().load().getProperty("path");

  public String[] getAllRecipes() {
    File fRec = new File(path + "/recipe/");
    String[] strArr = new String[Objects.requireNonNull(fRec.listFiles()).length];
    File[] fArr = Objects.requireNonNull(fRec.listFiles());

    for (int i = 0; i < strArr.length; i++) {
      strArr[i] = fArr[i].getName().split("\\.")[0];
    }

    return strArr;
  }

  public Recipe getRecipe(String name) {
    return new RecipeSerialization().load(name, path);
  }
}
