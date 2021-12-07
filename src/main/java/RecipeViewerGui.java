package src.main.java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RecipeViewerGui
  extends JComponent
{
  private RecipeViewerController controller;

  public RecipeViewerGui(RecipeViewerController controller)
  {
    super();

    this.controller = controller;
    
    JLabel nameLabel = new JLabel();
    nameLabel.setBounds(0, 0, 200, 17);
    nameLabel.setText("RecipeViewer");
    this.add(nameLabel);

    JButton navigateToCreateRecipeButton = new JButton("NavigateToCreateRecipe");
    navigateToCreateRecipeButton.setBounds(0, 18, 200, 17);
    navigateToCreateRecipeButton.addActionListener(evt -> onNavigateToCreateRecipe(evt));
    this.add(navigateToCreateRecipeButton);
  }
  
  private void onNavigateToCreateRecipe(ActionEvent evt) {    
    controller.navigateToCreateRecipeCallback.onNav();
  }
}

