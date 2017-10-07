/**
 * Class creates an instance of Ingredient/Meat/Bacon. There is no user
 * input required. All information on the Bacon is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Bacon extends Meat{

    public Bacon () throws PizzaException{
        super(88, 2.00, "Applewood Smoked Bacon");
    }
}
