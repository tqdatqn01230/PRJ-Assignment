/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.order;

import java.sql.Date;

/**
 *
 * @author Dell
 */
public class OrderDTO {
    private String orderID,userID;
    private double total;
    private String address,phone,email;
    private Date buydate;

    public OrderDTO(String orderID, String userID, double total, String address, String phone, String email, Date buydate) {
        this.orderID = orderID;
        this.userID = userID;
        this.total = total;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.buydate = buydate;
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }
    
    public String getEmail() {
        return email;
    }

  

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    

    public String getOrderID() {
        return orderID;
    }

    public String getUserID() {
        return userID;
    }

    public double getTotal() {
        return total;
    }


    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

}