<%-- 
    Document   : ChangeInformation
    Created on : Jun 17, 2021, 9:45:18 AM
    Author     : Dell
--%>

<%@page import="dattq.user.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Information</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <body>
        <h2>${sessionScope.USER.fullName }</h2>
        <h1> <font Color="red"> Change your information</font></h1>
        <%UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }
        UserErrorDTO error=(UserErrorDTO)request.getAttribute("Error");
        if (error==null) error=new UserErrorDTO("","","","","","","","");%>
        <form action="MainController">
            Full name: <input type="text" name="fullName" value='${sessionScope.USER.fullName}'><br/>
            <font color="red"><%=error.getAddress() %></font><br/>
            Address: <input type="text" name="address" value='${sessionScope.USER.address}'><br/>
            <font color="red"><%=error.getAddress() %></font><br/>
            Phone: <input type="text" name="phone" value='${sessionScope.USER.phone}'><br/>
            <font color="red"><%=error.getPhone() %></font><br/>
            Email: <input type="email" name="mail"value='${sessionScope.USER.email}'><br/>
            <font color="red"><%=error.getBalance()%></font><br/>
            <input type="submit" name="Action" value="Change">
            <input type="submit" name="Action" value="Back to Confirm Order"/>
        </form>
        <%String mess=(String)request.getAttribute("mess");
            if (mess==null) mess="";
            %>
        <h2><font color='red'><%=mess%> </font></h2>
    </body>
</html>
