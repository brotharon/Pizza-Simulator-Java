import java.awt.*;

/**
 * Class creates an instance of Ingredient/Vegetable/Olive. There is no user
 * input required. All information on the Olive is stored in the
 * constructor and passed to the super.
 *
 * @author Calvin Evans
 * @version 08/16/2017
 */
public class Olive extends Vegitable {

    public Olive () throws PizzaException{
        super(40, .38, "Moroccan Black Olive", Color.black);
    }
}
