/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.orderdetails;

import dattq.book.BookDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dattq.uitls.DButils;
import java.util.Random;
/**
 *
 * @author Dell
 */
public class OrderDetailsDAO implements Serializable{
    Connection conn=null;
    PreparedStatement stm=null;
    ResultSet rs=null;
    public void CloseConnection() throws SQLException{
        if (rs !=null) {
                rs.close();
            }
        if (stm!=null){
                stm.close();
            }
        if (conn!=null){
                conn.close();
            }  
    }
    public boolean addOrderDetail(OrderDetailsDTO order) throws ClassNotFoundException, SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            String sql="INSERT INTO tblOrderDetails(detailID,orderID,bookID,quantity,price,status) VALUES(?,?,?,?,?,?)";
            stm=conn.prepareStatement(sql);
            stm.setString(1,order.getDetailID());
            stm.setString(2,order.getOrderID());
            stm.setString(3,order.getBookID());
            stm.setDouble(5, order.getPrice());
            stm.setInt(4,order.getQuantity());
            stm.setString(6,order.getStatus());
            int re=stm.executeUpdate();
            if (re>0){
                check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
        public List<OrderDetailsDTO> getOrderDetailsThatNotRETURNList() throws ClassNotFoundException, SQLException{
        List<OrderDetailsDTO> list=new ArrayList();
        try{
            conn=DButils.getConnection();
            String sql="SELECT * FROM tblOrderDetails WHERE status like ?";
            stm=conn.prepareStatement(sql);
            stm.setString(1, "%Not Return%");
            rs=stm.executeQuery();
            while (rs.next()){
                OrderDetailsDTO od=new OrderDetailsDTO(rs.getString("detailID"),rs.getString("orderID"),
                                   rs.getString("bookID"),rs.getInt("Quantity"),rs.getDouble("price"),
                                    rs.getString("status"));
                list.add(od);
            }
        }finally{
            CloseConnection();
        }
        return list;
    }
    public boolean changeStatus(String orderID) throws ClassNotFoundException, SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            String sql="UPDATE tblOrderDetails SET status='Returned'  "
                    + "WHERE detailID=? ";
            stm=conn.prepareStatement(sql);
            stm.setString(1, orderID);
            int re=stm.executeUpdate();
            if (re>0){
                check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
    public static String GetOrderID(){
        Random random=new Random();
        String xau="0123456789";String res="0";
        for (int i=0;i<=5;i++){
            res+=xau.charAt(random.nextInt(10));
        }
        return res;
    }
}
