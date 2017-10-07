/**
 * Class creates an instance of Ingredient/Cheese/Ricotta. There is no user
 * input required. All information on the Ricotta is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Ricotta extends Cheese{

    public Ricotta () throws PizzaException{
        super(106, 2.50, "Whole Milk Ricotta Cheese");
    }
}
