import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * This class stores a money object which is made up of one integer to
 * represent dollars and another to represent cents. The various methods
 * perform checks and conversions for you to allow for seamless use of this
 * class.
 *
 * @author Calvin Evans
 * @version 8/10/2017
 */
public class Money implements Comparable<Money>, Cloneable, Serializable {
    private int cent;
    private int dollar;
    DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Pre: dollar value only constructor, only takes in one integer as the
     * dollar value
     * Post: Initializes this instance of the dollar object with the input
     * value stored in dollar and 0 stored in cents.
     *
     * @param dol takes in a positive integer or 0 to be stored as the dollar
     *            value. A negative value cannot be stored and will return an
     *            error message.
     */
    public Money(int dol) {
        setDollar(dol);
    }

    /**
     * Pre: dollar and cents constructor, takes in two integers as the values
     * for dollars and cents.
     * Post: Makes all necessary conversions, initializes the Money object,
     * and stores the values for dollars and cents.
     *
     * @param dol  takes in a positive integer or 0 to be stored as the dollar
     *             value. A negative value cannot be stored and will return an
     *             error message.
     * @param cent takes in a positive integer or 0. If the value is 100 or
     *             larger it will be converted into dollars and cents and the
     *             dollars will be added to the dollar value with the
     *             remainder stored as cents. The cents container will not
     *             store more than 99 or less than 0 cents. If the number
     *             input is smaller than 0 an error message will be displayed.
     */
    public Money(int dol, int cent) {
        setDollar(dol);
        fixCent(cent);
    }

    /**
     * Pre: copy constructor, takes in another Money object.
     * Post: creates a duplicate of the money object that is passed in by
     * sending the dollars and cents from that object to the dollars and
     * cents constructor.
     *
     * @param other this is another instance of the Money object. Checks are
     *              made to ensure that this is a valid object and that its
     *              internal parameters meet all rules for this class.
     */
    public Money(Money other) {
        this(other.getDollar(), other.getCent());
    }

    /**
     * Pre: takes in an integer value for dollars
     * Post: Ensures that this value is greater than or equal to 0 and either
     * assigns it as the dollar variable or prints an error message.
     *
     * @param dol an integer that is of any value 0 or larger.
     */
    public void setDollar(int dol) {
        if (dol >= 0) {
            this.dollar = dol;
        } else {
            System.out.println("Cannot be set to less than 0 dollars");
        }
    }

    /**
     * Pre: takes in an integer value for cents
     * Post: Ensures that the value assigned to the cent variable is no less
     * than 0 and no greater than 99, makes adjustments to the dollar
     * variable to account for cents greater than 99 or less than 0, assigns
     * the final values to cent and dollar.
     *
     * @param cent any integer, but if cent is negative and totals more than
     *             the sum of the stored dollar value this will print an
     *             error message.
     */
    private void fixCent(int cent) {
        if (cent >= 0 && cent < 100) { //checking to see if cent is already
            // between 0 and 99 inclusive
            this.cent = cent;
        } else if (cent >= 100) { //rolls additional cents over to dollar for
            // cent values greater than 99
            this.cent = cent % 100;
            this.dollar += cent / 100;
        } else { //with cent values less than 0 check to see if there are
            // enough dollars to subtract from
            int tempDollar = dollarCheck(cent / 100);
            if (tempDollar < 0) { //if there are not enough dollars to
                // subtract from (total would be less than 0
                System.out.println("Cannot be set to less than 0 cents");
            } else { //if there are enough dollars to subtract the cent value
                this.dollar = tempDollar;
                this.cent = cent % 100;
            }
        }
    }

    /**
     * Setter: Sets the cent value between 0 and 99 from user input
     * @param cent a value to set the instance variable cent to. Must be
     *             between 0 and 99 or cent will not be changed.
     */
    public void setCent(int cent) {
        if (cent >= 0 && cent < 100) {
            this.cent = cent;
        }
    }

    /**
     * Pre: none
     * Post: none
     *
     * @param check this is an int passed in to see if the requested
     *              modification to the dollar variable is legal (ie. allows
     *              checking to see if the resulting dollar would be less
     *              than 0).
     * @return returns the total sum of the passed in int and the current
     * total stored in the dollar variable.
     */
    private int dollarCheck(int check) {
        int tempDollar = this.dollar;
        tempDollar += check;
        return tempDollar;
    }

