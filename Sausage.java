/**
 * Class creates an instance of Ingredient/Meat/Sausage. There is no user
 * input required. All information on the Alfredo is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Sausage extends Meat {

    public Sausage () throws PizzaException{
        super(229, 2.17, "100% Organic, Dry Italian Sausage");
    }
}
