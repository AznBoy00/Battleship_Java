/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.util.Scanner;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class EmployeeManagerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Concordia's employee manager app!\n\n\nInitializing local txt files...\t\t\t");
        
        Scanner s = new Scanner(System.in);
        int selection;
        RecordManager rm = new RecordManager();
        rm.createArrayList(Constants.AppConstants.FULL_TIME_FACULTY_TXT, Constants.AppConstants.PART_TIME_FACULTY_TXT, Constants.AppConstants.TA_TXT, Constants.AppConstants.STAFF_TXT);
        
        System.out.println("\n\n\nThe Alum will be deleted, now let's fix the duplicated IDs:");
        rm.fixFTDuplicatedIDs();
        rm.fixPTDuplicatedIDs();
        rm.fixStaffDuplicatedIDs();
        rm.fixTADuplicatedIDs();
        rm.reWriteAlToTxt();
        
        System.out.println("Done...");        
        
        while(true) {
            System.out.println("\n\n\nPlease select from the following options:\n"
                    + "1) Add a full time employee.\n"
                    + "2) Add a part time employee.\n"
                    + "3) Add a TA.\n"
                    + "4) Calculate the term salary of all part-time employees and TAs.\n"
                    + "5) Find the highest and lowest salaries from the full-time employees.\n"
                    + "6) Increase staff salary.\n"
                    + "7) Exit.");
            selection = s.nextInt();
            System.out.println("\n\n\n");
            switch(selection) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    rm.addFTRecords(Constants.AppConstants.FULL_TIME_FACULTY_TXT);
                    break;
                case 2:
                    rm.addPTRecords(Constants.AppConstants.PART_TIME_FACULTY_TXT);
                    break;
                case 3:
                    rm.addTARecords(Constants.AppConstants.TA_TXT);
                    break;
                case 4:
                    rm.findTermSalary();
                    break;
                case 5:
                    rm.findHighest_and_Lowest_FT_Salary();
                    break;
                case 6:
                    rm.Increase_Staff_Salary();
                    break;
                case 7:
                    System.exit(0);
                    System.out.println("Thanks for using the employee manager app!");
                    break;
                default:
                    System.out.println("Invalid input, exiting program...");
                    System.exit(0);
                    break;
            }
        }
    }
}
