<%-- 
    Document   : login
    Created on : May 18, 2020, 12:04:32 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/Style_2.css" type="text/css">
<title>User Management System</title>
</head>
<body>

    <h1  style="text-align:center; color:white;" >Login Form</h1>

<form style="background-color:#fafafa;" action="<%= request.getContextPath() %>/Authentication" method="post">
  <div class="imgcontainer">
    <img src="Images/useravatar.png" alt="Avatar" class="avatar">
  </div>
          <p style="color:green; text-align:center; ">${msg4}</p>
          <p style="color:green; text-align:center; ">${message3}</p>
          <p style="color:red; text-align:center; " >${message1}</p>
          <p style="color:red; text-align:center; ">${message6}</p>
          <p style="color:red; text-align:center; ">${message7}</p>
          <p style="color:red; text-align:center; ">${permissionmsg}</p>
  <div class="container">
      
    <label for="email"><b>Email</b></label><br>
    <input  type="email" placeholder="Enter Email" name="email" required>
             
    <label for="psw"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="password1" required minlength="8">
    
   
        
    <button type="submit">Login</button>
    <label>
    
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button onclick="location.href='index.jsp'" type="button" class="cancelbtn">Cancel</button>
    <span class="psw"><a style="color: red;"  href="forgetpass.jsp">${message}</a></a></span>
  </div>
</form>
</body>
</html>
