/*
    Assignment #3
    Part 2 - BookInventory2.java
    Written by: Kevin Lin - 40002383
 */
package BookInventory;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Part 1 of A3
 * This part of the program will prompt the user to register addition books to the pre-sorted inventory, it will also let the user search with 2 types of searching methods (Binary and Sequential).
 * After, it will write the new inventory to a binary file so the program can reuse it later on without reading a text file.
 * @author Kevin Lin - @AznBoy00
 */
public class BookInventory2 {
    
    private static Book bkArr[];
    private final static String FIS_NAME = "Sorted_Book_Info.txt";
    private final static String FOS_DAT_NAME = "Books.dat";
    
    public static void main(String[] args) {
        
        Scanner k = new Scanner(System.in);
        String fileName, input = "";
        FileOutputStream fos = null;
        FileInputStream fis = null;
        File f;
        boolean fileExists = true;
        // Binary search variables
        long searchISBN = -1;
        int searchISBNPointer, startIndex = 0, endIndex = -1;
        
        //Opening Streams
        try {
            fis = new FileInputStream(FIS_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.\nProgram shutting down.");
            System.exit(0);
        }
        
        // START OF ADDING DATA TO ARRAYS ETC.
        
        addRecords(FIS_NAME);
        try {
            System.out.println("\n\nHere are the contents of file " + FIS_NAME + ":");
            System.out.println("===============================================");
            displayFileContents(FIS_NAME);
        } catch (IOException e) {
            System.out.println("Exception caught while reading: " + FIS_NAME + "\nProgram shutting down.");
            System.exit(0);
        }
        addBookArray(FIS_NAME);
        
        // START BINARY SEARCH
        try {
            System.out.println("\n==BINARY SEARCH==");
            System.out.print("Enter your ISBN to search: ");
            searchISBN = k.nextLong();
            System.out.print("Please enter your start index (inclusive value): ");
            startIndex = k.nextInt();
            System.out.print("Please enter your end index (exclusive value): ");
            endIndex = k.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("InputMismatchException caught.");
            startIndex = 0;
            endIndex = -1;
        }
        
        if (startIndex < 0 || startIndex >= bkArr.length) {
            startIndex = 0;
            System.out.println("Start Index set to 0 due to invalid input.");
        }
        if (endIndex < 0 || endIndex > bkArr.length) {
            endIndex = bkArr.length;
            System.out.println("End Index set to max index value due to invalid input.");
        }
        
        if (startIndex < endIndex) {
            searchISBNPointer = binaryBookSearch(bkArr, startIndex, endIndex, searchISBN);
        } else {
            System.out.println("Invalid search index range.");
            searchISBNPointer = -1;
        }
        
        if (searchISBNPointer != -1) {
            System.out.println("The entered ISBN was found at index #" + searchISBNPointer);
        } else {
            System.out.println("The ISBN was not found.");
            startIndex = 0;
            endIndex = -1;
        }
        
        // START OF SEQUENTIAL SEARCH
        
        try {
            System.out.println("\n==SEQUENTIAL SEARCH==");
            System.out.print("Enter your ISBN to search: ");
            searchISBN = k.nextLong();
            System.out.print("Please enter your start index (inclusive value): ");
            startIndex = k.nextInt();
            System.out.print("Please enter your end index (exclusive value): ");
            endIndex = k.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("InputMismatchException caught.");
        }
        
        if (startIndex < 0 || startIndex >= bkArr.length) {
            startIndex = 0;
            System.out.println("Start Index set to 0 due to invalid input.");
        }
        if (endIndex < 0 || endIndex > bkArr.length) {
            endIndex = bkArr.length;
            System.out.println("End Index set to max index value due to invalid input.");
        }
        
        if (startIndex < endIndex) {
            searchISBNPointer = sequentialBookSearch(bkArr, startIndex, endIndex, searchISBN);
        } else {
            System.out.println("Invalid search index range.");
            searchISBNPointer = -1;
        }
        
        if (searchISBNPointer != -1) {
            System.out.println("The entered ISBN was found at index #" + searchISBNPointer);
        } else {
            System.out.println("The ISBN was not found.");
        }
        
        // WRITE BINARY
        
        System.out.println("\nNow, let's write the book array to a binary file as: " + FOS_DAT_NAME + " [...]");
        writeBookArrayToBinary(FOS_DAT_NAME);
        
        //TESTING PURPOSE
        //System.out.println("OUTPUT FOS_DAT_NAME");
        //readBinary(FOS_DAT_NAME);
        
        System.out.println("Program execution done.");
    }
    
    // START OF BINARY BOOK SEARCH METHODS
    
    /**
     * Search a book using binary search.
     * @param b Book object.
     * @param startIndex start index.
     * @param endIndex end index.
     * @param searchISBN ISBN.
     * @return search pointer.
     */
    private static int binaryBookSearch(Book[] b, int startIndex, int endIndex, long searchISBN) {
        System.out.println("Started to binary search for " + searchISBN + " between " + startIndex + " to " + endIndex + ".");
        int iterationNumber = 1;
        int pointer = (endIndex + startIndex) /2;
        //starting the pointer at the middle of startIndex and endIndex is an iteration by itself
        
        while (b[pointer].getISBN() != searchISBN && iterationNumber <= getRecordCount(FIS_NAME)) {
            iterationNumber++;
            if (b[pointer].getISBN() > searchISBN) {
                pointer = (pointer + startIndex) /2;
            } else {
                pointer = (pointer + endIndex) /2;
            }
        }
        if (iterationNumber > getRecordCount(FIS_NAME)) {
            System.out.println("ISBN not found.");
            return -1;
        } else {
            System.out.println("Total Iterations: " + iterationNumber);
            return pointer;
        }
    }
    
    /**
     * Search a book using sequential search.
     * @param b Book object.
     * @param startIndex start index.
     * @param endIndex end index.
     * @param searchISBN ISBN.
     * @return search pointer.
     */
    private static int sequentialBookSearch(Book[] b, int startIndex, int endIndex, long searchISBN) {
        int interation = 0;
        for (int i = startIndex; i < endIndex; i++) {
            interation++;
            if (b[i].getISBN() == searchISBN) {
                return i;
            }
        }
        return -1;
    }
    
    // START OF ADD RECORD STUFF
    
    /**
     * Add records to the file.
     * @param fis file.
     */
    private static void addRecords(String fis) {
        Scanner kb = new Scanner(System.in);
        boolean repeat = true;

        do {
            try {
                Book newBook = inputBookInfo(fis, kb);
                if (newBook != null) {
                    System.out.println("Book entered was registered successfully.");
                    addBook(newBook, fis);
                }
                System.out.print("Would you like to add another book? (Y/N Any other key will be considered as a no.): ");
                switch(kb.next().toUpperCase()) {
                    case "Y":
                        repeat = true;
                        break;
                    default:
                        repeat = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchExceptionCaught. Try again.");
            }
            
        } while(repeat);
    }
    
    /**
     * Prints the added book to the file.
     * @param b Book object.
     * @param fis file.
     */
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
    
    /**
     * Add newBook to bkArr[].
     * @param fis file.
     */
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
    
    /**
     * Check for valid ISBN.
     * @param fis file.
     * @param ISBNinput input.
     * @return boolean for valid ISBN.
     */
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
    
    /**
     * Menu prompt for the user to input the data for the new book.
     * @param fis file.
     * @param kb Scanner input.
     * @return Book object.
     */
    private static Book inputBookInfo(String fis, Scanner kb) {
        long isbn;
        String title;
        int year;
        String author;
        double price;
        int pageNumber;
        
        try {
            System.out.print("Please enter the ISBN of the Book you wish to add to " + fis + ": ");
            isbn = kb.nextLong();
            if (!checkISBN(fis, isbn))
                throw new InputMismatchException();
            System.out.print("Please enter its book title (Use _ for spaces): ");
            title = kb.next();
            System.out.print("Please enter its print year: ");
            year = kb.nextInt();
            System.out.print("Please enter the author's name (Use _ for spaces): ");
            author = kb.next();
            System.out.print("Please enter its price: ");
            price = kb.nextDouble();
            System.out.print("Please enter its page number count: ");
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
    
    /**
     * Writes the FileOutputStream to a binary file.
     * @param fos file.
     */
    private static void writeBookArrayToBinary(String fos) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fos));
            for (int i = 0; i < bkArr.length; i++) {
                oos.writeLong(bkArr[i].getISBN());
                oos.writeUTF(bkArr[i].getTitle());
                oos.writeInt(bkArr[i].getYear());
                oos.writeUTF(bkArr[i].getAuthor());
                oos.writeDouble(bkArr[i].getPrice());
                oos.writeInt(bkArr[i].getPageNumber());
            }
            oos.close();
            System.out.println("Binary writing done.");
        } catch(IOException e) {
            System.out.println("IOException caught.\nProgram shutting down.");
            System.exit(0);
        }
    }
    
