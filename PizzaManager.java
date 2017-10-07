
import java.util.Scanner;

/**
 * PizzaManager Skeleton File
 * CSS 162, Final Project
 * <p>
 * This class is a starting point for your final project and is incomplete.
 * Note that if there are any inconsistencies between this skeleton and
 * the assignment description, the assignment description controls.
 * <p>
 * Author: Rob Nash with edits by Johnny Lin
 *
 * @author modified extensively by Calvin Evans
 * @version 8/16/2017
 */
public class PizzaManager {

    List<Pizza> pizzas = new List<>();

    /**
     * The console interface is defined in the start method
     * You can exit or extend the code below to accomplish all of
     * the outcomes defined in the homework document
     */
    public void start() {

        // initial state of interface
        displayAllPizzas();
        displayInstructions();

        char selection = 0;//initialized for switch case
        while (selection != 'q' || selection != 'Q') { //Makes program
            // terminate with exit code 0 when q or Q is entered

            Scanner keyboard = new Scanner(System.in);

            String input = keyboard.next();

            selection = input.charAt(0);

            switch (selection) {
                case 'A':
                case 'a':
                    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                    addRandomPizza();
                    displayAllPizzas();
                    displayInstructions();
                    break;
                case 'H':
                case 'h':
                    for (int i = 0; i < 100; i++) {
                        addRandomPizza();
                    }
                    displayAllPizzas();
                    displayInstructions();
                    break;
                case 'E':
                case 'e':
                    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                    if (pizzas.isEmpty()) {
                        System.out.println("You have no pizzas to eat. Please" +
                                " make some pizzas then try again.");
                        displayAllPizzas();
                        displayInstructions();
                    } else {
                        eatSomePizza(keyboard);
                    }
                    break;
                case 'P':
                case 'p':
                    System.out.println("Sorting pizzas by (P)rice");
                    sortPopulator(sortByPrice());
                    displayAllPizzas();
                    displayInstructions();
                    break;
                case 'S':
                case 's':
                    System.out.println("Sorting pizzas by (S)ize");
                    sortPopulator(sortBySize());
                    displayAllPizzas();
                    displayInstructions();
                    break;
                case 'C':
                case 'c':
                    System.out.println("Sorting pizzas by (C)alories");
                    sortPopulator(sortByCalories());
                    displayAllPizzas();
                    displayInstructions();
                    break;
                case 'B':
                case 'b':
                    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                    if (keyboard.hasNextInt()) {
                        int calSearch = binarySearchByCalories(keyboard.nextInt());
                        if (calSearch >= 0) {
                            System.out.println("Your pizza was found at " +
                                    "index: " + calSearch);
                            break;
                        } else {
                            System.out.println("Your pizza was not found.");
                            break;
                        }

                    }
                    displayInstructions();
                case 'Q':
                case 'q':
                    System.out.println("(Q)uitting!");
                    System.exit(0);
                default:
                    System.out.println("Unrecognized input - try again");
            }
        }

    }


    /**
     * Attempts to eat a portion of the pizza stored at index location 0.
     *
     * @param keys takes in the Scanner to allow the user to input what
     *             percent of pizza they would like to eat.
     */
    private void eatSomePizza(Scanner keys) {
        String input = null;
        while (input == null) {
            input = keys.next();
        }
        String[] numDen = input.split("/");
        int numerator = Integer.parseInt(numDen[0]);
        int denominator = Integer.parseInt(numDen[1]);
        System.out.println("At what index? (Enter a whole number)");
        input = null;
        while (input == null) {
            input = keys.next();
        }
        int index = Integer.parseInt(input);
        if (index >= 0 && index < pizzas.size()) {
            Pizza eating = pizzas.getData(index);
            try {
                eating.eatSomePizza(new Fraction(numerator, denominator));
                System.out.println(pizzas.getData(index));
            } catch (PizzaGoneException e) {
                e.getMessage();
                pizzas.remove(index);
            } catch (PizzaException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Input was not accepted. Pick a pizza in the " +
                    "list");
        }

    }

