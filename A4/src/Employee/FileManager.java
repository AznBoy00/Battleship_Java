/*
        COMP249 - Assignment 4
        Written by: Kevin Lin - 40002383
 */
package Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
    
    public static FileOutputStream writeFile(String fileName) {
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(fileName);
        } catch(FileNotFoundException e) {
            System.out.println(fileName + " not found.\nProgram shutting down.");
            System.exit(0);
        }
        return fos;
    }
}
