<%-- 
    Document   : changePassword
    Created on : May 19, 2020, 6:29:37 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="Database.connection.GetALLDATA"%>
<%@page import="User.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>User Management System</title>
        <link rel="stylesheet" href="CSS/Style.css" type="text/css">
        <link rel="stylesheet" href="CSS/Style_2.css" type="text/css">
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


              <a href="adminDashboard.jsp" >
                <i class="fas fa-columns"></i>
                <span>Dashboard</span>
              </a>
               <a href="Alluser.jsp">
                <i class="fas fa-users"></i>
                <span>Users</span>
              </a>
              <a href="changePasswordadmin.jsp" class="active">
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
              <h1 style="text-align:center; margin-top:20px; ">Change Password</h1>
             
        <form action="<%= request.getContextPath() %>/ChangePasswordServletadmin" method="post">
                
                <div class="container">
                  
                  
                   <p style=" text-align:center; color:red;">${message9}</p>
                   <p style="text-align:center; color:red;">${message11}</p>
                   <p style="text-align:center; color:green;">${message10}</p>
                   <br>
                  <label for="email"><b>Old Password:</b></label><br>
                  <input style="border-radius:10px;" type="password" placeholder="Enter Old Password" name="oldpassword" required  ><br>
                  <br>
                  <p style=" text-align:center; color:red;">${message8}</p>
                  <label for="email"><b>New Password:</b></label><br>
                  <input style="border-radius:10px;" type="password" placeholder="Enter New Password" name="newpassword" required minlength="8" ><br>
                  <br>
                  <label for="email"><b>Confirm New Password:</b></label><br>
                  <input style="border-radius:10px;" type="password" placeholder="Enter Confirm New Password" name="confirmnewpassword" required minlength="8" >
                  <br>
                  <br>
                  <button type="submit" class="btn btn-success">Save</button>
                </div>

                
         </form>
    </body>
</html>



