/*
    Assignment #3
    Part: 
    Written by: Kevin Lin - 40002383
 */
package Part1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */

public class BookInventory1{
    
    private static Book bkArr[];
    private static final String BOOK_INFO_FILENAME = "Initial_BookInfo.txt";
    
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        String fileName;
        FileOutputStream fos;
        
        try {
            fos = new FileOutputStream(BOOK_INFO_FILENAME);
        } catch (FileNotFoundException e) {
            
        }
        
        System.out.print("Please enter the name of output file, which will have the correct information: ");
        fileName = i.next();
    }
    
    //Check for duplication etc, fix the original txt file into an unbugged one.
    private static void fixInventory(FileInputStream fis, FileOutputStream fos) {
        
    }
    
    private static void displayFileContents(FileInputStream fis) {
        System.out.println("Here are the contents of file Initial_Book_Infor.txt AFTER copying operation:");
        System.out.println("=============================================================================");
        System.out.println("Here are the contents of file Corrected_Book_Info.txt:");
        System.out.println("======================================================");
    }
}
