/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import Constants.AppConstants;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class TA extends Employee{
    
    private String classification;
    private int classNumber;
    private int hourNumber;
    private double TAsalary;

    public TA(String classification, int classNumber, int hourNumber, int employeeID, String firstName, String familyName, String city, int year) {
        super(employeeID, firstName, familyName, city, year, 0);
        this.classification = classification;
        this.classNumber = classNumber;
        this.hourNumber = hourNumber;
        super.setSalary(calculateSalary());
    }
    
    private double calculateSalary() {
        TAsalary = 0;
        if (this.getClassification().toLowerCase().equals("grad".toLowerCase())) {
            TAsalary = (double)(AppConstants.GD_TA_RATE*hourNumber);
        } else if (this.getClassification().toLowerCase().equals("ugrd".toLowerCase())) {
            TAsalary = (double)(AppConstants.UD_TA_RATE*hourNumber);
        } else if (this.getClassification().toLowerCase().equals("alum")) {
            TAsalary = -1;
            System.out.println("ERROR: Cannot assign TAsalary to ALUM! Exiting...");
            System.exit(0);
        } else {
            System.out.println("ERROR: Cannot assign TAsalary! Exiting...");
            System.exit(0);
        }
        return TAsalary;       
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

    @Override
    public String toString() {
        return super.toString() + classification + "\t" + classNumber + "\t" + hourNumber;
    }
    
}
