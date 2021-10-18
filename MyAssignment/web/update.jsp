
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dattq.user.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update account</title>
        <link rel="stylesheet" href="mycss.css"> 
    </head>
    <header class="updateheader"><h1>Update account ID: ${sessionScope.updateuser.userId }</h1></header>
    <body>
        
        
        <%
            UserDTO user=(UserDTO)session.getAttribute("USER");//request.getAttribute("");
            if (user==null||!user.getRole().equals("AD")){
                response.sendRedirect("login.jsp");
                return;
            }
            request.removeAttribute("ListUser");
            UserDTO user1=(UserDTO)session.getAttribute("updateuser");
            UserErrorDTO error=(UserErrorDTO)request.getAttribute("Error");
            if (error==null){
                error=new UserErrorDTO("","","","","","","","");
        }%>
        <section class="update">
        <form action="MainController">
            Password<input type="password" name="password"/><br>
            <%=error.getPasswordError() %><br/>
            Confirm<input type="password" name="confirm"><br/>
            <%=error.getConfirmError() %><br/>
            Full Name<input type="text" name="fullName" value="<%=user1.getFullName()%>"><br>
            <%=error.getFullnameError() %> <br/>
            Role <input type="text" name="roleID" value="<%=user1.getRole() %>"><br/>
            <%=error.getRoleError() %><br/> 
            Address <input type="text" name="address" value="<%=user1.getAddress() %>"><br/>
            <%=error.getAddress()%><br/>
            Phone <input type="text" name="phone"value="<%=user1.getPhone() %>"><br/>
            <%=error.getPhone() %><br/>
            Email<input type="email" name="mail" value="<%=user1.getEmail() %>"/><br/>
            <%=error.getBalance() %><br>
            Balance <input type="number" name="balance" min="0" step="0.01" value="<%=user1.getBalance() %>"><br/>
            <input type="submit" name="Action" value="Update"/> 
        </form>
            <form action="MainController">
                <input type="submit" name="Action" value="Back to Search"/>
            </form>
        </section>
    </body>
</html>
