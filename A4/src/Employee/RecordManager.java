/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
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
    
    private FullTimeFaculty addNewFullTimeEmployee(){
        s = new Scanner(System.in);
        
        do {
            try {
                System.out.println("Please enter the new information of the new employee.");
                System.out.print("Employee ID: ");
                employeeID = s.nextInt();
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
                
                
            } catch(InputMismatchException) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
        } while(!s.equals(-1));
    }
    
    private boolean checkID() {
        int recordCount = getRecordCount(fis);
        Scanner sc = null;
        long lastISBN;
        
        try {
            sc = new Scanner(new FileInputStream(fis));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        for (int i = 0; i < (recordCount - 1); i++)
            sc.nextLine();
        lastISBN = sc.nextLong();
        if (ISBNinput <= lastISBN) {
            System.out.println("The ISBN entered has to have an ID greater than the last ISBN on the sorted list.\nPlease enter a valid ISBN.");
            return false;
        } else {
            return true;
        }
    }
}
