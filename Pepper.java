/**
 * Class creates an instance of Ingredient/Vegitable/Pepper. There is no user
 * input required. All information on the Pepper is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Pepper extends Vegitable{

    public Pepper () throws PizzaException{
        super(24, 1.99, "Bright Green Bell Pepper");
    }
}
