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
    
    private int salary;

    public FullTimeFaculty(int employeeID, String firstName, String familyName, String city, int year, int salary) {
        super(employeeID, firstName, familyName, city, year);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + salary;
    }
    
}
