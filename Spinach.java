import java.awt.*;

/**
 * Class creates an instance of Ingredient/Vegetable/Spinach. There is no user
 * input required. All information on the Spinach is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Spinach extends Vegitable{

    public Spinach () throws PizzaException{
        super(15, .50, "Large Leaf Green Spinach", Color.green);
    }
}
