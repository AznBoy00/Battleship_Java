/*
    Assignment #3
    Part: 
    Written by: Kevin Lin - 40002383
 */
package BookInventory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.InputMismatchException;

/**
 *  Part 1 of A3
 * @author Kevin Lin - @AznBoy00
 */

public class BookInventory1{
    
    private static Book bkArr[];
    
    public static void main(String[] args) {
        final String FIS_NAME = "Initial_Book_Info.txt";
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
        
        while(fileExists) {
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
        }
        
        try {
            fis = new FileInputStream(FIS_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        
        try {
            fixInventory("Initial_Book_Info.txt", fileName);
        } catch (IOException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Here are the contents of file " + FIS_NAME + " AFTER copying operation:");
            System.out.println("=============================================================================");
            displayFileContents(FIS_NAME);
        } catch (IOException e) {
            System.out.println("Exception caught while reading: " + FIS_NAME + "\nProgram shutting down.");
            System.exit(0);
        }
        
        try {
            System.out.println("Here are the contents of file " + fileName + ":");
            System.out.println("======================================================");
            displayFileContents(fileName);
        } catch (IOException e) {
            System.out.println("Exception caught while reading: " + fileName + "\nProgram shutting down.");
            System.exit(0);
        }
    }
    
    private static int getRecordCount(String fis) {
        BufferedReader br = null;
        int recordCount;
        recordCount = 0;
        String lineContent = "";
        
        try {
            br = new BufferedReader(new FileReader(fis));
        } catch(FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        } try {
            while (lineContent != null) {
                lineContent = br.readLine();
                //System.out.println(lineContent); For testing purpose.
                if (lineContent != null && !lineContent.isEmpty()) {
                    recordCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading file.\nProgram shutting down.");
            System.exit(0);
        }
        return recordCount;
    }
    
    private static void fixInventory(String fis, String fos) throws IOException{
        int recordCount = getRecordCount(fis);
        bkArr = new Book[recordCount];
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = null;
        System.out.println("\nThe file has " + recordCount + " records.");
        
        try {
            sc = new Scanner(new FileInputStream(fis));
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught.\nProgram shutting down.");
            System.exit(0);
        }
        
        long isbn;
        String title;
        int year;
        String author;
        double price;
        int pageNumber;
        
        for (int i = 0; i < bkArr.length; i++) {
            isbn = sc.nextLong();
            title = sc.next();
            year = sc.nextInt();
            author = sc.next();
            price = sc.nextDouble();
            pageNumber = sc.nextInt();
            
            Book b = new Book(isbn, title, year, author, price, pageNumber);
            bkArr[i] = b;
        }
        
        checkDuplicateISBN();
        
        //Print the corrected duplicated ISBNs onto the new .txt file.
        try {
            pw = new PrintWriter(new FileOutputStream(fos));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open or create the file :" + fos + ". \nProgram shutting down.");
            System.exit(0);
        }
        for (int i = 0; i < bkArr.length; i++)
            pw.println(bkArr[i]);
        pw.close();
        
        System.out.println("PrintWriting successful.\n");
    }
    
    private static void displayFileContents(String fis) throws IOException{
        BufferedReader br = null;
        String s = "", lineContent = "";
        
        try {
            br = new BufferedReader(new FileReader(fis));
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught.\nProgram shutting down.");
            System.exit(0);
        }
        while(lineContent != null) {
            lineContent = br.readLine();
            if (lineContent != null)
                s += lineContent + "\n"; //\n to skip to next line.
        }
        br.close();
        System.out.println(s + "\n");
    }
    
    /**
     * Check for ISBN input by the user.
     * @param newISBN ISBN input.
     * @throws DuplicateISBNException 
     */
    private static void checkISBNInput(long newISBN) throws DuplicateISBNException {
        for (int i = 0; i < bkArr.length; i++) {
            if (bkArr[i].getISBN() == newISBN)
                throw new DuplicateISBNException(i);
        }
    }
    
    private static void checkDuplicateISBN(){
        Scanner input = new Scanner(System.in);
                
        for (int i = 0; i < bkArr.length; i++) {
            for (int j = 0; j < bkArr.length; j++) {
                if (i != j && bkArr[j].getISBN() == bkArr[i].getISBN()) {
                    long newISBN;
                    boolean duplicatedISBN = true;
                    
                    while (duplicatedISBN) {
                        System.out.print("Duplicate ISBN " + bkArr[i].getISBN() + " detected in record #" + (j+1) + ". Please enter the correct ISBN: ");
                        try {
                            newISBN = input.nextLong();
                            try {
                                checkISBNInput(newISBN);
                                bkArr[j].setISBN(newISBN);
                                duplicatedISBN = false;
                            } catch (DuplicateISBNException e) {
                                duplicatedISBN = true;
                                System.out.println("Attempt to duplicate entry to a previous record.\nInitial appearance of ISBN " + newISBN + " was found at record #: " + (e.getDuplicatedIndex()+1));
                            }
                        } catch (InputMismatchException e){
                            duplicatedISBN = true;
                            System.out.println("You didn't enter a valid ISBN.");
                        }                            
                    }
                }
            }
        }
        input.close();
    }
}
