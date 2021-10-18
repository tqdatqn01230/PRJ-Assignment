/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.orderdetails;

import java.sql.Date;
import java.sql.Date;

/**
 *
 * @author Dell
 */
public class OrderDetailsDTO {
    private String detailID,orderID,bookID;
    private int quantity;
    private double price;
    private String status;

    public OrderDetailsDTO(String detailID, String orderID, String bookID, int quantity, double price, String status) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.bookID = bookID;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public String getDetailID() {
        return detailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getBookID() {
        return bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
    
}
