/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.controllerUser;

import dattq.user.UserDAO;
import dattq.user.UserDTO;
import dattq.user.UserErrorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "ChangeInformationController1", urlPatterns = {"/ChangeInformationController1"})
public class ChangeInformationController1 extends HttpServlet {

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
        HttpSession session=request.getSession();
        UserErrorDTO error=new UserErrorDTO("","","","","","","","");
        String url="ChangeInformation.jsp";
        UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }
        try{
            String add=request.getParameter("address");
            String phone=request.getParameter("phone");
            String mail=request.getParameter("mail");
            String fullname=request.getParameter("fullName");
            boolean check=true;
            if (fullname.length()<1||fullname.length()>50){
                check=false;
                error.setFullnameError("Full must be in length[1,50]");
            }
            if (add.length()<1||add.length()>150){
                check=false;
                error.setAddress("Address must be in length[1,150]");
            }
            phone=phone.trim();
            if (phone.length()<3||phone.length()>15){
                check=false;
                error.setPhone("Phone must be in length[3,15]");
            }
            if (mail.length()==0){
                check=false;
                error.setAddress("please enter mail");
            }
            if (check){
                UserDAO dao=new UserDAO();
                dao.UpdateInfo(user.getUserId(), fullname,add, phone, mail);
                user.setFullName(fullname);
                user.setAddress(add);
                user.setPhone(phone);
                user.setEmail(mail);
                session.setAttribute("USER", user);
                request.setAttribute("mess", "Change Info Success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChangeInformationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangeInformationController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
