/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.book;

import dattq.cart.CartDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
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
public class BookDAO implements Serializable{
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
    public List<BookDTO> getBookList() throws ClassNotFoundException, SQLException{
        List<BookDTO> booklist=new ArrayList();
        try{
            conn=DButils.getConnection();
            String sql="SELECT B.BookID,B.BookName,B.Quantity,B.Price,B.Author, "
                    + " C.CategoryName FROM tblBooks B, tblCategory C\n" +
                        "WHERE B.CategoryID=C.CategoryID and B.Quantity<>0";
            stm=conn.prepareStatement(sql);
            rs=stm.executeQuery();
            while (rs.next()){
                BookDTO book =new BookDTO(rs.getString("bookID"),rs.getString("bookName"),
                        rs.getInt("quantity"),(Math.ceil(rs.getDouble("price") * 100) / 100),
                        rs.getString("Author"),rs.getString("CategoryName"));
                booklist.add(book);
            }
        }finally{
            CloseConnection();
        }
        return booklist;
    }
    public List<BookDTO> findBook(String name) throws ClassNotFoundException, SQLException{
        List<BookDTO> booklist=new ArrayList();
        try{
            conn=DButils.getConnection();
            String sql="SELECT * FROM tblBooks B,tblCategory C \n" +
                        "WHERE bookName Like ? AND B.categoryID=C.CategoryID and B.Quantity<>0";
            stm=conn.prepareStatement(sql);
            stm.setString(1,"%"+name+"%");
            rs=stm.executeQuery();
            while (rs.next()){
                BookDTO book =new BookDTO(rs.getString("bookID"),rs.getString("bookName"),
                        rs.getInt("quantity"),(Math.ceil(rs.getDouble("price") * 100) / 100),
                        rs.getString("author"),rs.getString("CategoryName"));
                booklist.add(book);
            }
        }finally{
            CloseConnection();
        }
        return booklist;
    }
    public BookDTO findBookbyID(String ID) throws ClassNotFoundException, SQLException{
        BookDTO book = null;
        try{
            conn=DButils.getConnection();
            String sql="SELECT * FROM tblBooks WHERE bookID Like ? ";
            stm=conn.prepareStatement(sql);
            stm.setString(1,"%"+ID+"%");
            rs=stm.executeQuery();
            while (rs.next()){
                 book =new BookDTO(rs.getString("bookID"),rs.getInt("quantity"));   
            }
        }finally{
            CloseConnection();
        }
        return book;
    }
    public boolean addBook(BookDTO book) throws ClassNotFoundException, SQLException{
        boolean check=false;
        try{
            conn=DButils.getConnection();
            String sql="INSERT INTO tblBooks VALUES(?,?,?,?,?)";
            stm=conn.prepareStatement(sql);
            stm.setString(1,book.getBookID());
            stm.setString(2,book.getBookName());
            stm.setInt(3, book.getQuantity());
            stm.setDouble(4,book.getPrice());
            int re=stm.executeUpdate();
            if (re>0){
                check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
    public boolean checkQuantity(CartDTO cart) throws ClassNotFoundException, SQLException{
        boolean check=true;
        try{
            BookDAO dao=new BookDAO();
            for(BookDTO bookcart:cart.getCart().values()){
                BookDTO book=dao.findBookbyID(bookcart.getBookID());
                if(book.getQuantity()<bookcart.getQuantity()){
                    check=false;
                    break;
                }
            }
        }finally{
        }
        return check;
    }
    public int getquantity(String ID) throws ClassNotFoundException, SQLException{
        int kq=0;
        try{
            conn=DButils.getConnection();
            String sql="SELECT quantity FROM tblBooks WHERE bookID =?";
            stm=conn.prepareStatement(sql);
            stm.setString(1, ID);
            rs=stm.executeQuery();
            if (rs.next()) kq=rs.getInt("quantity");
        }finally{
            CloseConnection();
        }
        return kq;
    }
    public boolean changeQuantity(String ID,int quan) throws ClassNotFoundException, SQLException{
        boolean check=false;
        try{
            int initialquan=getquantity(ID);
            conn=DButils.getConnection();
            String sql="UPDATE tblBooks SET quantity=? WHERE bookID=?";
            stm=conn.prepareStatement(sql);
            quan=initialquan-quan;
            stm.setInt(1, quan);
            stm.setString(2, ID);
            int re=stm.executeUpdate();
            if (re>0){
                check=true;
            }
        }finally{
            CloseConnection();
        }
        return check;
    }
     public List<BookDTO> findBooksbyDay(Date date) throws ClassNotFoundException, SQLException {
        List<BookDTO> list = new ArrayList();
        try {
            conn = DButils.getConnection();
            String sql = "SELECT * \n" +
                        " FROM (SELECT  B.bookID,B.BookName,B.price,B.author,C.CategoryName  \n" +
                        "       FROM  tblBooks B, tblCategory C WHERE B.CategoryID=C.CategoryID) B\n" +
                        " ,(SELECT D.quantity,D.bookID FROM tblOrders O, tblOrderDetails D \n" +
                        "   WHERE O.OrderID=D.orderID AND O.returndate>=?) O\n" +
                        " WHERE B.BookID = O.bookID";
            stm = conn.prepareStatement(sql);
            stm.setDate(1, date);
            rs = stm.executeQuery();
            while (rs.next()) {
                String bookID = rs.getString("BookID");
                String name = rs.getString("BookName");
                int quantity = rs.getInt("quantity");
                double price = (Math.ceil(rs.getDouble("price") * 100) / 100);
                String author = rs.getString("author");
                String category = rs.getString("categoryName");
                list.add(new BookDTO(bookID, name, quantity, price, author, category));
            }
        } finally {
            CloseConnection();
        }
        return list;
    }
}
