/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class PartTimeFaculty extends Employee{
    
    private double hourlyRate;
    private int hourNumber;
    private int studentNumber;
    private double salary;

    public PartTimeFaculty(double hourlyRate, int hourNumber, int studentNumber, int employeeID, String firstName, String familyName, String city, int year) {
        super(employeeID, firstName, familyName, city, year, 0.0);
        this.hourlyRate = hourlyRate;
        this.hourNumber = hourNumber;
        this.studentNumber = studentNumber;
        super.setSalary(calculateSalary());
    }
    
    private double calculateSalary() {
        salary = 0;
        double extra = 0;
        if (this.studentNumber > 60) {
            extra = 1000;
        } else if (this.studentNumber >= 40) {
            extra = 500;
        }
        salary = (double)((this.hourNumber*this.hourlyRate) + extra);
        return salary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHourNumber() {
        return hourNumber;
    }

    public void setHourNumber(int hourNumber) {
        this.hourNumber = hourNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    @Override
    public String toString() {
        return super.toString() + hourlyRate + "\t" + hourNumber + "\t" + studentNumber;
    }
}
