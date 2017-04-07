/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class FileManager {
    
    public static FileInputStream readFile(String fileName) {
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found.\nProgram shutting down.");
            System.exit(0);
        }
        return fis;
    }
}
