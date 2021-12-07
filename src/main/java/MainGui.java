package src.main.java;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainGui
  extends JFrame
{
  private JPanel pages;
  private Map<Config, JComponent> configToComponentLookup = new HashMap();

  public MainGui()
  {
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("MainGui");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    int headerHeight = 25;
    int contentHeight = frameHeight - headerHeight;
    
    JPanel borderLayout = new JPanel();
    borderLayout.setBounds(0, 0, frameWidth, frameHeight);
    borderLayout.setLayout(new java.awt.BorderLayout());

    JPanel headerPane = new JPanel();
    headerPane.setBounds(0, 0, frameWidth, frameHeight);
    JLabel headerLabel = new JLabel("Todo Title");
    headerLabel.setBounds(0, 0, 100, 17);
    headerPane.add(headerLabel);
    
    borderLayout.add(headerPane, BorderLayout.PAGE_START);

    Config initialConfig = new Config.RecipeViewer();
    JComponent initialComponent = getComponent(initialConfig, borderLayout, 0, headerHeight, frameWidth, contentHeight);
    initialComponent.setBounds(0, headerHeight, frameWidth, contentHeight);

    configToComponentLookup.put(initialConfig, initialComponent);

    if(initialComponent != null)
    {
      borderLayout.add(initialComponent, BorderLayout.CENTER);
    }
    
    cp.add(borderLayout);

    setVisible(true);
  }

  public static void main(String[] args)
  {
    new MainGui();
  }

  private JComponent getComponent(Config config, JPanel borderLayout, int x, int y, int width, int height)
  {
    if(config instanceof Config.RecipeViewer)
    {
      RecipeViewerController recipeViewer = new RecipeViewerController();
      recipeViewer.onNavigateToCreateRecipe(() -> navigateTo(new Config.CreateRecipe(), borderLayout, x, y, width, height));
      return new RecipeViewerGui(recipeViewer);
    }
    else if(config instanceof Config.CreateRecipe)
    {
      CreateRecipeController createRecipe = new CreateRecipeController();
      createRecipe.onNavigateToRecipeViewer(() -> navigateTo(new Config.RecipeViewer(), borderLayout, x, y, width, height));
      createRecipe.onNavigateToCreateIngredient(() -> navigateTo(new Config.CreateIngredient(), borderLayout, x, y, width, height));
      return new CreateRecipeGui(createRecipe);
    }
    else if(config instanceof Config.CreateIngredient)
    {
      CreateIngredientController createIngredient = new CreateIngredientController();
      createIngredient.onNavigateToCreateRecipe(() -> navigateTo(new Config.CreateRecipe(), borderLayout, x, y, width, height));
      return new CreateIngredientGui(createIngredient);
    }

    return null;
  }

  private void navigateTo(Config config, JPanel borderLayout, int x, int y, int width, int height)
  {
    JComponent nextComponent;
    if(configToComponentLookup.containsKey(config))
    {
      nextComponent = configToComponentLookup.get(config);
    }
    else
    {
      nextComponent = getComponent(config, borderLayout, x, y, width, height);
      configToComponentLookup.put(config, nextComponent);
    }
    
    if(nextComponent != null)
    {
      nextComponent.setBounds(x, y, width, height);
      borderLayout.remove(borderLayout.getComponentAt(x, y + 1));
      borderLayout.add(nextComponent, BorderLayout.CENTER);
      borderLayout.validate();
    }
  }

  interface Config
  {
    String getName();

    class RecipeViewer
      implements Config
    {
      @Override
      public String getName()
      {
        return "RecipeViewer";
      }
    }

    class CreateRecipe
      implements Config
    {
      @Override
      public String getName()
      {
        return "CreateRecipe";
      }
    }

    class CreateIngredient
      implements Config
    {
      @Override
      public String getName()
      {
        return "CreateIngredient";
      }
    }
  }
}

