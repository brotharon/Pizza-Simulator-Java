import java.awt.Color;

/**
 * Abstract class. Creates a hierarchy for Vegitables. Takes the
 * information from the child class and passes it to the super of this
 * abstract class. This class cannot be instantiated and only serves to
 * create an organizational structure.
 * <p>
 * Vegitables also contain a Color instance variable which is captured at
 * this level.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public abstract class Vegitable extends Ingredient {

    private Color VEG_COLOR;

    /**
     * Basic constructor which passes along all data from the child to the
     * super and sets the Color instance variable to green.
     *
     * @param calories    an int for the calories per serving of the ingredient
     * @param cost        a double for the cost of the ingredient per pizza
     * @param description a String description of the ingredient
     * @throws PizzaException must be handled by calling method. In place to
     *                        prevent accidental instantiation with null input
     */
    protected Vegitable(int calories, double cost, String description) throws
            PizzaException {
        super(calories, cost, description);

        this.VEG_COLOR = Color.green;
    }

    /**
     * Basic constructor which passes along all data from the child to the
     * super and sets the Color instance variable to green.
     *
     * @param calories    an int for the calories per serving of the ingredient
     * @param cost        a double for the cost of the ingredient per pizza
     * @param description a String description of the ingredient
     * @param c           a Color from java.awt.color for the color of the
     *                    veggie
     * @throws PizzaException must be handled by calling method. In place to
     *                        prevent accidental instantiation with null input
     */
    protected Vegitable(int calories, double cost, String description, Color c)
            throws PizzaException {
        super(calories, cost, description);

        setVEG_COLOR(c);
    }

    /**
     * Getter: returns the Color stored in this Vegetable to the calling method.
     *
     * @return a deep copy of the stored Color Object.
     */
    protected Color getVEG_COLOR() {
        int RGB = VEG_COLOR.getRGB();

        Color output = new Color(RGB);
        return output;
    }

    /**
     * Setter: Takes in a Color Object and stores it in the local instance
     * variable if the Color is not found to be null
     *
     * @param c a non-null Color Object
     * @throws PizzaException Must be handled by calling method. Prevents
     *                        changing stored Color to a null value
     */
    protected void setVEG_COLOR(Color c) throws PizzaException {
        if (c != null) {
            this.VEG_COLOR = c;
        } else {
            throw new PizzaException("Vegitable needs a color. If you do not " +
                    "have a color in mind you can invoke the constructor that" +
                    " does not take in a color.");
        }
    }

    /**
     * Override equals method to require the target Object to also match the
     * Color of this Vegetable as well as all other params from the super.
     *
     * @param obj an Object of any type. An Object that is not an Ingredient
     *            will return false.
     * @return boolean: true if all instance variables match and the Object
     * passed in is a Vegetable. False if any of these are false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }

        Vegitable compare = (Vegitable) obj;

        if (compare.getVEG_COLOR().getRGB() != this.VEG_COLOR.getRGB()) {
            return false;
        }
        return super.equals(compare);
    }

    /**
     * Overrides the parent toString method to include the Color instance
     * variable with the other instance variables.
     * @return the parent toString + the Color of the Vegetable
     */
    @Override
    public String toString() {
        return super.toString() + "\n Color: " + this.getVEG_COLOR().toString();
    }
}
