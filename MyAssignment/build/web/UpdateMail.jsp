<%-- 
    Document   : UpdateCode
    Created on : Jun 17, 2021, 7:56:15 PM
    Author     : Dell
--%>

<%@page import="dattq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Code</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <header class='updatemailheader'><h1>Update your Email</h1></header>
    <body>
        <%UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }
        String num=request.getParameter("Total");
        if(num!=null) {double total=Double.parseDouble(num);
        session.setAttribute("Total", total);} %>
        
        Your Email: <%=user.getEmail()%>
        <form action="MainController">
            Wanna change?<input type="email" name="mail">
            <% String mess=(String) request.getAttribute("Mess");
            if (mess==null) mess=""; %>
            <p><font color="red"> <%=mess%></font><p>
            <input type="submit" name="Action2" value="Change">
            <input type="submit" name="Action2" value="Confirm Mail">           
        </form>
        
    </body>
</html>
