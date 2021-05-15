<%-- 
    Document   : historyadmin
    Created on : May 24, 2020, 7:49:34 AM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="User.Model.User"%>
<%@page import="User.Model.History"%>
<%@page import="java.util.List"%>
<%@page import="Database.connection.GetALLDATA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
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
     
   
      <a href="adminDashboard.jsp" >
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
      <a href="historyadmin.jsp" class="active">
        <i class="fas fa-history" ></i>
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
      
                          <%
                              //getting email from session
                              String sescon = (String)session.getAttribute("user");
                              //getting data of specific email
                               GetALLDATA gad=new GetALLDATA();
                               List < History > listhistory=gad.getHistory(sescon);
                            %>  
      
    <div style="margin-left: 250px; margin-right:20px;">  
      <h1  style="text-align:center" >Activity Log</h1>
      <h4 style="text-align:center; color: green; margin: auto;">${messg8}</h4>
      <br>
      <br>
      <button onclick="location.href='Deletehistoryadmin?email=<%=sescon%>'" class="btn danger" >Clear All History</button></td>
      <br>
      <br>
      <table id="t01"  style="margin-bottom: 20px;">
                        
                            <tr>
                                <th>Email</th>
                                <th>Task</th>
                                <th>Time</th>
                                
                            </tr>
                        
                       
                             
                           <% for(History his:listhistory){%> 
                            <%-- Arranging data in tabular form 
                            --%> 
                                <tr> 
                                    <td><%=his.getEmail()%></td> 
                                    <td><%=his.getTask()%></td>
                                    <td><%=his.getTime1()%></td>
                                       
                                <%}%> 
                             
                                
                            
                                </tr>
                        
                       
                      

                    </table>
     
    </div>

</body>

</html>
