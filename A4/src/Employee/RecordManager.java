/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import Constants.AppConstants;
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
    ArrayList<Employee> allEmployees;
    
    FullTimeFaculty ftf;
    PartTimeFaculty ptf;
    TA ta;
    Staff staff;
    
    EmployeeList employeeList;
    
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

    /**
     * Default Constructor.
     */
    public RecordManager() {
    }
    
    /**
     * Creates an array list from the 4 different FileInputStream.
     * @param a fullTimeEmployees
     * @param b partTimeEmployees
     * @param c TAs
     * @param d Staffs
     */
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
            salary = s.nextInt();
            
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
            hourlyRate = s.nextDouble();
            hourNumber = s.nextInt();
            studentNumber = s.nextInt();
            
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
            classNumber = s.nextInt();
            hourNumber = s.nextInt();
            
            if (checkClassification(classification)) {
                ta = new TA(classification, classNumber, hourNumber, employeeID, firstName, familyName, city, year);
                TAs.add(ta);
            } else {
                System.out.println("Invalid entry: " + employeeID + " " + firstName + "\t" + familyName + "\t" + city + "\t" + year + "\t" + classification + "\t" + classNumber + "\t" + hourNumber);
                System.out.println("Not added to ArrayList.");
            }
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
            
            staff = new Staff(performanceCode, employeeID, firstName, familyName, city, year, salary);
            Staffs.add(staff);
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
    
    //Add records.
    
    /**
     * Add full time record.
     * @param fileName
     */
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
    
    /**
     * Add part time record.
     * @param fileName
     */
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
    
    /**
     * Add TA record.
     * @param fileName
     */
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
                System.out.print("Classification of TA (Grad, UGrd): ");
                classification = s.next();
                while (checkClassification(classification)) {
                    System.out.print("Invalid classification, please enter another one (Grad, UGrd): ");
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
    
    /**
     * Checks the input ID while adding new records.
     * @param a fullTimeEmployees
     * @param b partTimeEmployees
     * @param c TAs
     * @param d Staffs
     * @param newID
     * @return true = duplicated, false = not duplicated.
     */
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
    
    /**
     * Checks if the classification is entered correctly.
     * @param s classification string.
     * @return true = matching classification, false = not a classification code.
     */
    private boolean checkClassification(String s) {
        if ((s.toLowerCase()).equals("grad") || (s.toLowerCase()).equals("ugrd")) {
            return true;
        }
        return false;
    }
    
    /**
     * Writes the ArrayList to file. (New Line)
     * @param a Employee object to string.
     * @param fis FileInputStream
     */
    private void addToTxt(Employee a, String fis) {
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
    
    public void findTermSalary() {
        EmployeeList partTimeEmployeesLL = new EmployeeList();
        EmployeeList TAsLL = new EmployeeList();
        
        FileInputStream ptf_fis = FileManager.readFile(AppConstants.PART_TIME_FACULTY_TXT);
        FileInputStream ta_fis = FileManager.readFile(AppConstants.TA_TXT);
        
        double combinedSalary = 0.0;
        
        //Add part-time to LL
        s = new Scanner(ptf_fis);
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            hourlyRate = s.nextDouble();
            hourNumber = s.nextInt();
            studentNumber = s.nextInt();
            
            ptf = new PartTimeFaculty(hourlyRate, hourNumber, studentNumber, employeeID, firstName, familyName, city, year);
            partTimeEmployeesLL.addAtEnd(ptf);
        } while (s.hasNextLine());
        
        //Add TA to LL
        s = new Scanner(ta_fis);
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            classification = s.next();
            classNumber = s.nextInt();
            hourNumber = s.nextInt();
            
            if (checkClassification(classification)) {
                ta = new TA(classification, classNumber, hourNumber, employeeID, firstName, familyName, city, year);
                TAsLL.addAtEnd(ta);
            } else {
                System.out.println("Invalid entry: " + employeeID + " " + firstName + "\t" + familyName + "\t" + city + "\t" + year + "\t" + classification + "\t" + classNumber + "\t" + hourNumber);
                System.out.println("Not added to LinkedList.");
            }
        } while (s.hasNextLine());
        
        combinedSalary = partTimeEmployeesLL.getTotalSalary()+TAsLL.getTotalSalary();
        System.out.println("The combine total salary of part-time faculty and teaching assistants(TAs) is: $" + combinedSalary);        
    }
    
    public void findHighest_and_Lowest_FT_Salary() {
        EmployeeList fullTimeEmployeesLL = new EmployeeList();
        FileInputStream ftf_fis = FileManager.readFile(AppConstants.FULL_TIME_FACULTY_TXT);
        
        s = new Scanner(ftf_fis);
        do {
            employeeID = s.nextInt();
            firstName = s.next();
            familyName = s.next();
            city = s.next();
            year = s.nextInt();
            salary = s.nextInt();
            
            ftf = new FullTimeFaculty(employeeID, firstName, familyName, city, year, salary);
            fullTimeEmployeesLL.addAtEnd(ftf);
        } while (s.hasNextLine());
        
        fullTimeEmployeesLL.findLowestSalary();
        fullTimeEmployeesLL.findHighestSalary();
    } 
}
