/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.order;

import dattq.book.BookDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import dattq.uitls.DButils;

/**
 *
 * @author Dell
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public void CloseConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean AddnewOrder(OrderDTO order) throws SQLException, ClassNotFoundException, NullPointerException {
        boolean check = false;
        try {
            conn = DButils.getConnection();
            String sql = "INSERT INTO tblOrders(orderID, userID, total,address,phone,email,buydate)"
                    + " VALUES(?,?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, order.getOrderID());
            stm.setString(2, order.getUserID());
            stm.setDouble(3, order.getTotal());
            stm.setString(4,order.getAddress());
            stm.setString(5, order.getPhone());
            stm.setString(6, order.getEmail());
            stm.setDate(7, order.getBuydate());
            int rowseffect = stm.executeUpdate();
            if (rowseffect > 0) {
                check = true;
            }
        } finally {
            CloseConnection();
        }
        return check;
    }

  
}
