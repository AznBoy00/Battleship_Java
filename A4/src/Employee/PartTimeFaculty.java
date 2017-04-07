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

    public PartTimeFaculty(double hourlyRate, int hourNumber, int studentNumber, int employeeID, String firstName, String familyName, String city, int year) {
        super(employeeID, firstName, familyName, city, year);
        this.hourlyRate = hourlyRate;
        this.hourNumber = hourNumber;
        this.studentNumber = studentNumber;
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
