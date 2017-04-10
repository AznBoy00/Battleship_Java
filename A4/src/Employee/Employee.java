/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
abstract class Employee implements Ordered {
    
    private int employeeID;
    private String firstName;
    private String familyName;
    private String city;
    private int year;
    private double salary;

    public Employee(int employeeID, String firstName, String familyName, String city, int year, double salary) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.familyName = familyName;
        this.city = city;
        this.year = year;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
    public boolean precedes(Object obj) {
        if (obj != null)
        if(this.getYear() < ((Employee)obj).getYear()) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean follows(Object obj) {
        if (obj != null)
        if(this.getYear() > ((Employee)obj).getYear()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return employeeID + " " + firstName + "\t" + familyName + "\t" + city + "\t" + year + "\t";
    }
    
}
