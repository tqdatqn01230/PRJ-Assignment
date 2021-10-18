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
public class UserErrorDTO {

    String userIDError, passwordError, confirmError, fullnameError, roleError, address, phone,balance;

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBalance() {
        return balance;
    }


    public UserErrorDTO(String userIDError, String passwordError, String confirmError, String fullnameError, String roleError, String address, String phone, String balance) {
        this.userIDError = userIDError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.fullnameError = fullnameError;
        this.roleError = roleError;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
    }

 

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserErrorDTO() {
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public String getRoleError() {
        return roleError;
    }

}
