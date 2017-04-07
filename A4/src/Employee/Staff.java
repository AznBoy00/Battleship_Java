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
    
    private int salary;
    private char performanceCode;

    public Staff(int salary, char performanceCode, int employeeID, String firstName, String familyName, String city, int year) {
        super(employeeID, firstName, familyName, city, year);
        this.salary = salary;
        this.performanceCode = performanceCode;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public char getPerformanceCode() {
        return performanceCode;
    }

    public void setPerformanceCode(char performanceCode) {
        this.performanceCode = performanceCode;
    }

    @Override
    public String toString() {
        return super.toString() + salary + "\t" + performanceCode;
    }
}
