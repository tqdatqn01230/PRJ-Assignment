<%-- 
    Document   : ConfirmOrder
    Created on : Jun 12, 2021, 1:05:26 AM
    Author     : Dell
--%>

<%@page import="dattq.order.OrderErrorDTO"%>
<%@page import="dattq.user.UserDTO"%>
<%@page import="dattq.cart.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change your Information</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <body>
        <h1><font color="Blue"> Confirm Your Order</font></h1>
        <%  UserDTO user=(UserDTO) session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }
        CartDTO cart=(CartDTO)session.getAttribute("Cart");
        OrderErrorDTO error= (OrderErrorDTO) request.getAttribute("Error");
        if (error==null) error=new OrderErrorDTO("","", "");
        %>
        <h2>Your Information</h2>
        <form action="MainController">
            Full name<input type="text" name="fullname"/><br/>
            <%=error.getFullName() %><br/>
            Address<input type="text" name="Address"/><br>
            <%=error.getAddress() %><br/>
            Phone <input type="text" name="phone"><br/>
            <%=error.getPhone()%><br/> 
            <input type="submit" name="Action" value="Confirm"/> 
        </form>
    </body>
</html>
