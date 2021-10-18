<%-- 
    Document   : Login
    Created on : Jun 8, 2021, 5:49:40 PM
    Author     : Dell
--%>

<%@page import="dattq.user.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mycss.css">
    </head>
    <header class="loginheader">
        <h1>
            <font color = "blue">
                Login Page
            </font>
        </h1>
    </header>
    <body>
        <% UserDTO user=(UserDTO) session.getAttribute("USER");
            if(user!=null){
               if( "AD".equals(user.getRole())) {
                   response.sendRedirect("search.jsp");
                   return;
               }else{
                   response.sendRedirect("shoppingcart.jsp");
                   return;
               }
    }%>
        <section class="login">
        <form action="MainController" method="get"/>
            UserName<input type="text" name="UserID"/><br/>
            Password<input type="password" name="password"/><br>
            <input type="submit" name="Action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Assignment-SE150059/LoginGoogleController&response_type=code&client_id=320372249105-n9lqj4retbe65vf3coa4go6q6e6jca0i.apps.googleusercontent.com&approval_prompt=force">
            Login With Google</a> 
        <form action="MainController" method="Post">
            <input type="submit" name="Action" value="Create"/><br/>
        </form>
        <% String error=(String)session.getAttribute("LoginError"); 
           if (error==null) error="";%>
           <p>
               <font color="red">
               <%=error%>
               </font>
           </p> 
        </section>
    </body>
    <footer>
        <p>Contact us:</p> 
        <a  href="https://www.facebook.com/dattq123/"> <img class="facebooklogo" src="pic/facebook_logo.png" alt="facebook logo"> </a> 
        <a href="https://www.instagram.com/lktblackcat/"><img class="instalogo" src="pic/Instagram_logo.png"></a> 
    </footer>
</html>
