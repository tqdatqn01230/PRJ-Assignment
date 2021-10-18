<%-- 
    Document   : ConfirmOrder
    Created on : Jun 16, 2021, 9:44:54 PM
    Author     : Dell
--%>

<%@page import="dattq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Order</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <body>
        <%UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }%>
            <h1> <font color="red">Confirm your information</font></h1>
        <h2>FullName:${sessionScope.USER.fullName}</h2>
        <h2>Address:${sessionScope.USER.address}</h2>
        <h2>Phone: ${sessionScope.USER.phone}</h2>
        <h2>Email: ${sessionScope.USER.email}</h2>
        <form action="MainController">
           <input type="submit" name="Action" value="Confirm" />
            <input type="submit" name="Action" value="Change Information"/>
            <input type="submit" name="Action" value="Back to Shopping">
        </form>
    </body>
</html>
