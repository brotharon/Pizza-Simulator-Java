/**
 * Abstract class. Creates a hierarchy for Cheeses. Takes the
 * information from the child class and passes it to the super of this
 * abstract class. This class cannot be instantiated and only serves to
 * create an organizational structure.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public abstract class Cheese extends Ingredient{

    protected Cheese(int calories, double cost, String description) throws
            PizzaException {
        super(calories, cost, description);
    }
}
