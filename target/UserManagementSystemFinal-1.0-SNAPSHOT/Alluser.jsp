<%-- 
    Document   : Alluser
    Created on : May 21, 2020, 5:21:31 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="Database.connection.GetALLDATA"%>
<%@page import="java.util.List"%>
<%@page import="User.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />

<!DOCTYPE html>
<html>
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
     
   
      <a href="adminDashboard.jsp">
        <i class="fas fa-columns"></i>
        <span>Dashboard</span>
      </a>
       <a href="Alluser.jsp" class="active">
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
       
        <div style="margin-left: 250px; margin-right:20px;">
            <h1  style="text-align:center" >List of Users</h1>
                    
                    <hr>
                    <br>
       <div class="container text-left">

        <button onclick="location.href='adminregister.jsp'" type="button"  style="
                    background-color:#0A4141; color: white;
                    padding: 14px 20px;
                    margin: 8px 0;
                    border: none;
                    cursor: pointer;
                    ">Add New User</button>
        </div>
                    <br>
        <h2 style=" text-align:center; color:green;">${messg2}</h2>
        <h2 style=" text-align:center; color:green;">${message33}</h2>
        <h2 style=" text-align:center; color:red;">${messg1}</h2>
            <table id="t01"  style="margin-bottom: 20px;">
                        
                            <tr>
                                <th>Username</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>IS_Admin</th>
                                <th>Contact</th>
                                <th>Address</th>
                                <th>Date OF Birth</th>
                                <th>Gender</th>
                                <th>Actions</th>
                            </tr>
                        
                       
                           <%
                               //fetching list of all users
                               GetALLDATA gad=new GetALLDATA();
                               List < User > listUser =gad.selectAllUsers();
                                
                            for(User user:listUser){%> 
                            <%-- Arranging data in tabular form 
                            --%> 
                                <tr> 
                                    <td><%=user.getUsername()%></td> 
                                    <td><%=user.getFirst_name()%></td>
                                    <td><%=user.getLast_name()%></td>
                                    <td><%=user.getEmail()%></td>
                                    <td><%=user.isIs_admin()%></td>
                                    <td><%=user.getPhone_number()%></td>
                                    <td><%=user.getAddress()%></td>
                                    <td><%=user.getBirthdate()%></td>
                                    <td><%=user.getGender()%></td>
                                    <td><button onclick="location.href='Editprofileadminservlet?username=<%=user.getUsername()%>'"  class="btn warning"/>Edit</button> &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='Deleteuser?username=<%=user.getUsername()%>&email=<%=user.getEmail()%>'" class="btn danger" >Remove</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button onclick="location.href='historyspecificuser?email=<%=user.getEmail()%>'" class="btn success" >History</button>
                                    </td>
                                       
                                <%}%> 
                             
                                
                            
                                </tr>
                        
                       
                      

                    </table>
              </div>
            </div>
    </body>
</html>
