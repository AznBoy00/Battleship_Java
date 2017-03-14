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
    private long ISBN;
    private double price;
    private int pageNumber, year;
    private String author;

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
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
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
        return "Book{" + "price=" + price + ", pageNumber=" + pageNumber + ", year=" + year + ", author=" + author + '}';
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
        if (this.ISBN != other.ISBN) {
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