    // READ BINARY FILE (TESTING PURPOSE)
    /**
     * Read from an input binary file.
     * @param fis file.
     */
    public static void readBinary(String fis) {
        ObjectInputStream ois = null;
        long isbn;
        String title;
        int year;
        String author;
        double price;
        int pageNumber;

        try {
            ois = new ObjectInputStream(new FileInputStream(fis));
            try {
                while(true) {
                    isbn = ois.readLong();
                    title = ois.readUTF();
                    year = ois.readInt();
                    author = ois.readUTF();
                    price = ois.readDouble();
                    pageNumber = ois.readInt();
                    Book b = new Book(isbn, title, year, author, price, pageNumber);
                    System.out.println(b);
                }
            } catch(EOFException e) {
                System.out.println("\nReading of " + fis + " has been completed.");
            }
            ois.close();
        } catch(FileNotFoundException e) {
            System.out.println("IOExceptiion caught.\nProgram shutting down.");
            System.exit(0);	
        } catch(IOException e) {
            System.out.println("IOExceptiion caught.\nProgram shutting down.");
            System.exit(0);			
        }
    }
    
    // Re-used methods from Part 1
    
    /**
     * Get the number of records inside the file.
     * @param fis file.
     * @return number of lines of data from the input file.
     */
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
    
    /**
     * Display the content of the input file.
     * @param fis file.
     * @throws IOException 
     */
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
}
