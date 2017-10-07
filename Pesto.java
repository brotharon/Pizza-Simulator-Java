/**
 * Class creates an instance of Ingredient/Base/Pesto. There is no user
 * input required. All information on the Pesto is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Pesto extends Base{

    public Pesto () throws PizzaException{
        super(80, 2.50, "Mama Rosa' Pesto Sauce");
    }
}
