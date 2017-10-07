/**
 * PizzaException class extends the basic Exception to do exception handling
 * for exceptions specific to the management of pizzas.
 *
 * @author Calvin Evans
 * @version 8/16/2017
 */
public class PizzaException extends Exception{

    public PizzaException(){
        super();
    }

    public PizzaException(String message){
        super(message);
    }
}
