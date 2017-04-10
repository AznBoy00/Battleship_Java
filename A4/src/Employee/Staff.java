/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class Staff extends Employee{
    
    private String performanceCode;

    public Staff(String performanceCode, int employeeID, String firstName, String familyName, String city, int year, double salary) {
        super(employeeID, firstName, familyName, city, year, salary);
        this.performanceCode = performanceCode;
    }

    public String getPerformanceCode() {
        return performanceCode;
    }

    public void setPerformanceCode(String performanceCode) {
        this.performanceCode = performanceCode;
    }

    @Override
    public String toString() {
        return super.toString() + ((int)getSalary()) + "\t" + performanceCode;
    }
}
