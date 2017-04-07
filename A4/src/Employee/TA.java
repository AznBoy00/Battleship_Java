/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class TA extends Employee{
    
    private String classification;
    private int classNumber;
    private int hourNumber;

    public TA(String classification, int classNumber, int hourNumber, int employeeID, String firstName, String familyName, String city, int year) {
        super(employeeID, firstName, familyName, city, year);
        this.classification = classification;
        this.classNumber = classNumber;
        this.hourNumber = hourNumber;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getHourNumber() {
        return hourNumber;
    }

    public void setHourNumber(int hourNumber) {
        this.hourNumber = hourNumber;
    }
    
    
}
