/**
 * Creates a square shaped pizza crust to be the foundation of the pizza.
 *
 * @author Calvin Evans
 * @version 8/16/2017
 */
public class Square extends Shape {
    private int sideLength;

    /**
     * Constructor: passes x and y coords to super and instantiates all of
     * the local instance variables.
     *
     * @param x          the x coord on a 2d plane
     * @param y          the y coord on a 2d plane
     * @param sideLength an int for the length of one side of the crust
     */
    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    /**
     * Getter: Gets the instance variable sideLength
     *
     * @return an int copy of the stored sideLength instance variable
     */
    public int getSide() {
        return this.sideLength;
    }

    /**
     * Setter: Allows the user to change the stored sideLength instance variable
     *
     * @param sideLength an int between 10 and 20 (these are the sizes of the
     *                   pizzas that we make at the restaurant)
     */
    public void setSideLength(int sideLength) {
        if (sideLength >= 10 && sideLength <= 20) {
            this.sideLength = sideLength;
        } else {
            System.out.println("Side length not set. Input not valid.");
        }
    }

    /**
     * Overrides the getArea method to return the area of the instantiated
     * square
     *
     * @return a double for the area of the square
     */
    @Override
    public double getArea() {
        return getSide() * getSide();
    }

    /**
     * Overrides the clone method to include the Square's sideLength with the x
     * and y values from the parent class
     *
     * @return an Object that is a clone of the stored Square (must be cast
     * to Square)
     * @throws CloneNotSupportedException required by Java. Must be handled
     *                                    by calling method.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Square(getX(), getY(), getSide());
    }

    /**
     * Overrides the toString method to return the instance variable data:
     * sideLength, x, y, as well as the total area of the stored Square.
     *
     * @return a String with all stored instance variable data and the area
     * of the Square.
     */
    @Override
    public String toString() {
        return "This square has a side length of: " + sideLength + ", an area" +
                " of:" + getArea() + ", and coords of (" + getX() + "," + getY()
                + ")";
    }
}
