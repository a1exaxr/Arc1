import java.util.Scanner;
import java.util.Random;

//HIII 10/08/2026 committttt
// Hello world
public class Main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        // Create starter recipes
        Recipe R1 = new Recipe("Banana Oat Muffins",
                "North American Influence", 10, 2, true);


        Recipe R2 = new Recipe("Lentil and Duck Salad",
                "French", 15, 2, false);


        Recipe R3 = new Recipe("Nourishing Detox Soup",
                "French", 15, 2, false);


        // Create the Cookbook
        Cookbook C1 = new Cookbook("Cookbook 1", R1);


        // Add starter recipes to the Cookbook
        C1.addRecipe(R1);
        C1.addRecipe(R2);
        C1.addRecipe(R3);


        boolean running = true;


        // Choose a random featured recipe
        Random random = new Random();
        int randomIndex = random.nextInt(C1.getRecipes().size());
        Recipe featuredRecipe = C1.getRecipes().get(randomIndex);


        System.out.println("Featured Recipe: " + featuredRecipe);
        System.out.println();




        while (running) {


            System.out.println("What would you like to do? (Input a number)");
            System.out.println("1 ~ Make a new recipe");
            System.out.println("2 ~ View recipes");
            System.out.println("3 ~ Search for an existing recipe");
            System.out.println("4 ~ Modify a recipe");
            System.out.println("5 ~ Remove a recipe");
            System.out.println("6 ~ Exit");


            int choice;


            // Menu input validation
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }


            choice = input.nextInt();
            input.nextLine();




            switch (choice) {






                case 1:


                    System.out.println("What do you want to call your recipe?: ");
                    String name = input.nextLine().trim();


                    System.out.println("What cuisine is it?: ");
                    String cuisine = input.nextLine().trim();


                    // Prep minutes
                    System.out.println("How many minutes of prep?: ");


                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next();
                    }


                    int prepMinutes = input.nextInt();




                    // Servings
                    System.out.println("How many servings?: ");


                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next();
                    }


                    int servings = input.nextInt();




                    // Vegetarian
                    System.out.println("Is your recipe vegetarian?: (true/false)");


                    while (!input.hasNextBoolean()) {
                        System.out.println("Invalid input. Please enter true or false.");
                        input.next();
                    }


                    boolean isVegetarian = input.nextBoolean();
                    input.nextLine();




                    // Check for duplicate recipe name
                    Recipe existingRecipe = C1.searchRecipe(name);


                    if (existingRecipe == null) {


                        Recipe newRecipe = new Recipe(
                                name,
                                cuisine,
                                prepMinutes,
                                servings,
                                isVegetarian
                        );


                        C1.addRecipe(newRecipe);


                        System.out.println("Recipe created!");


                    } else {


                        System.out.println(
                                "A recipe with this name already exists. Try again."
                        );
                    }


                    break;






                case 2:


                    if (C1.getRecipes().isEmpty()) {


                        System.out.println("You don't have any recipes yet.");
                        break;
                    }


                    System.out.println("Would you like to filter the recipes?");
                    System.out.println("1 ~ Vegetarian");
                    System.out.println("2 ~ Non-vegetarian");
                    System.out.println("3 ~ View all recipes");


                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter 1, 2, or 3.");
                        input.next();
                    }


                    int filterChoice = input.nextInt();
                    input.nextLine();




                    if (filterChoice == 1) {


                        var vegetarianRecipes = C1.filterVegetarian(true);


                        if (vegetarianRecipes.isEmpty()) {


                            System.out.println("No vegetarian recipes found.");


                        } else {


                            for (Recipe recipe : vegetarianRecipes) {
                                System.out.println(recipe);
                            }
                        }




                    } else if (filterChoice == 2) {


                        var nonVegetarianRecipes = C1.filterVegetarian(false);


                        if (nonVegetarianRecipes.isEmpty()) {


                            System.out.println("No non-vegetarian recipes found.");


                        } else {


                            for (Recipe recipe : nonVegetarianRecipes) {
                                System.out.println(recipe);
                            }
                        }




                    } else if (filterChoice == 3) {


                        for (Recipe recipe : C1.getRecipes()) {
                            System.out.println(recipe);
                        }




                    } else {


                        System.out.println(
                                "Invalid option. Please choose 1, 2, or 3."
                        );
                    }


                    break;






                case 3:


                    System.out.println("What recipe are you looking for?: ");


                    String search = input.nextLine().trim();


                    Recipe searchResult = C1.searchRecipe(search);


                    if (searchResult == null) {


                        System.out.println(
                                "Invalid input - Recipe not found."
                        );


                    } else {


                        System.out.println(searchResult);
                    }


                    break;






                case 4:


                    System.out.println("What recipe would you like to modify?: ");


                    String modifyName = input.nextLine().trim();


                    Recipe recipeToModify = C1.searchRecipe(modifyName);




                    if (recipeToModify == null) {


                        System.out.println("Recipe not found.");


                    } else {


                        System.out.println("What would you like to change?");
                        System.out.println("1 ~ Change servings");
                        System.out.println("2 ~ Scale recipe");


                        while (!input.hasNextInt()) {


                            System.out.println(
                                    "Invalid input. Please enter 1 or 2."
                            );


                            input.next();
                        }


                        int modifyChoice = input.nextInt();




                        if (modifyChoice == 1) {


                            System.out.println(
                                    "How many servings would you like?"
                            );


                            while (!input.hasNextInt()) {


                                System.out.println(
                                        "Invalid input. Please enter a number."
                                );


                                input.next();
                            }


                            int newServings = input.nextInt();


                            recipeToModify.setServings(newServings);


                            System.out.println("Servings updated!");
                            System.out.println(recipeToModify);




                        } else if (modifyChoice == 2) {


                            System.out.println(
                                    "How many servings would you like to scale the recipe to?"
                            );


                            while (!input.hasNextInt()) {


                                System.out.println(
                                        "Invalid input. Please enter a number."
                                );


                                input.next();
                            }


                            int newServings = input.nextInt();


                            recipeToModify.scaleTo(newServings);


                            System.out.println("Recipe scaled!");
                            System.out.println(recipeToModify);




                        } else {


                            System.out.println(
                                    "Invalid option. Please choose 1 or 2."
                            );
                        }
                    }


                    break;






                case 5:


                    System.out.println(
                            "What recipe would you like to remove?: "
                    );


                    String removeName = input.nextLine().trim();


                    if (C1.removeRecipe(removeName)) {


                        System.out.println("Recipe removed!");


                    } else {


                        System.out.println("Recipe not found.");
                    }


                    break;










                case 6:


                    running = false;


                    System.out.println("Goodbye!");


                    break;






                default:


                    System.out.println(
                            "Invalid option. Please choose 1, 2, 3, 4, 5, or 6."
                    );
            }
        }




        input.close();
    }
}

