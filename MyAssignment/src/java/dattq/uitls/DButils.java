/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.uitls;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Dell
 */
public class DButils implements Serializable{
     public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=BookStore";
        conn=DriverManager.getConnection(url,"dattq", "123");
        return conn;
    }
    public static Connection getConnection1() throws NamingException, SQLException {
        Connection conn=null;
        Context context=new InitialContext();
        Context tomcatContext= (Context) context.lookup("java:comp/env");
        DataSource ds=  (DataSource) tomcatContext.lookup("Database");
        conn=ds.getConnection();
        return conn;
    }
}
