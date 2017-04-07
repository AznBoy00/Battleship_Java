/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class DuplicatedIDException extends Exception{
    private int duplicatedIndex;
    
    public DuplicatedIDException() {
        super("Duplicated ID found.");
    }
    
    public DuplicatedIDException(int duplicatedIndex) {
        super("Diplicated ID found at index " + duplicatedIndex + ".");
    }
    
    public DuplicatedIDException(String s) {
        super(s);
    }
    
    public int getDuplicatedIndex() {
        return duplicatedIndex;
    }
    
    public String getMessage() {
        return super.getMessage();
    }
}
