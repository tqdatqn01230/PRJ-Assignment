<%-- 
    Document   : ChangeSuccess
    Created on : Jun 17, 2021, 11:17:06 AM
    Author     : Dell
--%>

<%@page import="dattq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Success</title>
    </head>
    <body>
        <%UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }%>
        <form action="MainController">
            <input type="submit" name="Action" value="Back to Shopping" />
            <input type="submit" name="Action" value="Back to Confirm Order"/>
        </form>
    </body>
</html>
