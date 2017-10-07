
/**
 * Creates a circular shaped pizza crust to be the foundation of the pizza.
 *
 * @author Calvin Evans
 * @version 8/16/2017
 */
public class Circle extends Shape {
    private int diameter;
    private double area;

    /**
     * Constructor: passes x and y coords to super and instantiates all of
     * the local instance variables.
     * @param x the x coord on a 2d plane
     * @param y the y coord on a 2d plane
     * @param diameter an int for the diameter of the crust
     */
    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
        setArea((double)this.diameter / 2);
    }

    /**
     * Sets the area of the circular crust using pi*r^2
     * @param radius a double that is diameter / 2
     */
    private void setArea(double radius) {
        this.area = Math.PI * (radius * radius);
    }

    /**
     * Overrides the getArea method to return the area of the instantiated
     * circle
     * @return a double for the area of the circle
     */
    @Override
    public double getArea(){
        return this.area;
    }

    /**
     * Overrides the clone method to include the Circle's diameter with the x
     * and y values from the parent class
     * @return an Object that is a clone of the stored Circle (must be cast
     * to Circle)
     * @throws CloneNotSupportedException required by Java. Must be handled
     * by calling method.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Circle(getX(), getY(), this.diameter);
    }

    /**
     * Overrides the toString method to return the instance variable data:
     * diameter, x, y, as well as the total area of the stored Circle.
     * @return a String with all stored instance variable data and the area
     * of the Circle.
     */
    @Override
    public String toString() {
        return "This circle has a diameter of: " + diameter + ", an area of: " +
                "" + getArea() + ", and coords of (" + getX() + "," + getY()
                + ")";
    }
}
