    <%-- 
    Document   : search
    Created on : May 10, 2021, 4:36:11 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.List" %>
<%@page import ="dattq.user.UserDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${sessionScope.USER.fullName}</title>
         <link rel="stylesheet" href="mycss.css">   
    </head>
    <header class="searchheader">
        <h1>Hello ${sessionScope.USER.fullName}</h1>
        <form class="logout" action="MainController">
            <input type="submit" value="Logout" name="Action"/>
        </form>
    </header>
    <body class="searchbody">
        
        
        <%
            UserDTO user=(UserDTO)session.getAttribute("USER");//request.getAttribute("");
            if (user==null||!user.getRole().equals("AD")){
                response.sendRedirect("login.jsp");
                return;
            }
            String searchvalue=request.getParameter("Search");
            if (searchvalue==null) searchvalue="";
        %>
        <section class="search">
        <form action="MainController">
            <input type="text" name="Search" value="<%=searchvalue%>">
            <input type="submit" name="Action" value="Search"/>
        </form>
            <%String mess=(String) request.getAttribute("updatemess"); 
            if (mess==null) mess="";%>
            <h2><%=mess%></h2>
        <%
            List<UserDTO> list= (List<UserDTO>)request.getAttribute("ListUser");
            if (list!=null){
                int count=1;
                if (list.size()!=0){
        %>
        <table border="1" class="table">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full Name</th>
                    <th>Role</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <%  for (UserDTO dto:list){
            %>
            <tbody>
                
                <tr>
                    <form action="MainController">
                    <td><%=count++%></td>
                    <td><input class="td" type="text" value="<%=dto.getUserId()%>" name="userID" readonly/> </td>
                    <td><input class="td" type="text" value="<%=dto.getPassword()%>" name="password"readonly></td>
                    <td><input class="td" type="text" value="<%=dto.getFullName()%>" name="fullName" readonly/> </td>
                    <td><input class="td" type="text" value="<%=dto.getRole()%>" name="roleID" readonly></td>
                    <input type="text" value="<%=dto.getEmail()%>" name="mail" hidden>
                    <input type="text" value="<%=dto.getPhone()%>" name="phone" hidden>
                    <input type="text" value="<%=dto.getAddress() %>" name="address" hidden>
                    <input type="text" value="<%=dto.getBalance()%>" name="balance" hidden>
                    <td><input class="tbutton" type="submit" name="Action" value="Delete" /></td>
                    <td><input class="tbutton" type="submit" name="Action"value="Update"/></td>
                    <input type="hidden" name="Search" value="<%=searchvalue%>">
                    </form>
                </tr>
            </tbody>
            <%}%>
        </table>
            <%String error= (String)request.getAttribute("Errordelete");
            if (error!=null){ %>
            <b><%=error%></b>
            <% }%>
        <%  }else{%>
        <h1>There's no match</h1>
        <%}}%>
        </section>
    </body>
</html>
