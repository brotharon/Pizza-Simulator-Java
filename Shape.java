import java.awt.*;

/* Class Shape
 *
 * By Rob Nash
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

/**
 * Abstract class. Creates a hierarchy for Shapes. Takes the
 * information from the child class and passes it to the super of this
 * abstract class. This class cannot be instantiated and only serves to
 * create an organizational structure.
 *
 * @author Rob Nash, modified by Calvin Evans
 * @version 08/16/2017
 */
public abstract class Shape extends Object {
    private int x = 0;
    private int y = 0;

    protected Shape(int a, int b) {
        x = a;
        y = b;
    }

    /**
     * Must be set by child.
     * @return Must be set by child
     */
    public double getArea() {
        return -1;
    }

    /**
     * Getter: Gets the instance variable x
     * @return returns an int copy of instance variable x
     */
    protected int getX() {
        return x;
    }

    /**
     * Getter: Gets the instance variable y
     * @return returns and int copy of instance variable y
     */
    protected int getY() {
        return y;
    }

    /**
     * Must be set by child
     * @return Must be set by child
     * @throws CloneNotSupportedException Required by Java. Must be handled
     * by calling method.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return null;
    }
}