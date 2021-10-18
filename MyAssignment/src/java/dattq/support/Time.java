/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.support;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Dell
 */
public class Time {
    Calendar calendar = Calendar.getInstance();
    public Date getCurrentDate() {
        java.util.Date date;
        date = calendar.getTime();
        java.sql.Date datesql = new java.sql.Date(date.getTime());
        return datesql;
    }
    public Date getReturnDate(){    
        calendar.add(Calendar.DATE, 13);
        java.util.Date date = new java.util.Date();
        date = calendar.getTime();
        java.sql.Date datesql = new java.sql.Date(date.getTime());
        return datesql;
    }
}
