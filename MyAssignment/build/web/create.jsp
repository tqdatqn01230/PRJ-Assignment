<%-- 
    Document   : create
    Created on : May 12, 2021, 6:38:02 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dattq.user.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create account</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <header class="createaccountheader">
        <h1>Create a new Account</h1>
    </header>
    <body>
        
        <%UserErrorDTO error=(UserErrorDTO)session.getAttribute("Error"); 
            //UserErrorDTO error=(UserErrorDTO)request.getAttribute("Error");
        if (error==null){
            error=new UserErrorDTO("","","","","","","","");
        }%>
        <form action="MainController">
            Username<input type="text" name="userID"/><br/>
            <font color="red"><%=error.getUserIDError() %></font><br/>
            Password<input type="password" name="password"/><br>
            <font color="red"><%=error.getPasswordError() %></font><br/>
            Confirm<input type="password" name="confirm"><br/>
            <font color="red"><%=error.getConfirmError() %></font><br/>
            Full Name<input type="text" name="fullName"><br/>
            <font color="red"><%=error.getFullnameError() %></font> <br/>
            Address<input type="text" name="address" /><br/>
            <font color="red"><%=error.getAddress()%></font><br/>
            Phone<input type="text" name="phone" /><br/>
            <font color="red"><%=error.getPhone()%></font><br/>
            Email<input type="email" name="mail" /><br/>
            <input type="submit" name="Action" value="Create"/> 
        </form>
            <form action="login.jsp">
                <input type="submit" name="whaever" value="Back to login"/>
            </form>
    </body>
</html>
