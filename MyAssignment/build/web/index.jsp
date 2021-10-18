<%-- 
    Document   : index.jsp
    Created on : May 27, 2021, 11:36:32 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Welcome <%=request.getAttribute("name")%></h1>
        <h1>ID: <%=request.getAttribute("id") %></h1>
        <h1>Mail: <%=request.getAttribute("email") %></h1>
    </body>
</html>
