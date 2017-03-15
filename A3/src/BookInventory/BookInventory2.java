/*
    Assignment #3
    Part 2 - BookInventory2.java
    Written by: Kevin Lin - 40002383
 */
package BookInventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class BookInventory2 {
    
    private static Book bkArr[];
    
    public static void main(String[] args) {
        final String FIS_NAME = "Sorted_Book_Info.txt";
        Scanner k = new Scanner(System.in);
        String fileName, input = "";
        FileOutputStream fos = null;
        FileInputStream fis = null;
        File f;
        boolean fileExists = true;
        int startIndex, endIndex;
        
        //Opening Streams
        try {
            fis = new FileInputStream(FIS_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        
        addRecords(FIS_NAME);
        try {
            System.out.println("Here are the contents of file " + FIS_NAME + ":");
            System.out.println("===============================================");
            displayFileContents(FIS_NAME);
        } catch (IOException e) {
            System.out.println("Exception caught while reading: " + FIS_NAME + "\nProgram shutting down.");
            System.exit(0);
        }
        addBookArray(FIS_NAME);
        // END OF ADD BOOK STUFF
    }
    
    //
    
    // START OF ADD RECORD STUFF
    private static void addRecords(String fis) {
        Scanner kb = new Scanner(System.in);
        String input = "";

        do {
            Book newBook = inputBookInfo(fis, kb);
            if (newBook != null) {
                System.out.println("Book entered was registered successfully.");
                addBook(newBook, fis);
            }
            System.out.print("Would you like to add another book? (Y/N || YES/NO)");
            input = kb.next().toUpperCase();
            
        } while(input == "Y" || input == "YES");
    }
    
    private static void addBook(Book b, String fis) {
        PrintWriter pw = null;
        
        try {
            pw = new PrintWriter(new FileOutputStream(fis, true));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        pw.println();
        pw.print(b);
        pw.close();
    }
    
    private static void addBookArray(String fis) {
        Scanner sc = null;
        int recordCount = getRecordCount(fis);
        bkArr = new Book[recordCount];
        long isbn;
        String title;
        int year;
        String author;
        double price;
        int pageNumber;
        
        System.out.println("The file has " + bkArr.length + " records.\nFormatting array...");
        try {
            sc = new Scanner(new FileInputStream(fis));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        
        for (int i = 0; i < recordCount; i++) {
            isbn = sc.nextLong();
            title = sc.next();
            year = sc.nextInt();
            author = sc.next();
            price = sc.nextDouble();
            pageNumber = sc.nextInt();
            
            Book b = new Book(isbn, title, year, author, price, pageNumber);
            bkArr[i] = b;
        }
    }
    
    private static boolean checkISBN(String fis, long ISBNinput) {
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
    
    private static Book inputBookInfo(String fis, Scanner kb) {
        long isbn;
        String title;
        int year;
        String author;
        double price;
        int pageNumber;
        
        try {
            System.out.print("\nPlease enter the ISBN of the Book you wish to add to: " + fis + ": ");
            isbn = kb.nextLong();
            if (!checkISBN(fis, isbn))
                throw new InputMismatchException();
            System.out.print("Please enter its book title (Use _ for spaces):");
            title = kb.next();
            System.out.print("Please enter its print year:");
            year = kb.nextInt();
            System.out.print("Please enter the author's name (Use _ for spaces):");
            author = kb.next();
            System.out.print("Please enter its price:");
            price = kb.nextDouble();
            System.out.println("Please enter its page number count:");
            pageNumber = kb.nextInt();

            Book b = new Book(isbn, title, year, author, price, pageNumber);
            return b;
        } catch (InputMismatchException e) {
            kb.nextLine();
            System.out.println("InputMismatchException caught, please try again.");
            return null;
        }
    }
    
    // END OF ADD BOOK STUFF
    
    private static void binaryBookSearch(Book[] b, int startIndex, int endIndex, long ISBN) {
        int iterationNumber;
    }
    
    private static void sequentialBookSearch(Book[] b, int startIndex, int endIndex, long ISBN) {
        
    }
    
    // Re-used methods from Part 1
    
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
