import java.util.ArrayList;


public class Cookbook {


    private String title;
    private Recipe featured;


    // Cookbook owns the collection
    private ArrayList<Recipe> recipeCookBook = new ArrayList<>();


    // constructor
    public Cookbook(String title, Recipe featured) {
        this.title = title;
        this.featured = featured;
    }


    // add method
    public void addRecipe(Recipe recipe) {
        recipeCookBook.add(recipe);
    }


    // get all recipes
    public ArrayList<Recipe> getRecipes() {
        return recipeCookBook;
    }


    // show featured recipe
    public Recipe showFeatured() {
        return featured;
    }


    // search method
    public Recipe searchRecipe(String search) {
        for (Recipe recipe : recipeCookBook) {
            if (search.equalsIgnoreCase(recipe.getName())) {
                return recipe;
            }
        }


        return null;
    }


    public ArrayList<Recipe> filterVegetarian(boolean vegetarian) {
        ArrayList<Recipe> filteredRecipes = new ArrayList<>();


        for (Recipe recipe : recipeCookBook) {
            if (recipe.isVegetarian() == vegetarian) {
                filteredRecipes.add(recipe);
            }
        }


        return filteredRecipes;
    }


    // remove method
    public boolean removeRecipe(String search) {
        Recipe recipe = searchRecipe(search);


        if (recipe != null) {
            recipeCookBook.remove(recipe);
            return true;
        }


        return false;
    }


    public String toString() {
        return "Title: " + title + ", featured: " + featured;
    }
}

