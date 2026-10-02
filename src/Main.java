import java.util.Scanner;
import java.util.Random;


public class Main {
//TODO be able to filter the vegetarian recipes vs the non vegetarian recipes
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       // ArrayList<Recipe> Recipes = new ArrayList<>();

        Recipe R1 = new Recipe("Banana Oat Muffins", "North American Influence", 10, 2, true);
        Recipe R2 = new Recipe("Lentil and Duck Salad", "French", 15, 2, false);
        Recipe R3 = new Recipe("Nourishing Detox Soup", "French", 15, 2, false);

        Recipe.recipeCookBook.add(R1);
        Recipe.recipeCookBook.add(R2);
        Recipe.recipeCookBook.add(R3);
        boolean running = true;

        //this makes the program choose a random recipe from the recipe arrayList (random index from the list)
        Random random =  new Random();
        int randomIndex = random.nextInt(Recipe.recipeCookBook.size());
        Recipe featuredRecipe = Recipe.recipeCookBook.get(randomIndex);

        Cookbook C1 = new Cookbook("Cookbook 1", featuredRecipe );

        System.out.println(C1);

        while (running) {

            System.out.println("What would you like to do? (Input a number)");
            System.out.println("1 ~ Make a new recipe");
            System.out.println("2 ~ View recipes");
            System.out.println("3 ~ Search for an existing recipe");
            System.out.println("4 ~ Exit");

            int choice;

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

                    //prepMinutes
                    System.out.println("How many minutes of prep?: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next().trim();
                    }
                    int prepMinutes = input.nextInt();

                    //servings
                    System.out.println("How many servings?: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        input.next().trim();
                    }
                    int servings = input.nextInt();

                    //vegetarian?
                    System.out.println("Is your recipe vegetarian?: (true/false)");
                    while (!input.hasNextBoolean()) {
                        System.out.println("Invalid input. Please enter a true or false.");
                        input.next().trim();
                    }
                    boolean isVegetarian = input.nextBoolean();

                    //recipe making
                    Recipe existingRecipe = R1.searchRecipe(name);
                    if (existingRecipe == null){
                        Recipe newRecipe = new Recipe(name, cuisine, prepMinutes, servings, isVegetarian);

                        Recipe.recipeCookBook.add(newRecipe);
                        System.out.println("Recipe created!");
                    }else{
                        System.out.println("A recipe with this name already exists, try again: (Type 1) ");
                    }

                    //recipe made
                    break;

                case 2:
                    // View recipes
                    //TODO HERE

                    // TODO i want to make is so only when the user does this case, they are then prompted for an option to like seperate the recipes i nto if the are vegetarian or not
                   System.out.println("Would you like to filter the recipes?");
                    System.out.println("1 ~ Vegetarian");
                    System.out.println("2 ~ Non-vegetarian");
                    System.out.println("3 ~ View all recipes");
                    choice = input.nextInt();
                    if (choice == 1){



                        System.out.println();
                    }
                    if (choice == 2){



                        System.out.println();
                    }
                    if (choice == 3){


                        System.out.println();
                    }



                    if (Recipe.recipeCookBook.isEmpty()) {
                        System.out.println("You don't have any recipes yet.");
                    } else {
                        for (Recipe recipe : Recipe.recipeCookBook) {
                            System.out.println(recipe);
                        }
                    }


                    break;

                 case 3:
                     //search recipe by name
                System.out.println("What recipe are you looking for?: ");
                String search = input.nextLine().trim();

                Recipe searchResult = R1.searchRecipe(search);
                if (searchResult == null){
                    System.out.println("Invalid input - Recipe not found ~ Type 3 to search again ");

                }else {
                    System.out.println(searchResult);
                }

                break;

                case 4:
                //Exit

                running = false;
                System.out.println("Goodbye!");

                break;

                default:
                // TODO always check to make sure this print linhe is correct, (1, 2, 3, 4, ....)
                System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");

            }

        }

        input.close();

        }
    }
