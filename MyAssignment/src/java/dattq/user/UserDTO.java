/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.user;

/**
 *
 * @author Dell
 */
public class UserDTO {
    private String userId, fullName, password;
    private String role,address,phone,email;
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    private double balance=0;

    public UserDTO() {
    }

    public UserDTO(String userId, String fullName, String password, String role, String address, String phone, String email,double balance) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.balance=balance;
    }



    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getBalance() {
        return balance;
    }

    public UserDTO(String userId, String fullName) {
        this.userId = userId;
        this.fullName = fullName;
    }
    
    public UserDTO(String id, String password, String fullName, String role) {
        this.userId = id;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

}
