/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class FullTimeFaculty extends Employee{

    public FullTimeFaculty(int employeeID, String firstName, String familyName, String city, int year, int salary) {
        super(employeeID, firstName, familyName, city, year, salary);
    }

    @Override
    public String toString() {
        return super.toString() + getSalary();
    }
    
}
