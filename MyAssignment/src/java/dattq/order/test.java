/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.order;

import dattq.order.OrderDTO;
import dattq.order.OrderDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Dell
 */
public class test {
       public static void main(String args[]) throws  SQLException, ClassNotFoundException{
        java.util.Date date=new java.util.Date();
        Date borrowdate=new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE, 13);
        java.util.Date date1=calendar.getTime();
        OrderDTO order=new OrderDTO("O001","hung",120,"add","phone","email",borrowdate);
        OrderDAO dao=new OrderDAO();
        dao.AddnewOrder(order);
    }
}
