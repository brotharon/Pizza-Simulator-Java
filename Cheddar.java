/**
 * Class creates an instance of Ingredient/Cheese/Cheddar. There is no user
 * input required. All information on the Cheddar is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Cheddar extends Cheese{

    public Cheddar () throws PizzaException{
        super(114, 2.22, "Real Wisconsin Cheddar Cheese");
    }
}
