/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.book;

/**
 *
 * @author Dell
 */
public class BookDTO {
    String BookID,BookName;
    int quantity;
    double price;String author,categoryID;

    public BookDTO(String BookID, int quantity) {
        this.BookID = BookID;
        this.quantity = quantity;
    }

    
 

    public BookDTO(String BookID, String BookName, int quantity, double price, String author, String categoryID) {
        this.BookID = BookID;
        this.BookName = BookName;
        this.quantity = quantity;
        this.price = price;
        this.author = author;
        this.categoryID = categoryID;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookID() {
        return BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    
}
