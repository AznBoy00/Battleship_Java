/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
    ArrayList<Staff> Staffs;
    
    FullTimeFaculty ftf;
    PartTimeFaculty ptf;
    TA ta;
    Staff staff;
    
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
    //Staff
    String performanceCode;
    
    //1a

    public RecordManager() {
    }
    
    public void createArrayList(String a, String b, String c, String d) {
        FileInputStream ftf_fis = FileManager.readFile(a);
        FileInputStream ptf_fis = FileManager.readFile(b);
        FileInputStream ta_fis = FileManager.readFile(c);
        FileInputStream staff_fis = FileManager.readFile(d);
        
        fullTimeEmployees = new ArrayList();
        partTimeEmployees = new ArrayList();
        TAs = new ArrayList();
        Staffs = new ArrayList();
        
        //Create ArrayList for Full Time Faculty
        s = new Scanner(ftf_fis);
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
        
        //Create ArrayList for Part Time Faculty
        s = new Scanner(ptf_fis);
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
        
        //Create ArrayLit for TAs
        s = new Scanner(ta_fis);
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            classification = s.next();
            
            ftf = new FullTimeFaculty(employeeID, firstName, familyName, city, year, salary);
            Staffs.add(staff);
        } while (s.hasNextLine());
        
        //Create ArrayLit for Staff
        s = new Scanner(staff_fis);
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            salary = s.nextInt();
            performanceCode = s.next();
            
            
            staff = new Staff(salary, performanceCode, employeeID, firstName, familyName, city, year);
            TAs.add(ta);
        } while (s.hasNextLine());
        
        //Close the streams.
        try {
            ftf_fis.close();
            ptf_fis.close();
            ta_fis.close();
            staff_fis.close();
        } catch (IOException e) {
            System.out.println("IOException caught.\nProgram shutting down.");
            System.exit(0);
        }
    }
    
    public void createLinkedList() {
        createArrayList(Constants.AppConstants.FULL_TIME_FACULTY_TXT, Constants.AppConstants.PART_TIME_FACULTY_TXT, Constants.AppConstants.TA_TXT, Constants.AppConstants.STAFF_TXT);
        
    }
    
    //1b
    
    public void addFTRecords(String fileName) {
        s = new Scanner(System.in);
        FullTimeFaculty ftf;
        
        do {
            try {
                System.out.println("Please enter the new information of the new full time employee.");
                System.out.print("Employee ID: ");
                employeeID = s.nextInt();
                while (checkID(fullTimeEmployees, partTimeEmployees, TAs, Staffs, employeeID)) {
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
                addToTxt((FullTimeFaculty)ftf, fileName);
                
                System.out.print("Would you like to add another full time employee?");
                s.next();
            } catch(InputMismatchException e) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
        } while(!s.equals("-1"));
    }
    
    public void addPTRecords(String fileName) {
        s = new Scanner(System.in);
        PartTimeFaculty ptf;
        
        do {
            try {
                System.out.println("Please enter the new information of the new part time employee.");
                System.out.print("Employee ID: ");
                employeeID = s.nextInt();
                while (checkID(fullTimeEmployees, partTimeEmployees, TAs, Staffs, employeeID)) {
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
                addToTxt((PartTimeFaculty)ptf, fileName);
                
                System.out.print("Would you like to add another part time employee?");
                s.next();
            } catch(InputMismatchException e) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
        } while(!s.equals("-1"));
    }
    
    public void addTARecords(String fileName) {
        s = new Scanner(System.in);
        TA ta;
        
        do {
            try {
                System.out.println("Please enter the new information of the new TA.");
                System.out.print("Employee ID: ");
                employeeID = s.nextInt();
                while (checkID(fullTimeEmployees, partTimeEmployees, TAs, Staffs, employeeID)) {
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
                System.out.print("Classification of TA (Grad, UGrd, or Alum): ");
                classification = s.next();
                while (checkClassification(classification)) {
                    System.out.print("Invalid classification, please enter another one (Grad, UGrd, or Alum): ");
                    classification = s.next();
                }
                System.out.print("Number of classes: ");
                classNumber = s.nextInt();
                System.out.print("Number of working hours: ");
                hourNumber = s.nextInt();
                
                ta = new TA(classification, hourNumber, studentNumber, employeeID, firstName, familyName, city, year);
                TAs.add(ta);
                addToTxt((TA)ta, fileName);
                
                System.out.print("Would you like to add another TA?");
                s.next();
            } catch(InputMismatchException e) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
        } while(!s.equals("-1"));
    }
    
    private boolean checkID(ArrayList<FullTimeFaculty> a, ArrayList<PartTimeFaculty> b, ArrayList<TA> c, ArrayList<Staff> d, int newID) {
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
        for (int i = 0; i < d.size(); i++) {
            if (newID == ((Staff)d.get(i)).getEmployeeID()) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkClassification(String s) {
        if ((s.toLowerCase()).equals("grad") || (s.toLowerCase()).equals("ugrd") || (s.toLowerCase()).equals("alum")) {
            return true;
        }
        return false;
    }
    
    private void addToTxt(Object a, String fis) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(fis, true));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        pw.println();
        pw.print(a);
        pw.close();
    }
    
    private double findTermSalary() {
        return 0.0;
    }
}
