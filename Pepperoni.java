/**
 * Class creates an instance of Ingredient/Meat/Pepperoni. There is no user
 * input required. All information on the Pepperoni is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Pepperoni extends Meat {

    public Pepperoni () throws PizzaException{
        super(100, 1.50, "Thick Cut, Dry Cured Pepperoni");
    }
}
