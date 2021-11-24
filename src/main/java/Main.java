package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final RecipeSerialization recSer = new RecipeSerialization();

  public static void main(String[] args) {

    // create / save

    List<Ingredient> ingL = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      ingL.add(new Ingredient("name" + i, "description" + i, i, i, i, i, i));
    }

    Recipe rec = new Recipe("name", "desc", "prep", ingL);

    recSer.save(rec);

    // load / create

    Recipe recLoad = recSer.load("name", System.getProperty("java.io.tmpdir") + "/recipe_manager/");

    System.out.println(recLoad.toString());
  }
}
