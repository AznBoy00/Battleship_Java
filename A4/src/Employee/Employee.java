/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class Employee {
    
    private int employeeID;
    private String firstName;
    private String familyName;
    private String city;
    private int year;

    public Employee(int employeeID, String firstName, String familyName, String city, int year) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.familyName = familyName;
        this.city = city;
        this.year = year;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return employeeID + " " + firstName + "\t" + familyName + "\t" + city + "\t" + year + "\t";
    }
    
}
