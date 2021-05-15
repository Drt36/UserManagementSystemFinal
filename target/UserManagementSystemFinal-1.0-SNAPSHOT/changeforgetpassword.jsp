<%-- 
    Document   : changeforgetpassword
    Created on : May 20, 2020, 12:08:12 PM
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
        <h1 style="text-align:center; color:white;" >Change Forget Password</h1>
        <form  style="border-radius:10px; background-color:#fafafa;" action="<%= request.getContextPath() %>/changeforgetpasswordservlet" method="post">
                <div class="container">
                  
                   <p style=" text-align:center; color:red;">${msg5}</p>
                   <p style=" text-align:center; color:green;">${msg2}</p>
                  <label for="newpass"><b>New Password:</b></label><br>
                  <input style="border-radius:10px;" type="password" placeholder="Enter New Password" name="newpassword" required minlength="8"><br>
                  
                  <label for="newpass"><b>Confirm New Password:</b></label><br>
                  <input style="border-radius:10px;" type="password" placeholder="Enter Confirm New Password" name="confirmnewpassword" required   minlength="8" >
                  <br>
                  <br>
                  <button type="submit" class="btn btn-success">Save</button>
                </div>

                
         </form>
    </body>
</html>
