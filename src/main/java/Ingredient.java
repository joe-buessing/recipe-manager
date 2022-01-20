package src.main.java;

public class Ingredient {
    private String name;
    private final String description;
    private final double calorificValue;
    private final int fat;
    private final int carbohydrates;
    private final int protein;
    private final int salt;

    public Ingredient(String name, String description, double calorificValue, int fat, int carbohydrates, int protein, int salt) {
        this.name = name;
        this.description = description;
        this.calorificValue = calorificValue;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public double getCalorificValue() {
        return calorificValue;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getProtein() {
        return protein;
    }

    public int getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calorificValue=" + calorificValue +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", protein=" + protein +
                ", salt=" + salt +
                '}';
    }
}

