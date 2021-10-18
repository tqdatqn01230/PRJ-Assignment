<%-- 
    Document   : shoppingcart
    Created on : Jun 3, 2021, 3:48:03 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="dattq.book.BookDTO" %>
<%@page import="dattq.user.UserDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="mycss.css">
        <% UserDTO user=(UserDTO)session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }
        String searchvalue=request.getParameter("Search");
            if (searchvalue==null) searchvalue="";
              %>
    </head>
    <header> 
         <h1> 
          
            <font color="blue">
            Welcome ${sessionScope.USER.fullName}
            </font>
        </h1>
        <h2>Your balance: <%=user.getBalance()%></h2>
        <form action="MainController">
            <input type="submit" name="Action" value="Top up"> 
        </form>
    </header>
    <body>
        
        <h1>
            <font color="red">
                BOOK STORE
            </font>
        </h1>
        <form action="MainController">
            <input type="submit" value="Logout" name="Action"/>
        </form> 
        <form action="MainController">
                <input type="submit" name="Action" value="View your Cart">
            </form>
        <form action="MainController">
            <input type="text" name="Search" value="<%=searchvalue%>">
            <input type="submit" name="Action" value="Search Book"/>
        </form>
        <% List<BookDTO> list=(List<BookDTO>) request.getAttribute("BookList");
               if (list!=null){
                   int count=1;
                   if (list.size()!=0){ 
            %>
       
            <table border='1' class="table">
                <thead>
                <tr>
                    <th>No</th>
                    <th>BookID</th>
                    <th>BookName</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Add</th>     
                </tr>
                </thead>
                 <tbody>
                <%for (BookDTO book:list){%>
                <tr>
                <form action="MainController">
                    <td><%=count++%></td>
                    <td><input type="text" value="<%=book.getBookID() %>" name="bookID" readonly class="td"/> </td>
                    <td><input type="text" value="<%=book.getBookName() %>" name="bookname"readonly class="td"></td>
                    <td><input type="text" value="<%=book.getAuthor() %>" name="author" readonly class="td"></td> 
                    <td><input type="text" value="<%=book.getCategoryID()%>" name="category" readonly class="td"/>
                     <td><input type="text" value="<%=book.getQuantity() %>" name="quantity" readonly class="td"/> </td>
                    <td><input type="text" value="<%=book.getPrice() %>" name="price" readonly class="td"></td>
                    <td><input type="submit" name="Action" value="Add" /></td>
                    </form>
                </tr>
                <% } %>
                </tbody>
            </table>
                <% }else{%>
                    <h1>There's no match</h1>
                    <%} }  %>
    </body>
</html>
