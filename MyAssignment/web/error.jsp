<%-- 
    Document   : error
    Created on : Jun 3, 2021, 3:40:05 PM
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
        <h1>Error:<%=session.getAttribute("Error_Name") %></h1>
    </body>
</html>
