<%-- 
    Document   : viewCart
    Created on : Jun 11, 2021, 8:10:04 PM
    Author     : Dell
--%>
<%@page import="dattq.cart.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dattq.user.UserDTO " %>
<%@page import="java.util.*" %>
<%@page import="dattq.book.BookDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Your Cart</title>
        <link rel="stylesheet" href="mycss.css">
    </head>
    <header>
        <h1> 
            <font color="blue">
            ${sessionScope.USER.fullName}
            </font>
        </h1>
        <h1><font color="red">
            Your Cart
            </font></h1>
    </header>
    <body>
        
        <h2>Your Balance: ${sessionScope.USER.balance }</h2>
        <%  UserDTO user=(UserDTO) session.getAttribute("USER");
            if (user==null||"AD".equals(user.getRole())){
               response.sendRedirect("login.jsp");
               return;
            }
               CartDTO list=(CartDTO) session.getAttribute("Cart");
               double total=0;
                if (list!=null){
                if (list.getCart().values().size()!=0){
                   int count=1;
                   total=0; 
            %>
            <table  class="table" border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                       <th>Book ID</th>
                        <th>Book Name</th>
                        <th> Author</th>
                       <th>Quantity</th>
                       <th>Price</th>
                       <th>Total</th>
                       <th>Remove</th>
                      <th>Update</th>
                    </tr>  
                </thead>
                <tbody>
                    <%for(BookDTO book: list.getCart().values() ){ %>
                        <tr>
                            <form action="MainController">
                                <td> <%=count++%></td>
                                <td><input type="text" value="<%=book.getBookID() %>" name="bookID" readonly class='td'/> </td>
                                <td><input type="text" value="<%=book.getBookName() %>" name="bookname"readonly class='td'></td>
                                <td><input type="text" value="<%=book.getAuthor() %>" name="author" readonly class='td'></td> 
                                <td><input type="number" value="<%=book.getQuantity() %>" name="quantity" min="1" class='td'/> </td>
                                <td><input type="text" value="<%=book.getPrice()%>" name="price"class='td'  readonly></td>
                                <td> <%=book.getPrice()*book.getQuantity()%></td>
                                <td><input type="submit" name="Action" value="Remove" ></td>
                                <td><input type="submit" name="Action" value="Edit" ></td>
                                <%total+=book.getPrice()*book.getQuantity();%>
                            </form>
                        </tr>
                    <% } %>
                </tbody>
            </table>
              
                <h1>Total: <%=total%></h1> 
                <% }} 
                if (list==null||list.getCart().values().size()==0){%> 
                    <h1>Your cart is empty</h1>
                <% }String mess=(String) session.getAttribute("NotEnough_Mess"); 
                    String mess2=(String)session.getAttribute("Money_Mess");
                if (mess==null) mess=""; 
                if (mess2==null) mess2=""; %>
                <h1><font color="red"> <%=mess%></font> </h1> 
                <h1><font color="red"> <%=mess2%></font> </h1>  
                <%if(list!=null&&list.getCart().values().size()!=0){%>
                <form action="MainController" >
                    <input type="hidden" name="Total" value="<%=total%>">
                    <input type="submit" name="Action" value="Back to Shopping">
                    <input type="submit" name="Action" value="Confirm Order">
                    <input type="submit" name="Action" value="Top up">
                    <input type="submit" name="Action" value="Confirm Order by Gmail">
                </form>
                <% }else{ %>
                <form action="MainController" >
                    <input type="submit" name="Action" value="Back to Shopping">
                    <input type="submit" name="Action" value="Top up">
                </form>
                <% } %>
    </body>
</html>
