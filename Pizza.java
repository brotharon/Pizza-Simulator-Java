import java.text.DecimalFormat;

/**
 * Pizza Class:
 * Handles all of the instance variables related to each individual pizza. Is
 * set up with a no argument constructor that makes random pizzas to make
 * testing of the class easier on the user.
 *
 * @author Calvin Evans
 * @version 8/16/2017
 */
public class Pizza implements Comparable<Pizza> {

    private List<Ingredient> ingredients;
    private int calorieCount;
    private Money cost;
    private Shape shape;
    private Fraction pizzaLeft;
    private DecimalFormat df = new DecimalFormat("0.00");

    /**
     * no-arg Constructor: Takes in no argument and makes a completely random
     * pizza. All randomizable instance variables have been randomized.
     * pizzaLeft (Fraction of pizza that exists) is set to 1/1 or 100%.
     */
    public Pizza() {
        ingredients = new List<>();
        calorieCount = 0;
        cost = new Money(0);
        pizzaLeft = new Fraction();
        pizzaMaker();
    }

    /**
     * Constructor: Takes a List of Ingredients and adds them to pizza. Sets
     * shape instance variable. Adding Ingredients automatically sets
     * calorieCount and Cost. pizzaLeft is set to 1/1 or 100%.
     *
     * @param shape
     * @param ingredients
     * @throws PizzaException
     */
    public Pizza(Shape shape, List<Ingredient> ingredients) throws
            PizzaException, CloneNotSupportedException {
        if (shape == null || ingredients == null) {
            throw new PizzaException();
        } else {
            for (int i = 0; i < ingredients.size(); i++) {
                this.addIngredient(ingredients.getData(i));
            }
            this.ingredients = ingredients;
            if (shape.getClass().getName().equals("Circle") || shape.getClass()
                    .getName().equals("Square")) {
                this.shape = (Shape) shape.clone();
            } else {
                this.shape = new Circle(100, 100, 12);
            }
            pizzaLeft = new Fraction();
        }
    }

