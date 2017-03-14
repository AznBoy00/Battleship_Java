/*
    Assignment #3
    Part: 
    Written by: Kevin Lin - 40002383
 */
package Part1;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class DuplicateISBNException extends Exception{
    private int duplicatedIndex;
    
    public DuplicateISBNException() {
        super("Duplicated ISBN found.");
    }
    
    public DuplicateISBNException(int duplicatedIndex) {
        super("Diplicated ISBN found at index " + duplicatedIndex + ".");
    }
    
    public DuplicateISBNException(String s) {
        super(s);
    }

    public int getDuplicatedIndex() {
        return duplicatedIndex;
    }
    
    public String getMessage() {
        return super.getMessage();
    }
}
