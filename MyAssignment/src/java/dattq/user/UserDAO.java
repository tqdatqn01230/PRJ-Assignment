/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dattq.uitls.DButils;
/**
 *
 * @author Dell
 */
public class UserDAO implements Serializable{
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
    public UserDTO checkLogin(String username,String password) throws ClassNotFoundException, SQLException{
        UserDTO res=null;
        try{
            conn=DButils.getConnection();
            if (conn!=null){ 
                String sql="SELECT * FROM tblUsers WHERE userID = ? AND password = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs=stm.executeQuery();
                if (rs.next()){
                    res=new UserDTO(rs.getString("userID"),rs.getString("fullName")
                            ,"***",rs.getString("roleID"),rs.getString("address"),
                             rs.getString("phone"),rs.getString("email"),rs.getDouble("account balance"));
                    } 
                }
        }catch (Exception e){
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public List<UserDTO> getListUser(String search) throws SQLException, ClassNotFoundException{
        List<UserDTO> res=new ArrayList(); 
        if (search==null) return null;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="SELECT * FROM tblUsers WHERE fullName like ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,"%"+search+"%");
                rs=stm.executeQuery();
                while (rs.next()){
                    res.add(new UserDTO(rs.getString("userID"),rs.getString("fullName"),
                            rs.getString("password"),rs.getString("RoleID"),rs.getString("address"),
                            rs.getString("phone"),rs.getString("email"),rs.getDouble("account balance")) );
                }
            }
        }catch (SQLException e){        
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public UserDTO getUser(String ID) throws SQLException, ClassNotFoundException{
        UserDTO res=null; 
        if (ID==null) return null;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="SELECT * FROM tblUsers WHERE userID = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,ID);
                rs=stm.executeQuery();
                while (rs.next()){
                    res=new UserDTO(rs.getString("userID"),rs.getString("fullName"),
                            rs.getString("password"),rs.getString("RoleID"),rs.getString("address"),
                            rs.getString("phone"),rs.getString("email"),rs.getDouble("account balance"));
                }
            }
        }catch (SQLException e){        
        }
        finally{
            CloseConnection();
        }
        return res;
    }
    public boolean deleteUser(String id) throws ClassNotFoundException, SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="DELETE FROM tblUsers "
                        + " WHERE UserID = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,id);
                int rowEffect=stm.executeUpdate();
                if (rowEffect>0){
                    check=true;
                }
            }
        }catch(Exception e){
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean updateUser(String id,String pass,String fullname,String role,String address,String phone,String email,double balance) 
            throws SQLException, ClassNotFoundException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="UPDATE tblUsers "
                        +" SET fullName = ?, password= ?, roleID=?, address=?,phone=?,email=?,[account balance]=?"
                        + " WHERE UserID = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(8,id);
                stm.setString(1,fullname);
                stm.setString(2, pass);
                stm.setString(3, role);
                stm.setString(4, address );
                stm.setString(5, phone);
                stm.setString(6, email);
                stm.setDouble(7, balance);
                int rowEffect=stm.executeUpdate();
                if (rowEffect>0){
                    check=true;
                }
            }
        }catch(Exception e){
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean checkDup(String id) throws SQLException, ClassNotFoundException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql="SELECT * "
                        +" FROM tblUsers"
                        + " WHERE UserID = ?";
                stm=conn.prepareStatement(sql);
                stm.setString(1,id);
                rs=stm.executeQuery();
                if (rs.next()){
                    check=true;
                }
            }
        }catch(Exception e){
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean createUser(String id,String pass,String fullname,String role,String address,String phone,String email) 
            throws SQLException, ClassNotFoundException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql= "INSERT INTO tblUsers(userID,password,fullName,roleID,address,phone,email,[account balance])"
                        +" VALUES (?,?,?,?,?,?,?,?)";
                stm=conn.prepareStatement(sql);
                stm.setString(1,id);
                stm.setString(3,fullname);
                stm.setString(2, pass);
                stm.setString(4, role);
                stm.setString(5, address);
                stm.setString(6, phone);
                stm.setString(7, email);
                stm.setDouble(8,0);
                int rowEffect=stm.executeUpdate();
                if (rowEffect>0){
                    check=true;
                }
            }
        }catch(Exception e){
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean UpdateBalance(String id,double newbalance) 
            throws SQLException, ClassNotFoundException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql= "UPDATE tblUsers SET [account balance]=? WHERE userID=?";
                stm=conn.prepareStatement(sql);
                stm.setString(2,id);
                stm.setDouble(1, newbalance);
                int rowEffect=stm.executeUpdate();
                if (rowEffect>0){
                    check=true;
                }
            }
        }catch(Exception e){
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean UpdateInfo(String id,String fullname,String add,String phone,String mail) 
            throws SQLException, ClassNotFoundException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            if (conn!=null){
                String sql= "UPDATE tblUsers SET address=?,phone=?,email=?,fullname=?"
                        +" WHERE userID=?";
                stm=conn.prepareStatement(sql);
                stm.setString(5,id);
                stm.setString(1, add);
                stm.setString(2, phone);
                stm.setString(3, mail);
                stm.setString(4, fullname);
                int rowEffect=stm.executeUpdate();
                if (rowEffect>0){
                    check=true;
                }
            }
        }catch(Exception e){
        }finally{
            CloseConnection();
        }
        return check;
    }
}
