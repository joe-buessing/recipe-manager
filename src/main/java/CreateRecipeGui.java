package src.main.java;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class CreateRecipeGui
  extends JComponent
{
  private CreateRecipeController controller;

  public CreateRecipeGui(CreateRecipeController controller)
  {
    super();
    
    this.controller = controller;
    
    JLabel nameLabel = new JLabel();
    nameLabel.setBounds(0, 0, 200, 17);
    nameLabel.setText("CreateRecipe");
    this.add(nameLabel);

    JButton navigateToCreateIngredientButton = new JButton("NavigateToCreateIngredient");
    navigateToCreateIngredientButton.setBounds(0, 18, 200, 17);
    navigateToCreateIngredientButton.addActionListener(evt -> onNavigateToCreateIngredient(evt));
    this.add(navigateToCreateIngredientButton);
    
    JButton navigateToRecipeViewerButton = new JButton("NavigateToRecipeViewer");
    navigateToRecipeViewerButton.setBounds(0, 36, 200, 17);
    navigateToRecipeViewerButton.addActionListener(evt -> onNavigateToRecipeViewer(evt));
    this.add(navigateToRecipeViewerButton);
  }
  
  private void onNavigateToCreateIngredient(ActionEvent evt) {
    controller.navigateToCreateIngredientCallback.onNav();
  }
  
  private void onNavigateToRecipeViewer(ActionEvent evt) {
    controller.navigateToRecipeViewerCallback.onNav();
  }
}

