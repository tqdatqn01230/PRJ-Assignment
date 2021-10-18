/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.book;

import dattq.book.BookDTO;
import dattq.book.BookDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Dell
 */
public class test {
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        BookDAO dao=new BookDAO();
        //dao.changeQuantity("B001", 1);
        testdatabase();
    }
    public static void testdatabase() throws ClassNotFoundException, SQLException{
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE, 10);
        java.util.Date date1=calendar.getTime();
        Date date=new Date(date1.getTime());
        BookDAO dao=new BookDAO();
        List<BookDTO> list=dao.findBooksbyDay(date);
        for (BookDTO book:list){
            System.out.println(book.getBookName()+" "+book.getQuantity());
        }
    }
}
