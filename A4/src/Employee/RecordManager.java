/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class RecordManager {
    
    Scanner s = null;

    ArrayList<FullTimeFaculty> fullTimeEmployees;
    ArrayList<PartTimeFaculty> partTimeEmployees;
    ArrayList<TA> TAs;
    
    //Employee variables
    int employeeID;
    String firstName;
    String familyName;
    String city;
    int year;
    //Full Time Employee
    int salary;
    //Part Time Employee
    double hourlyRate;
    int studentNumber;
    //TA
    String classification;
    int classNumber;
    //Part Time and TA
    int hourNumber;
    
    
    public RecordManager() {
    }
    
    //1a
    
    public void addFTRecords(String fileName) {
        FileInputStream fis = FileManager.readFile(fileName);
        fullTimeEmployees = new ArrayList();
        FullTimeFaculty ftf;
        
        s = new Scanner(fis);
        
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            hourlyRate = s.nextDouble();
            studentNumber = s.nextInt();
            hourNumber = s.nextInt();
            
            ftf = new FullTimeFaculty(employeeID, firstName, familyName, city, year, salary);
            fullTimeEmployees.add(ftf);
        } while (s.hasNextLine());
        
        addNewFullTimeEmployee();
    }
    
    public void addPTRecords(String fileName) {
        FileInputStream fis = FileManager.readFile(fileName);
        partTimeEmployees = new ArrayList();
        PartTimeFaculty ptf;
        
        s = new Scanner(fis);
        
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            salary = s.nextInt();
            
            ptf = new PartTimeFaculty(hourlyRate, hourNumber, studentNumber, employeeID, firstName, familyName, city, year);
            partTimeEmployees.add(ptf);
        } while (s.hasNextLine());
        
        addNewPartTimeEmployee();
    }
    
    public void addTARecords(String fileName) {
        FileInputStream fis = FileManager.readFile(fileName);
        TAs = new ArrayList();
        TA ta;
        
        s = new Scanner(fis);
        
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            classification = s.next();
            
            ta = new TA(classification, hourNumber, studentNumber, employeeID, firstName, familyName, city, year);
            TAs.add(ta);
        } while (s.hasNextLine());
        
        addNewTA();
    }
    
    //1b
    
    private void addNewFullTimeEmployee(){
        s = new Scanner(System.in);
        FullTimeFaculty ftf;
        
        do {
            try {
                System.out.println("Please enter the new information of the new full time employee.");
                System.out.print("Employee ID: ");
                employeeID = s.nextInt();
                while (checkID(fullTimeEmployees, partTimeEmployees, TAs, employeeID)) {
                    try {
                        System.out.print("Enter another employee ID: ");
                        employeeID = s.nextInt();
                        throw new DuplicatedIDException(employeeID);
                    } catch(DuplicatedIDException e) {
                        System.out.println("ID duplication detected.");
                    }
                }
                System.out.print("First Name: ");
                firstName = s.next();
                System.out.print("Family Name: ");
                familyName = s.next();
                System.out.print("City of residence: ");
                city = s.next();
                System.out.print("Hire year: ");
                year = s.nextInt();
                System.out.print("Salary: ");
                salary = s.nextInt();
                
                ftf = new FullTimeFaculty(employeeID, firstName, familyName, city, year, salary);
                fullTimeEmployees.add(ftf);
                
                System.out.print("Would you like to add another full time employee?");
                s.next();
            } catch(InputMismatchException e) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
        } while(!s.equals("-1"));
    }
    
    private void addNewPartTimeEmployee(){
        s = new Scanner(System.in);
        PartTimeFaculty ptf;
        
        do {
            try {
                System.out.println("Please enter the new information of the new part time employee.");
                System.out.print("Employee ID: ");
                employeeID = s.nextInt();
                while (checkID(fullTimeEmployees, partTimeEmployees, TAs, employeeID)) {
                    try {
                        System.out.print("Enter another employee ID: ");
                        employeeID = s.nextInt();
                        throw new DuplicatedIDException(employeeID);
                    } catch(DuplicatedIDException e) {
                        System.out.println("ID duplication detected.");
                    }
                }
                System.out.print("First Name: ");
                firstName = s.next();
                System.out.print("Family Name: ");
                familyName = s.next();
                System.out.print("City of residence: ");
                city = s.next();
                System.out.print("Hire year: ");
                year = s.nextInt();
                System.out.print("Hourly rate: ");
                hourlyRate = s.nextInt();
                System.out.print("Number of hours: ");
                hourNumber = s.nextInt();
                System.out.print("Number of student: ");
                studentNumber = s.nextInt();
                
                ptf = new PartTimeFaculty(hourlyRate, hourNumber, studentNumber, employeeID, firstName, familyName, city, year);
                partTimeEmployees.add(ptf);
                
                System.out.print("Would you like to add another part time employee?");
                s.next();
            } catch(InputMismatchException e) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
        } while(!s.equals("-1"));
    }
    
    private void addNewTA(){
        s = new Scanner(System.in);
        TA ta;
        
        do {
            try {
                System.out.println("Please enter the new information of the new TA.");
                System.out.print("Employee ID: ");
                employeeID = s.nextInt();
                while (checkID(fullTimeEmployees, partTimeEmployees, TAs, employeeID)) {
                    try {
                        System.out.print("Enter another employee ID: ");
                        employeeID = s.nextInt();
                        throw new DuplicatedIDException(employeeID);
                    } catch(DuplicatedIDException e) {
                        System.out.println("ID duplication detected.");
                    }
                }
                System.out.print("First Name: ");
                firstName = s.next();
                System.out.print("Family Name: ");
                familyName = s.next();
                System.out.print("City of residence: ");
                city = s.next();
                System.out.print("Hire year: ");
                year = s.nextInt();
                System.out.print("Classification of TA: ");
                classification = s.next();
                System.out.print("Number of classes: ");
                classNumber = s.nextInt();
                System.out.print("Number of working hours: ");
                hourNumber = s.nextInt();
                
                ta = new TA(classification, hourNumber, studentNumber, employeeID, firstName, familyName, city, year);
                TAs.add(ta);
                
                System.out.print("Would you like to add another TA?");
                s.next();
            } catch(InputMismatchException e) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
        } while(!s.equals("-1"));
    }
    
    private boolean checkID(ArrayList<FullTimeFaculty> a, ArrayList<PartTimeFaculty> b, ArrayList<TA> c, int newID) {
        s = new Scanner(System.in);
        for (int i = 0; i < a.size(); i++) {
            if (newID == ((FullTimeFaculty)a.get(i)).getEmployeeID()) {
                return true;
            }
        }
        for (int i = 0; i < b.size(); i++) {
            if (newID == ((PartTimeFaculty)b.get(i)).getEmployeeID()) {
                return true;
            }
        }
        for (int i = 0; i < c.size(); i++) {
            if (newID == ((TA)c.get(i)).getEmployeeID()) {
                return true;
            }
        }
        return false;
    }
}