    /**
     * Adds one randomly generated Pizza to the List<> pizzas.
     */
    private void addRandomPizza() {
        Pizza p = new Pizza();
        pizzas.append(p);
    }

    /**
     * Displays all of the Pizzas that are currently stored in the List pizzas.
     */
    private void displayAllPizzas() {
        System.out.print(pizzas);
    }

    /**
     * Helper method that takes a sorted Pizza array and converts it to a
     * List Object and overwrites pizzas.
     *
     * @param p a sorted Array of Pizzas
     */
    private void sortPopulator(Pizza[] p) {
        List<Pizza> done = new List<>();

        for (int i = 0; i < p.length; i++) {
            done.insert(p[i], i);
        }

        pizzas = done;
    }

    /**
     * Sorts the Pizzas stored in the List pizzas by price from highest to
     * lowest.
     *
     * @return sends the sorted Array to sortPopulator to be turned into a List
     */
    private Pizza[] sortByPrice() {
        Pizza[] sorted = new Pizza[pizzas.size()];
        for (int i = 0; i < pizzas.size(); i++) {
            sorted[i] = pizzas.getData(i);
        }

        for (int i = 1; i < sorted.length; i++) {
            int j = i - 1;
            Pizza temp = sorted[i];

            while (j >= 0 && temp.compareTo(sorted[j]) < 0) {
                sorted[j + 1] = sorted[j];
                j--;
                ;
            }

            sorted[j + 1] = temp;
        }
        return sorted;
    }

    /**
     * Sorts the Pizzas stored in the List pizzas by size from largest to
     * smallest.
     *
     * @return sends the sorted Array to sortPopulator to be turned into a List
     */
    private Pizza[] sortBySize() {
        Pizza[] sorted = new Pizza[pizzas.size()];
        Pizza min = null;

        for (int i = 0; i < sorted.length; i++) {
            min = pizzas.getData(0);
            for (int j = 0; j < sorted.length - i; j++) {
                if (pizzas.getData(j).remainingArea() < min.remainingArea()) {
                    min = pizzas.getData(j);
                }
            }
            pizzas.delete(pizzas.indexOf(min));
            sorted[i] = min;
        }
        return sorted;
    }

    /**
     * Sorts the Pizzas stored in the List pizzas by calorieCount from highest
     * to lowest.
     *
     * @return sends the sorted Array to sortPopulator to be turned into a List
     */
    private Pizza[] sortByCalories() {
        Pizza[] sorted = new Pizza[pizzas.size()];
        Pizza min = null;

        for (int i = 0; i < sorted.length; i++) {
            min = pizzas.getData(0);
            for (int j = 0; j < sorted.length - i; j++) {
                if (pizzas.getData(j).getCalories() < min.getCalories()) {
                    min = pizzas.getData(j);
                }
            }
            pizzas.delete(pizzas.indexOf(min));
            sorted[i] = min;
        }
        return sorted;
    }

    /**
     * /**
     * Sorts the Pizzas stored in the List pizzas by calorieCount from highest
     * to lowest. Outputs the sorted list of Pizzas. Searches the sorted list
     * for the calorie input. Returns the index if found or -1 if not found.
     *
     * @param cals an integer for the calorieCount of the Pizza to search for
     * @return an integer that is the index location that the Pizza with the
     * desired calorie count can be found in the List or -1 if not found.
     */
    private int binarySearchByCalories(int cals) {
        sortPopulator(sortByCalories());
        displayAllPizzas();
        Pizza[] search = sortByCalories();
        sortPopulator(search);
        return binarySearchByCalories(cals, 0, search);
    }

    /**
     * Helper method: Performs recursive search for the calorie target
     *
     * @param cals  the target
     * @param index the index to search
     * @param p     the sorted Array of Pizzas
     * @return an integer that is the index location that the Pizza with the
     * desired calorie count can be found in the List or -1 if not found.
     */
    private int binarySearchByCalories(int cals, int index, Pizza[] p) {
        if (p[index].getCalories() == cals) {
            return index;
        }
        if (p.length == index) {
            return -1;
        }
        return binarySearchByCalories(cals, index + 1, p);
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
