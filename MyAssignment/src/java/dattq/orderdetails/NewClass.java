/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.orderdetails;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class NewClass {
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        Date date=new Date();
        java.sql.Date sql=new java.sql.Date(date.getTime());
        OrderDetailsDTO orderde=new OrderDetailsDTO("D002","O001","B002",1,150,"Not yet deliveried");
        OrderDetailsDAO dao = new OrderDetailsDAO();
        dao.addOrderDetail(orderde);
    }
}
