/**
 * Class creates an instance of Ingredient/Base/Alfredo. There is no user
 * input required. All information on the Alfredo is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Alfredo extends Base {

    public Alfredo () throws PizzaException{
        super(50, 1.50, "Creamy Alfredo Sauce");
    }
}
