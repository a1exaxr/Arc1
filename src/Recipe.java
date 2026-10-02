import java.util.ArrayList;

public class Recipe {
    //instances
    private String name;
    private String cuisine;
    private int prepMinutes;
    private int servings;
    private boolean isVegetarian;


    //constructors
    public Recipe(String name, String cuisine, int prepMinutes, int servings, boolean isVegetarian){
        //this.wtv
        this.name = name;
        this.cuisine = cuisine;
        this.prepMinutes = prepMinutes;
        this.servings = servings;
        this.isVegetarian = isVegetarian;

    }
    public static ArrayList<Recipe> recipeCookBook = new ArrayList<>();
    //methods
    public void scaleTo(int newServings){
        //adjust sevings count
    }

    public void setServings(int amount){
        //update servings, but never below 1
    }

    //getters setters
    //getter
    public String getName(){
    return name;
    }



    //search method
    public Recipe searchRecipe(String search) {
        for (Recipe recipe : Recipe.recipeCookBook) {
            if (search.equalsIgnoreCase(recipe.getName())) {
                return recipe;
            }

        }
        return null;
    }

    public String toString(){
        return "Recipe Name: " + name + ", Cuisine: " + cuisine + ", Prep Minutes: " + prepMinutes + ", Servings: " + servings + ", Vegetarian?: " + isVegetarian;
    }
}
