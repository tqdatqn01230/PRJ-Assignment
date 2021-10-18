<%-- 
    Document   : ConfirmCode
    Created on : Jun 17, 2021, 7:26:24 PM
    Author     : Dell
--%>

<%@page import="dattq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="mycss.css">
        <title>Confirm your email</title>
    </head>
    <body>
        <%UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }%>
            <form action="MainController">
                Verify Code <input type="text" name="code">
                <input type="submit" name="Action2" value="Confirm">
            </form>
            <%String mess=(String)request.getAttribute("Mess");
            if (mess==null) mess="";%>
            <p><font color="red"><%=mess%> </font></p>>
    </body>
</html>
