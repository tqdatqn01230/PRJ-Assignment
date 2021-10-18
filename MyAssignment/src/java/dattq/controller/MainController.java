/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dattq.controller;

import dattq.cart.CartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected final String ERROR="error.jsp";
    protected final String LOGIN="LoginController";
    protected final String LOGOUT="LogoutController";
    protected final String SEARCH="SearchController";
    protected final String CREATE="CreateController";
    protected final String DELETE="DeleteController";
    protected final String UPDATE="UpdateController";
    protected final String ADDCART="AddCartController";
    protected final String VIEW="viewCart.jsp";
    protected final String EDITCART="EditCartController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try{
            HttpSession session=request.getSession();
            CartDTO cart=(CartDTO) session.getAttribute("Cart");
            String action=request.getParameter("Action");
            if (action==null) action="";
            if (action.equals("Login")) {
                url=LOGIN;
            }
            else if ("Logout".equals(action)) {
                url=LOGOUT;
            }else if ("Search".equals(action)){
                url=SEARCH;
            }else if("Back to Search".equals(action)){
                url=SEARCH;
                session.removeAttribute("updateuser");
            }else if("Create".equals(action)){
                url=CREATE;
            }else if ("Delete".equals(action)){
                url=DELETE;
            }else if ("Update".equals(action)){
                url=UPDATE;
            }else if ("Add".equals(action)){
                url=ADDCART;
            }else if ("View your Cart".equals(action)||"Back to view cart".equals(action)){
                url=VIEW;
            }else if ("Edit".equals(action)){
                url=EDITCART;
            }else if("Search Book".equals(action)){
                
                url="SearchBookController"; 
            }else if("Remove".equals(action)){
                
                url="RemoveCartController";
            }else if("Back to Shopping".equals(action)){
                
                url="ShoppingCartController";
            }else if("Confirm Order".equals(action)){
                
                url="ConfirmOrderController";
            }else if ("Confirm Order by Gmail".equals(action)){
                
                url="UpdateMail.jsp";
            }else if("Top up".equals(action)){
                
                url="Topup.jsp";
            }else if ("Confirm Top Up".equals(action)){
                
                url="TopupController";
            }else if ("Change Information".equals(action)){
                url="ChangeInformation.jsp";
            }else if("Change".equals(action)){
                url="ChangeInformationController1";
            }else if ("Back to Confirm Order".equals(action)){
                url="ConfirmOrder.jsp";
            }else if("Confirm".equals(action)){
                url="ConfirmOrderController1";
            }
            else {                
                session.setAttribute("Error_Name", "Functioned is not supported");
            }
                String action2=request.getParameter("Action2");
            if ("Confirm Mail".equals(action2)){
                url="ConfirmOrderbyMailController";
            }else if("Change".equals(action2)){
                url="ChangeMailController";
            }else if ("Confirm".equals(action2)){
                url="ConfirmCodeController";
            }
            else{
                session.setAttribute("Error_Name", "Functioned is not supported");
            }
        }catch (Exception e){       
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
