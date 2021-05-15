<%-- 
    Document   : forgetpass
    Created on : May 18, 2020, 12:03:18 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="CSS/Style_2.css" type="text/css">
        <title>User Management System</title>
    </head>
    <body>
        <h1 style="text-align:center; color:white;" >Forget Password</h1>
        <h3 style="text-align:center; color:white;" >Please enter valid email which is associated with this System.</h3>
        <form style="border-radius:10px; background-color:#fafafa;" action="<%= request.getContextPath() %>/forgetpasswordservlet" method="post">
                <div class="container">
                
                  <p style=" text-align:center; color:red;">${message}</p>
                  <label for="email"><b>Email</b></label><br>
                  <input style="border-radius:10px;" type="email" placeholder="Enter Email" name="email" required>
                  <br>
                  <br>
                  <button type="submit" class="btn btn-success">Send Code</button>
                </div>

                
         </form>  
                   
                  
                  
                   
                  
    </body>
</html>
