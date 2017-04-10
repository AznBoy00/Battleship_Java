/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public interface Ordered {
    public boolean precedes(Object obj);
    public boolean follows(Object obj);
}
