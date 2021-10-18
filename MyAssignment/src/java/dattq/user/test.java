/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.user;

import dattq.user.UserDAO;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class test {
    public static void main(String [] args) throws SQLException, ClassNotFoundException{
        UserDAO dao=new UserDAO();
        System.out.println(dao.createUser("dat1", "123","Dat trinh", "AD", "SomeWhere","0123321312", "email@gmail.com"));
    }
}
