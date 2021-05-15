<%-- 
    Document   : adminDashboard
    Created on : May 18, 2020, 12:03:02 PM
    Author     : HP Omen 15-dc0079tx
--%>
<%@page import="User.Model.User"%>
<%@page import="Database.connection.GetALLDATA"%>

<%@page import="Database.connection.Counter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>User Management System</title>
    <link rel="stylesheet" href="CSS/Style.css" type="text/css">
    <link rel="stylesheet" href="CSS/Style_4.css" type="text/css">
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
      <a href="changePasswordadmin.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="Profileadmin.jsp">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="historyadmin.jsp">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="report.jsp">
        <i class="fas fa-book"></i>
        <span>REPORT</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
       <h3 style="text-align: center">${message5}</h3>
      <h3 style="text-align: center">${message4}</h3>
      
      <br>
      <br>
     <div>
        <%         
          String sescon = (String)session.getAttribute("user");
          Counter count=new Counter();
          //count total user
          int totaluser=count.countTotalUser();
          //count removed user
          int removeduser=count.countBlockedUser();
          //count login
          int logincount=count.countLogin(sescon);
          //total activity count
          int activitycount=count.countActivity(sescon);
        
        %>
        <div class="row">
            <div class="column" style="margin-left:17%; position: absolute; top:13.5%;">
          <div class="card">
              <h3>Total Users</h3>
            <img src="Images/Userss.png" style="width:20%">
            <h2><%=totaluser %></h2>
            
          </div>
        </div>

        <div class="column" style="margin-left:30%; position: absolute; top:13.5%;">
          <div class="card">
              <h3>Removed users</h3>
            <img src="Images/block.png" style="width:25%">
            <h2><%=removeduser %></h2>
            
          </div>
        </div>
            
        <div class="column" style="margin-left:45%; position: absolute; top:13.5%;">
          <div class="card">
            <h3>Login Count</h3>
            <img src="Images/Logincount.png" style="width:40%">
            <h2><%=logincount %></h2>
            
          </div>
        </div>
            
            
        <div class="column" style="margin-left:60%; position: absolute; top:13.5%;">
          <div class="card">
            <h3>Activity Count</h3>
            <img src="Images/Activitycount.png" style="width:30%">
            <h2><%=activitycount %></h2>
            
          </div>
        </div>
    
    </div>
     </div>

</body>

</html>

