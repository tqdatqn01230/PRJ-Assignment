<%-- 
    Document   : ConfirmSucess
    Created on : Jun 14, 2021, 10:06:40 PM
    Author     : Dell
--%>

<%@page import="dattq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="mycss.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Success</title>
    </head>
    <body>
        <%UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }%>
        <h1>Order Confirmed</h1>
        <form action="MainController">     
            <input type="submit" name="Action" value="Back to Shopping">
        </form>
    </body>
</html>
