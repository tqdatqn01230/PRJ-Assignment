/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.controllerUser;

import dattq.support.Random;
import dattq.support.Time;
import dattq.orderdetails.OrderDetailsDTO;
import dattq.orderdetails.OrderDetailsDAO;
import dattq.order.OrderDTO;
import dattq.order.OrderDAO;
import dattq.book.BookDAO;
import dattq.book.BookDTO;
import dattq.cart.CartDTO;
import dattq.order.OrderErrorDTO;
import dattq.user.UserDAO;
import dattq.user.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "ConfirmOrderController1", urlPatterns = {"/ConfirmOrderController1"})
public class ConfirmOrderController1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "ConfirmSuccess.jsp";
        try {
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("USER");
            double total = (double) session.getAttribute("Total");
            CartDTO cart=(CartDTO) session.getAttribute("Cart");
            Random ran=new Random();
            String orderID=ran.GetOrderID();
            Time timesp=new Time();
            Date curdate=timesp.getCurrentDate();     
            OrderDTO order=new OrderDTO(orderID,user.getUserId(),total,user.getAddress(),user.getPhone(),
                                       user.getEmail(),curdate);
            OrderDAO dao= new OrderDAO();
            dao.AddnewOrder(order);
            OrderDetailsDAO dao1=new OrderDetailsDAO();
            BookDAO dao2=new BookDAO();
            for (BookDTO book: cart.getCart().values()){
                String ID=ran.GetOrderDetailsID();
                OrderDetailsDTO orderde=new OrderDetailsDTO(ID,orderID,book.getBookID(),book.getQuantity(),
                                            book.getPrice(),"Not Deliveried");
                dao1.addOrderDetail(orderde);
                dao2.changeQuantity(book.getBookID(), book.getQuantity());
            }
            UserDAO userdao=new UserDAO();
            double newbalance=user.getBalance()-total;
            userdao.UpdateBalance(user.getUserId(), newbalance);
            user.setBalance(newbalance);
            session.setAttribute("USER", user);
            session.removeAttribute("Cart");
            session.removeAttribute("Total");
        } catch (NullPointerException ex) {
            Logger.getLogger(ConfirmOrderController1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmOrderController1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfirmOrderController1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
