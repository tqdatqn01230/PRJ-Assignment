/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.controllerAD;

import dattq.user.UserDAO;
import dattq.user.UserDTO;
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
public class UpdateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected final String ERROR="update.jsp";
    protected final String Success="SearchController";
    protected final String Successuser="LogoutController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        HttpSession session=request.getSession();
        UserErrorDTO error=new UserErrorDTO("","","","","","","","");
        try{
            boolean check=true;
            UserDTO updateuser=(UserDTO)session.getAttribute("updateuser");
            if (updateuser==null){
                String userid=request.getParameter("userID");
                String fullname=request.getParameter("fullName");
                String password=request.getParameter("password");
                String address=request.getParameter("address");
                String mail=request.getParameter("mail");
                String role=request.getParameter("roleID");
                String phone=request.getParameter("phone");
                double balance=Double.parseDouble(request.getParameter("balance"));
                updateuser=new UserDTO(userid, fullname, password, role, address, phone, mail, balance);
                session.setAttribute("updateuser",updateuser);
            }
            UserDTO user=(UserDTO)session.getAttribute("USER");
            String password=request.getParameter("password");
            String confirm= request.getParameter("confirm");
            String fullname=request.getParameter("fullName");
            String roleID=request.getParameter("roleID");
            String add=request.getParameter("address");
            String phone=request.getParameter("phone");
            String email=request.getParameter("mail");
            String bal=request.getParameter("balance");
            double balance;
            if(bal!="") balance=Double.parseDouble(bal);
            else balance=updateuser.getBalance();
            if(fullname.length()>50||fullname.length()<1){
                check= false;
                error.setFullnameError("Full name length must be in [1,50]");
            }
            //request.setAttribute("Error", error);
            if(!"AD".equals(roleID)&&!"User".equals(roleID)){
                check= false;
                error.setRoleError("Role must be AD or User");
            }
            if (password.length()<3||password.length()>15){
                check=false;
                error.setPasswordError("Password length must be in range[3,15]");
            }
            if(!confirm.equals(password)){
                check= false;
                error.setConfirmError("Password not match!!!");
            }
            if(add.length()<3||add.length()>150){
                check=false;
                error.setAddress("Address must be in length[3,150]");
            }
            if (phone.length()<3||phone.length()>15){
                check=false;
                error.setPhone("Phone length must be in range[3,15]");
            }
            if (email.length()==0){
                error.setBalance("Do not blank email");
            }
            UserDAO dao=new UserDAO(); 
            boolean checkdao=false;
            if (check) {
                checkdao=dao.updateUser(updateuser.getUserId(), password, fullname, roleID,add,phone,email,balance);
            }
            if (check&&checkdao){
                session.removeAttribute("updateuser");
                if (user.getUserId().equals(updateuser.getUserId())){
                    url=Successuser;
                }else{
                    url=Success;
                    request.setAttribute("updatemess", "Update success");
                }
            } else{
                request.setAttribute("Error", error);
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NullPointerException ex){
            
        }
        finally{
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
