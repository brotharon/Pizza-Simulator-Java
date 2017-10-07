/**
 * Class creates an instance of Ingredient/Cheese/Mozzarella. There is no user
 * input required. All information on the Mozzarella is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Mozzarella extends Cheese {

    public Mozzarella () throws PizzaException{
        super(35, .75, "Imported Italian Mozzarella Cheese");
    }
}
