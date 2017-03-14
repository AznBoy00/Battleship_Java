/*
    Assignment #3
    Part: 
    Written by: Kevin Lin - 40002383
 */
package Part1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */

public class BookInventory1{
    
    private static Book bkArr[];
    
    public static void main(String[] args) {
        final String FIS_NAME = "Initial_BookInfo.txt";
        Scanner k = new Scanner(System.in);
        String fileName, input = "";
        FileOutputStream fos = null;
        FileInputStream fis = null;
        File f;
        boolean fileExists = true;
        
        System.out.print("Please enter the name of output file, which will have the correct information: ");
        input = k.next();
        fileName = input;
        f = new File(fileName);
        
        try {
            if (f.exists())
                throw new FileAlreadyExistsException(fileName);
            else
                fileExists = false;
        } catch (FileAlreadyExistsException e) {
            fileExists = true;
            System.out.println("A file with the name " + f.getName() + " already exists.");
            System.out.println("The file already has a size of: " + f.length() + " bytes.\n");
            System.out.print("Please enter another file name to create: ");
            fileName = k.next();
            f = new File(fileName);
        }
        
        try {
            fis = new FileInputStream(FIS_NAME);
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File: " + FIS_NAME + " not found.\nProgram shutting down.");
            System.exit(0);
        }
        
        
        
        
        
        System.out.println("Here are the contents of file Initial_Book_Infor.txt AFTER copying operation:");
        System.out.println("=============================================================================");
        System.out.println("Here are the contents of file Corrected_Book_Info.txt:");
        System.out.println("======================================================");
    }
    
    //Check for duplication etc, fix the original txt file into an unbugged one.
    private static void fixInventory(FileInputStream fis, FileOutputStream fos) {
        
    }
    
    private static void displayFileContents(FileInputStream fis) {
        
    }
}
