package dattq.controllerUser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import dattq.user.UserDAO;
import dattq.user.UserErrorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class CreateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected final String ERROR="create.jsp";
    protected final String SUCCESS="createsuccess.html";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        UserErrorDTO error=new UserErrorDTO("","","","","","","","");
        HttpSession session=request.getSession();
        try{
            boolean check=false;
            String userID= request.getParameter("userID");
            String fullname= request.getParameter("fullName");
            String password= request.getParameter("password");
            String confirm= request.getParameter("confirm");
            String address=request.getParameter("address");
            String phone=request.getParameter("phone");
            String mail=request.getParameter("mail");
            /*if (userID==null) userID="";
            if (fullname==null) fullname="";
            if (roleID==null) roleID="";
            if (password==null) password="";
            if (confirm==null) confirm="";*/
            if(userID.length()<3 || userID.length()>15){
                check= true;
                error.setUserIDError("Username length must be in range [3,15]");
            }
            if(fullname.length()>50||fullname.length()<1){
                check= true;
                error.setFullnameError("Full name length must be in [1,50]");
            }
            //request.setAttribute("Error", error);
            if (password.length()<1||password.length()>15){
                check=true;
                error.setPasswordError("Password length must be in range[1,15]");
            }
            if(!confirm.equals(password)){
                check= true;
                error.setConfirmError("Password not match!!!");
            }
            if (address.length()<2||address.length()>150){
                check=true;
                error.setAddress("Address must be in length [2,150]");
            }
            if (phone.length()<3||phone.length()>15){
                check=true;
                error.setPhone("Phone must be in length [3,15]");
            }
            UserDAO dao=new UserDAO();
            boolean checkdup=dao.checkDup(userID);
            if (check||checkdup) {
                if(checkdup) error.setUserIDError("duplicate Username");
                //request.setAttribute("Error", error);
                session.setAttribute("Error", error);
            }else{
                dao.createUser(userID, password, fullname, "User",address,phone,mail);
                url=SUCCESS;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
            System.out.println("exception");
        }
        finally{
            response.sendRedirect(url);
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
