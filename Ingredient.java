/**
 * Abstract class. Creates a hierarchy for all pizza ingredients. Takes the
 * information from the child class and instantiates the variables that are
 * common to all pizza ingredients. This class cannot be instantiated. These
 * instance variables must be instantiated by the named ingredient 2 levels
 * further down in the hierarchy.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public abstract class Ingredient {

    public final int CALORIES;
    public final double COST;
    public final String DESCRIPTION;

    /**
     * Constructor: assigns final values to the instance variables.
     *
     * @param calories    an int for the number of calories per serving of this
     *                    type of ingredient
     * @param cost        double for the cost of this ingredient over an entire pizza
     * @param description a String with a description of the ingredient
     * @throws PizzaException
     */
    protected Ingredient(int calories, double cost, String description) throws
            PizzaException {
        if (calories > 0) {//Calories cannot be less than 0
            this.CALORIES = calories;
        } else {
            throw new PizzaException("Exception: Nothing has negative " +
                    "calories, not even celery. Try again!");
        }
        if (cost > 0) {//Cost cannot be less than 0
            this.COST = cost;
        } else {
            throw new PizzaException("Exception: We aren't giving pizzas away" +
                    ". Set ingredient cost to more than 0. Toppings cost " +
                    "money!");
        }
        if (description != null) {//Toppings must be described
            this.DESCRIPTION = description;
        } else {
            throw new PizzaException("Ingredients need a description. Try " +
                    "again!");
        }
    }

    /**
     * Overrides the toString method to put out a report of the description,
     * cost and calorie content of the ingredient.
     *
     * @return a String with all of the instance variable data of the ingredient
     */
    @Override
    public String toString() {
        return "Ingredient: " + DESCRIPTION + "\n Cost: " + COST + "\n " +
                "Calories: " + CALORIES;
    }

    /**
     * Overrides the equals method to compare the instance variables of this
     * ingredient to those of the input Object.
     *
     * @param obj an Object of any type. An Object that is not an Ingredient
     *            will return false.
     * @return boolean: true if the Object matches all instance variables of
     * this ingredient and is an Ingredient. False if any of these are not
     * true.
     */
    @Override
    public boolean equals(Object obj) {
        try {
            if (obj == null || !obj.getClass().isInstance(this.getClass())) {
                throw new PizzaException(obj.getClass().toString() + " is not a "
                        + this.getClass().toString());
            }
        } catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
        Ingredient check = (Ingredient) obj;
        if (check.CALORIES == this.CALORIES) {
            if (check.COST == this.COST) {
                if (check.DESCRIPTION.equals(this.DESCRIPTION)) {
                    return true;
                }
            }
        }
        return false;
    }
}
