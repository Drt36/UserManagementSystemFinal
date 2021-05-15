<%-- 
    Document   : Profile
    Created on : May 23, 2020, 3:13:23 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="User.Model.User"%>
<%@page import="Database.connection.GetALLDATA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/Style.css" type="text/css">
    
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
      
<link rel="stylesheet" href="CSS/Style_3.css" type="text/css">
<title>User Management System</title>
</head>
<body>
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
       <a href="Alluser.jsp">
        <i class="fas fa-users"></i>
        <span>Users</span>
      </a>
      <a href="changePasswordadmin.jsp" >
         <i class="fas fa-key"></i>
        <span>Change Password</span>
      </a>
      <a href="Profileadmin.jsp" class="active">
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

      
      
      
 <% 
   //getting data set in session
  String sescon = (String)session.getAttribute("user");
  //getting user details
  GetALLDATA gad=new GetALLDATA();
  User user= (User)gad.getAllDataofuser(sescon);
   
 
 %>    
 
<h1 style="text-align:center"> Profile </h1>

<div class="card">
  <img src="Images/useravatar.png" alt="John" style="width:50%; border-radius:50%;">
  <h1><%=user.getFirst_name()%> <%=user.getLast_name()%></h1>
  <br>
  <br>
     
        <div>
            <i class="fas fa-user-tag" style="float:left; margin-left:35%;"></i>
            <p class="title" style="float:right; margin-right:21%;">Member of UMS made by Exousia</p>
        </div>
        <br>
        <br>
       
        <div>
            <i class="fas fa-mobile-alt" style="float:left; margin-left:35%;">

            </i><p style="float:right; margin-right: 45%;"><%=user.getPhone_number()%></p>

        </div >
        <br>
        <br>
        
        <div >
         <i class="fas fa-map-marker-alt" style="float:left; margin-left:35%;"></i>
        <p style="float:right; margin-right: 35%;"><%=user.getAddress()%></p>
        </div>
        <br>
         <br>
        <div>
        <i class="far fa-calendar-alt" style="float:left; margin-left:35%;"></i>
        <p style="float:right; margin-right: 45%;"><%=user.getBirthdate()%></p>
        </div>
        <br>
        <br>
        <div>
        <i class="fas fa-male" style="float:left; margin-left:35%;"></i>
        <p style="float:right; margin-right:50%;"><%=user.getGender()%></p>
        </div>
        <br>
        <br>
        
        <div >
            
        <button onclick="location.href='Editprofileownadminservlet?username=<%=user.getUsername()%>'"  style="float:left; margin-left:45%;" class="btn warning"/>Edit</button>

        </div>
         <br>
        <br>
        <br>
        
        <div>
        <h4 style="text-align:center; color: green; margin: auto;">${messg2}</h4>
        </div>
        
      </div>

</body>
</html>
