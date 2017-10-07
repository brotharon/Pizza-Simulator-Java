/**
 * Lets the interface know when the Pizza is gone
 *
 * @author Calvin Evans
 * @version 8/16/2017
 */
public class PizzaGoneException extends Exception {

    public PizzaGoneException(){
        super();
    }

    public PizzaGoneException(String message){
        super(message);
    }
}
