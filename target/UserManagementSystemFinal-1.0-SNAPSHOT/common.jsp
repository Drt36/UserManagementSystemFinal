<%-- 
    Document   : common
    Created on : May 21, 2020, 10:36:30 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>User Management System</title>
    <link rel="stylesheet" href="CSS/Style.css" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
   
</head>

<body style="background-color:whitesmoke">
    <div id="navbar">
       
        <a class="active1" >Welcome:Admin</a>
        
     </div>
    
      <input type="checkbox" id="check">
    <label for="check">
      <i class="fas fa-bars" id="btn"></i>
      <i class="fas fa-times" id="cancel"></i>
    </label>    
    <div class="sidebar">
      <header>Exousia</header>
     
   
      <a href="adminDashboard.jsp" class="active">
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
       <a href="Alluser.jsp">
        <i class="fas fa-users"></i>
        <span>Users</span>
      </a>
      <a href="changePassword.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="#">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="#">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>

</body>

</html>