    /**
     * Getter: Gets the fractional amount of this pizza that remains to be
     * eaten.
     *
     * @return a Fraction object that is the amount of this Pizza that has
     * yet to be eaten.
     */
    public Fraction getRemaining() {
        try {
            return (Fraction) pizzaLeft.clone();
        } catch (CloneNotSupportedException e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Setter: Allows you to take a bite and put the gross, chewed on Pizza
     * slice back, or you can take more Pizza away if you want. If you try to
     * set the value to less than 0 or greater than 1 (below 0% or above
     * 100%) nothing will be changed.
     *
     * @param pizzaLeft a Fraction object that you want to set this Pizza's
     *                  remaining amount to
     * @throws PizzaGoneException throws PizzaException if the pizza
     *                            remaining is at 0. This should be used to
     *                            trigger removal of this pizza from the
     *                            inventory List.
     */
    protected void setRemaining(Fraction pizzaLeft) throws PizzaGoneException {
        if (pizzaLeft.getNumerator() / pizzaLeft.getDenominator() > 0 &&
                pizzaLeft.getNumerator() / pizzaLeft.getDenominator() <= 1) {
            this.pizzaLeft = pizzaLeft;
        }

        if ((double) this.pizzaLeft.getNumerator() / this.pizzaLeft
                .getDenominator() == 0) {
            throw new PizzaGoneException();
        }
        this.pizzaLeft = pizzaLeft;
    }

    /**
     * Getter: Gets the calories per serving of this Pizza.
     *
     * @return an int for the calories per serving of this Pizza.
     */
    protected int getCalories() {
        return calorieCount;
    }

    /**
     * Pizza Maker: Makes random pizzas. Requires no user input.
     */
    private void pizzaMaker() {
        pizzaShaper();
        pizzaSaucer();
        pizzaCheeser();
        pizzaTopper();
    }

    /**
     * Pizza Shaper: Helper method for Pizza Maker. Randomly chooses the
     * shape for the pizza between circle and square.
     */
    private void pizzaShaper() {
        int shapeRand = (int) (Math.random() * 100);
        if (shapeRand < 50) {
            shape = new Square(shapeRand, shapeRand, (shapeRand / 10) + 10);
        } else {
            shape = new Circle(shapeRand, shapeRand, (shapeRand / 10) + 10);
        }
    }

    /**
     * Pizza Saucer: Helper method for Pizza Maker. Randomly chooses the
     * sauce for the pizza between alfredo, marinara, and pesto.
     */
    private void pizzaSaucer() {
        int sauceRand = (int) (Math.random() * 3 + 1);
        try {
            switch (sauceRand) {
                case 1:
                    addIngredient(new Alfredo());
                    break;
                case 2:
                    addIngredient(new Marinara());
                    break;
                case 3:
                    addIngredient(new Pesto());
                    break;
                default:
                    addIngredient(new Marinara());
                    break;
            }
        } catch (PizzaException e) {
            e.getMessage();
        }
    }

    /**
     * Pizza Cheeser: Helper method for Pizza Maker. Randomly chooses the
     * cheese for the pizza between cheddar, mozzarella, and ricotta.
     */
    private void pizzaCheeser() {
        int cheeseRand = (int) (Math.random() * 3 + 1);
        try {
            switch (cheeseRand) {
                case 1:
                    addIngredient(new Cheddar());
                    break;
                case 2:
                    addIngredient(new Mozzarella());
                    break;
                case 3:
                    addIngredient(new Ricotta());
                    break;
                default:
                    addIngredient(new Mozzarella());
                    break;
            }
        } catch (PizzaException e) {
            e.getMessage();
        }
    }

    /**
     * Helper method for Pizza Maker. Randomly chooses the
     * meats and veggies for the pizza between bacon, olive, pepper,
     * pepperoni, sausage, and spinach.
     */
    private void pizzaTopper() {
        int numToppings = (int) (10 * Math.random() + 1);
        try {
            for (int i = 0; i < numToppings; i++) {
                int toppingRand = (int) Math.random() * 6 + 1;
                switch (toppingRand) {
                    case 1:
                        addIngredient(new Bacon());
                        break;
                    case 2:
                        addIngredient(new Olive());
                        break;
                    case 3:
                        addIngredient(new Pepper());
                        break;
                    case 4:
                        addIngredient(new Pepperoni());
                        break;
                    case 5:
                        addIngredient(new Sausage());
                        break;
                    case 6:
                        addIngredient(new Spinach());
                        break;
                    default:
                        addIngredient(new Pepperoni());
                        break;
                }
            }
        } catch (PizzaException e) {
            e.getMessage();
        }
    }

    /**
     * Getter: gets the total cost of this Pizza.
     *
     * @return a deep copy Money Object that contains the financial data
     * associated
     * with this Pizza
     */
    protected Money getCost() {
        try {
            return (Money) cost.clone();
        } catch (CloneNotSupportedException e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Getter: gets the area of this Pizza that is still in existence
     *
     * @return a double that is the area of the shape multiplied by the
     * Fraction value for this Pizza.
     */
    protected double remainingArea() {
        return shape.getArea() * ((double) pizzaLeft.getNumerator() / pizzaLeft
                .getDenominator());
    }

    /**
     * Setter: Attempts to set this.shape to the input Shape. Only works if
     * the input is a Shape and the Shape is a Circle or Square. If any of
     * these conditions are not met the stored instance variable will not be
     * altered.
     *
     * @param s a non-null Shape of type Square or Circle
     */
    public void setShape(Shape s) {
        try {
            if (s != null && (s.getClass().getName().equals("Circle") || s
                    .getClass().getName().equals("Square"))) {
                this.shape = (Shape) s.clone();
            }
        } catch (CloneNotSupportedException e) {
            e.getMessage();
        }
    }

    /**
     * Getter: gets this Pizza's shape instance variable.
     *
     * @return returns a deep copy of this Pizza's shape instance variable.
     */
    public Shape getShape() {
        try {
            return (Shape) shape.clone();
        } catch (CloneNotSupportedException e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Adds the input Ingredient to the List of ingredients as well as
     * modifies the calorieCount and the cost of this Pizza. If the
     * Ingredient is null it will not be added and nothing will be changed.
     *
     * @param a a non-null Ingredient Object
     */
    protected void addIngredient(Ingredient a) {
        if (a != null) {
            this.ingredients.insert(a, 0);
            this.calorieCount += a.CALORIES;
            this.cost.add(0, (int) (a.COST * 100));
        }
    }

    /**
     * Attempts to remove a portion of this Pizza as input by the user. If
     * the amount reduces this Pizza to 0 an Exception is thrown to let the
     * user know to remove this Pizza from the inventory. If the input
     * Fraction would reduce the pizza remaining to less than 0, an Exception
     * is thrown and the amount of pizza left is not changed.
     *
     * @param amount a non-null Fraction Object
     * @throws PizzaException     thrown if the Fraction amount is greater than
     *                            the Fraction pizzaLeft
     * @throws PizzaGoneException thrown if this Pizza has been completely
     *                            consumed.
     */
    protected void eatSomePizza(Fraction amount) throws PizzaException, PizzaGoneException {
        double pizzaAvailable = (double) this.getRemaining().getNumerator
                () / this.getRemaining().getDenominator();
        double pizzaToEat = (double) amount.getNumerator() / amount
                .getDenominator();
        if (amount != null) {
            if (pizzaToEat > pizzaAvailable) {
                throw new PizzaException("You cannot eat more pizza than what is " +
                        "left");
            } else if (pizzaToEat == pizzaAvailable) {
                pizzaLeft.setNumerator(0);
                throw new PizzaGoneException("You have eaten all of this pizza. " +
                        "Remove it from the inventory.");
            }
            int newNumerator = (int) ((pizzaAvailable - pizzaToEat) * 100);

            this.setRemaining(new Fraction(newNumerator, 100));
        }
    }

    /**
     * Overrides the toString method to output as a String the instance
     * variables stored in this Pizza Object.
     *
     * @return a String containing the data from the instance variables of
     * this Pizza: cost, calorieCount, pizzaLeft, remainingArea, and shape
     */
    @Override
    public String toString() {
        return "Pizza has a price: " + this.cost + " and calories: " +
                calorieCount + ", Fraction remaining: " + pizzaLeft + " and " +
                "area remaining: " + df.format(remainingArea()) + " and " +
                "shape: " + this.shape.getClass().getName() + '\n';
    }

    /**
     * Compares this Pizza to an input Pizza (p).
     *
     * @param p a non-null instance of a Pizza.
     * @return a positive int if this Pizza costs more than p. A negative int
     * if this Pizza costs less than p. 0 if this Pizza and p cost the same
     * amount.
     */
    @Override
    public int compareTo(Pizza p) {
        if (p != null) {
            return this.cost.compareTo(p.getCost());
        }
        return 1;
    }
}
