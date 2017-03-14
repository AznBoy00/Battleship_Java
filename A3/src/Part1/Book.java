/*
    Assignment #3
    Part 1 - Book.java
    Written by: Kevin Lin - 40002383
 */
package Part1;

import java.util.Objects;

/**
 *
 * @author Kevin Lin - @AznBoy00
 */
public class Book {
    private long isbn;
    private String title;
    private int year;
    private String author;
    private double price;
    private int pageNumber;

    public Book(long isbn, String title, int year, String author, double price, int pageNumber) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.author = author;
        this.price = price;
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getISBN() {
        return isbn;
    }

    public void setISBN(long ISBN) {
        this.isbn = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return isbn + " " + title + " " + year + " " + author + " " + price + " " + pageNumber; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.isbn != other.isbn) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.pageNumber != other.pageNumber) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }
}
