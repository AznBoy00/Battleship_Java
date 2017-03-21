/*
    Assignment #3
    Part 1 - Book.java
    Written by: Kevin Lin - 40002383
 */
package BookInventory;

import java.io.Serializable;
import java.util.Objects;

/**
 *  Book.java class with all the proper properties.
 * @author Kevin Lin - @AznBoy00
 */
public class Book implements Serializable{
    private long isbn;
    private String title;
    private int year;
    private String author;
    private double price;
    private int pageNumber;

    /**
     * Constructor used in this application.
     * @param isbn ISBN of the book.
     * @param title title of the book.
     * @param year year printed of the book.
     * @param author author of the book.
     * @param price price of the book.
     * @param pageNumber page number of the book.
     */
    public Book(long isbn, String title, int year, String author, double price, int pageNumber) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
        this.pageNumber = pageNumber;
    }

    /**
     * Getter for title.
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for title.
     * @param title title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for year.
     * @return year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter for year.
     * @param year year.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter for Author.
     * @return author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter for Author.
     * @param author author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter for ISBN.
     * @return ISBN.
     */
    public long getISBN() {
        return isbn;
    }

    /**
     * @param ISBN
     * Setter for ISBN.
     */
    public void setISBN(long ISBN) {
        this.isbn = ISBN;
    }

    /**
     * Getter for price.
     * @return price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for price.
     * @param price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for page number.
     * @return pageNumber.
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Setter for page number.
     * @param pageNumber.
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Method that will return the proper string.
     * @return all the properties in a proper toString() method.
     */
    @Override
    public String toString() {
        return isbn + " " + title + " " + year + " " + author + " " + price + " " + pageNumber; 
    }
}
