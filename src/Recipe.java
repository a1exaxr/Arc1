



public class Recipe {


    // instances
    private String name;
    private String cuisine;
    private int prepMinutes;
    private int servings;
    private boolean isVegetarian;


    // constructor
    public Recipe(String name, String cuisine, int prepMinutes, int servings, boolean isVegetarian) {
        this.name = name;
        this.cuisine = cuisine;
        this.prepMinutes = prepMinutes;
        this.servings = servings;
        this.isVegetarian = isVegetarian;
    }


    // collection of recipes
    //moved to cookbook
    // public static ArrayList<Recipe> recipeCookBook = new ArrayList<>();


    // methods


    public void scaleTo(int newServings) {
        if (newServings >= 1) {
            servings = newServings;
        }
    }


    public void setServings(int amount) {
        if (amount >= 1) {
            servings = amount;
        }
    }


    // getter
    public String getName() {
        return name;
    }


    public boolean isVegetarian() {
        return isVegetarian;
    }


    // compares prep time with another Recipe
    public boolean isFasterThan(Recipe other) {
        return this.prepMinutes < other.prepMinutes;
    }




    // toString
    public String toString() {
        return "Recipe Name: " + name
                + ", Cuisine: " + cuisine
                + ", Prep Minutes: " + prepMinutes
                + ", Servings: " + servings
                + ", Vegetarian?: " + isVegetarian;
    }
}

