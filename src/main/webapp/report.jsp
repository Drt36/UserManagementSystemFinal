<%-- 
    Document   : report
    Created on : May 25, 2020, 10:19:18 AM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="Database.connection.Counter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
<!DOCTYPE HTML>
<html>
<head>  
    <% 
        //getting data to store in graph
      Counter count=new Counter();
     int add=count.countaddedInDaterange();
     int add1=count.countaddedInDaterange1();
     int remove=count.countRemovedInDaterange();
     int remove1=count.countRemovedInDaterange1();
    
    %>
    
    <meta charset="UTF-8">
    <title>User Management System</title>
    <link rel="stylesheet" href="CSS/Style.css" type="text/css">
    <link rel="stylesheet" href="CSS/Style_4.css" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script type="text/javascript">
window.onload = function () {
    var chart = new CanvasJS.Chart("chartContainer",
    {
      title:{
        text: "Added And Removed Users in Date Range"
    },
    axisX:{
        title: "timeline",
        gridThickness: 3,
         valueFormatString: "YYYY" 
    },
    axisY: {
        title: "Number Of users"
    },
    data: [
    {        
        type: "line",
         dataPoints: [
       {  y: <%=add%>, label:"2020"},
       {  y:<%=add1%> , label:"2021"},
       {  y: 0, label:"2022"},
       {  y: 0, label:"2023"},
       {  y: 0, label:"2024"},
       {  y: 0, label:"2025"}
    

        ]
    },{        
        type: "line",
         dataPoints: [
       {  y:<%=remove%> , label:"2020"},
       {  y:<%=remove1%> , label:"2021"},
       {  y: 0, label:"2022"},
       {  y: 0, label:"2023"},
       {  y: 0, label:"2024"},
       {  y: 0, label:"2025"}
        

        ]
    }
    ]
});

    chart.render();
};



</script>

<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
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
      <a href="report.jsp" class="active">
        <i class="fas fa-book"></i>
        <span>REPORT</span>
      </a>
      <a href="logout.jsp" >
          <i class="fas fa-sign-out-alt"></i>
        <span>LogOut</span>
      </a>
    </div>
    
      
      <div class="row">
            <div class="column" style="margin-left:17%; position: absolute; top:50%;">
          <div class="card">
              <h3>Registered Users</h3>
            <img src="Images/added.png" style="width:20%">
            
            
          </div>
        </div>

        <div class="column" style="margin-left:30%; position: absolute; top:50%;">
          <div class="card">
              <h3>Removed users</h3>
            <img src="Images/blocked.png" style="width:21%">
            
            
          </div>
        </div>
    
<div id="chartContainer" style="height: 300px; width: 75%; margin-left:17%; margin-top:2%;">
</div>
</body>
</html>