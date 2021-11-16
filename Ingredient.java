public class Ingredient {
    private String name;
    private String description;
    private double calorificValue;
    private int fat;
    private int carbohydrates;
    private int protein;
    private int salt;

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

    public void setName(String name) {
        this.name = name;
    }
}

