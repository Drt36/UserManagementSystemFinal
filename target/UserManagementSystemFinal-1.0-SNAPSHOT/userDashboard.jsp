<%-- 
    Document   : userDashboard
    Created on : May 18, 2020, 12:05:22 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="User.Model.User"%>
<%@page import="Database.connection.GetALLDATA"%>
<%@page import="Database.connection.Counter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="userpageprotection.jsp" /> 
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
       
        <a class="active1" >Welcome:User</a>
        
     </div>
    
      <input type="checkbox" id="check">
    <label for="check">
      <i class="fas fa-bars" id="btn"></i>
      <i class="fas fa-times" id="cancel"></i>
    </label>    
    <div class="sidebar">
      <header>Exousia</header>
     
   
      <a href="userDashboard.jsp" class="active">
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
      <a href="changePassworduser.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="Profileuser.jsp">
        <i class="fas fa-user"></i>
        <span>Profile</span>
      </a>
      <a href="historyuser.jsp">
        <i class="fas fa-history"></i>
        <span>HISTORY</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
       <h3 style="text-align: center">${message4}</h3>
      <h3 style="text-align: center">${message5}</h3>
      
      <%         
          String sescon = (String)session.getAttribute("user");
          Counter count=new Counter();
          //count login
          int logincount=count.countLogin(sescon);
          //total activity count
          int activitycount=count.countActivity(sescon);
        
        %>
      <div class="row">
          <div class="column" style="margin-left:17%; position: absolute; top:13.5%;">
          <div class="card">
            <h3>Login Count</h3>
            <img src="Images/Logincount.png" style="width:42%">
            <h2><%=logincount %></h2>
            
          </div>
        </div>
            
            
        <div class="column" style="margin-left:30%; position: absolute; top:13.5%;">
          <div class="card">
            <h3>Activity Count</h3>
            <img src="Images/Activitycount.png" style="width:22%">
            <h2><%=activitycount %></h2>
            
          </div>
        </div>
          
          
      </div>

</body>

</html>

