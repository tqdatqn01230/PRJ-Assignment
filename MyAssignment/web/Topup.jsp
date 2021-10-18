<%-- 
    Document   : Topup
    Created on : Jun 16, 2021, 11:03:40 PM
    Author     : Dell
--%>

<%@page import="dattq.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Top up</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <header>
        <h1> 
            <font color="blue">
            ${sessionScope.USER.fullName}
            </font>
        </h1>
        <h1><font color="red">
            Top up
            </font></h1>
    </header>
    <body>
        <%  UserDTO user=(UserDTO) session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }%>
            <h2>Your Balance:${sessionScope.USER.balance}</h2>
            <form action="MainController">
                Enter the amount:<input type="number" name="TopUpBalance" min="0" step="0.01" >
                <input type="submit" name="Action" value="Confirm Top Up"/>
                <input type="submit" name="Action" value="Back to Shopping"/>
                <input type="submit" name="Action" value="Back to view cart" />
            </form>
            <%String mess=(String)request.getAttribute("Mess");
            if (mess==null) mess="";%>
            <h2><font color="red"> <%=mess%></font></h2>
    </body>
</html>
