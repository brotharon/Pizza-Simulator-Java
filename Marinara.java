/**
 * Class creates an instance of Ingredient/Base/Marinara. There is no user
 * input required. All information on the Marinara is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Marinara extends Base{

    public Marinara () throws PizzaException{
        super(80, 1.00, "Zesty Marinara Sauce");
    }
}