    /**
     * Pre: takes in two variables one each for dollar and cent.
     * Post: This method calls setDollar and setCent as helper methods. See
     * their descriptions for all the specific guidelines for using this
     * method.
     *
     * @param dol  an integer that is of any value 0 or larger.
     * @param cent any integer, but if cent is negative and totals more than
     *             the sum of the stored dollar value this will print an
     *             error message.
     */
    public void setMoney(int dol, int cent) {
        setDollar(dol);
        setCent(cent);
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a copy of the int value stored in the dollar variable.
     */
    public int getDollar() {
        return dollar;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a copy of the int value stored in the cent variable.
     */
    public int getCent() {
        return cent;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a double which represents the combined value stored in
     * dollar and cent variables. This return value is not formatted so $1.50
     * will return as 1.5. If you need a formatted value please use the
     * .toString method.
     */
    public double getMoney() {
        double convertCent = .01 * cent;
        return dollar + convertCent;
    }

    /**
     * Pre: takes in an integer to be summed with the current dollar variable
     * Post: checks to ensure that that passed in value would not violate the
     * rule that dollar cannot be less than 0. If check is passed, assigns
     * sum to dollar. If check fails prints an error message.
     *
     * @param dol can take any int, will only print an error message if the
     *            value passed would make the int value stored in dollar be
     *            less than 0 once summed.
     */
    public void add(int dol) {
        int tempDollar = dollarCheck(dol);
        if (tempDollar >= 0) {
            this.dollar = tempDollar;
        } else {
            System.out.println("Result would be a negative value");
        }
    }

    /**
     * Pre: takes in two integers to be summed with the current dollar
     * variable and cent variable
     * Post: checks to ensure that that passed in value would not violate the
     * rule that dollar  and cent cannot be less than 0. Also ensures that
     * cent is not greater than 99. If all checks are passed, assigns the new
     * values to dollar and cent once all necessary conversions are made. If
     * checks fail this prints an error message.
     *
     * @param dol  can take any int, will only print an error message if the
     *             value passed would make the int value stored in dollar be
     *             less than 0 once summed.
     * @param cent can take in any int, will cause an error message if the
     *             resulting value would be negative.
     */
    public void add(int dol, int cent) {
        int tempDollar = this.dollar;
        int tempCent = this.cent;
        tempCent += cent;
        if (tempCent < 0) { //conversion required to subtract negative cent
            // values from cent and dollar as needed
            tempDollar = dollarCheck((tempCent / 100));
            tempCent = tempCent % 100;
            tempDollar -= 1;
            tempCent += 100;
        } else if (tempCent > 100) { //conversion required for cent values in
            // excess of 99
            tempDollar = dollarCheck(tempCent / 100);
            tempCent = tempCent % 100;
        }
        tempDollar += dol;
        if (tempDollar >= 0) {//once conversions are made this checks to
            // ensure that a legal value is present and either passes these
            // calculated values to the setter methods or prints an error
            setDollar(tempDollar);
            fixCent(tempCent);
        } else {
            System.out.println("Result would be a negative value");
        }
    }

    /**
     * Pre: takes in an instance of the Money class
     * Post: adds the values from the other Money class to this instance
     * using the .add dollar and cent method.
     *
     * @param other can be any valid instance of the Money class. Checks will
     *              be made to ensure that all parameters are legal.
     */
    public void add(Money other) {
        if (other != null) {
            add(other.getDollar(), other.getCent());
        }
    }

    /**
     * Pre: Takes any object.
     * Post: Returns a boolean which indicates if the passed in object was a
     * Money object and had the same values stored in all variables.
     *
     * @param obj an object which will be compared against the stored
     *            variables of this object
     * @return returns a boolean true if the other object is a Money object
     * and the variables match or false if the other object is not a Money
     * object or if any of the variables do not match.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Money) {
            if (this.getMoney() == ((Money) obj).getMoney()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Pre: none
     * Post: formats the variables stored in this instance of Money and
     * returns that as a String
     *
     * @return returns the dollar and cent stored in this instance of Money
     * in the format $##.##
     */
    @Override
    public String toString() {
        return "$" + df.format(this.getMoney());
    }

    /**
     * pre: takes in one parameter as a Money object. Do not attempt to call
     * this method if you have not instantiated the Money class you are
     * calling this on. It can handle having a null passed in, but if the
     * comparing class is null this will throw a null pointer exception.
     * post: compares the passed in parameter to this Object by multiplying
     * the dollar value by 100 and adding it to the cent value to produce an
     * int that is a composite of the two values. The composite value of the
     * passed in parameter is subtracted from the composite of this value and
     * the result is returned. If a null Object is passed in an Exception
     * will be thrown, message output to console, and -1 will be returned so
     * that a null will always be considered of lower value than an
     * instantiated Object.
     *
     * @param m a non-null Money object
     * @return an int. A  positive number if this is greater than m. A
     * negative number if m is greater than this. -1 if passed in Object is
     * null.
     */
    @Override
    public int compareTo(Money m) {
        int exceptionReturn = 0;
        try {
            if (m == null) {
                exceptionReturn = 1;
                throw new PizzaException("Cannot compare null Object");
            }
            return ((this.getDollar() * 100) + this.getCent()) - ((m
                    .getDollar() * 100) + m.getCent());
        } catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
        return exceptionReturn;
    }

    /**
     * pre: none
     * post: makes a deep copy of this Money Object and returns it to the
     * calling method. If this is null, will throw a null pointer exception
     * and exit.
     *
     * @return  a deep copy of the stored Money object.
     * @throws CloneNotSupportedException mandatory exception for this class.
     *                                    Clone is supported for Money, must
     *                                    be handled by calling method, but
     *                                    should not be thrown.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Money c = new Money(this.getDollar(), this.getCent());
        return c;
    }
}
