<%-- 
    Document   : historyadminview
    Created on : May 24, 2020, 1:55:12 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="User.Model.User"%>
<%@page import="Database.connection.GetALLDATA"%>
<%@page import="User.Model.History"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>User Management System</title>
    <link rel="stylesheet" href="CSS/Style.css" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
</head>

<body style="background-color:#0A4141;">  
    
    <% 
    ArrayList<History> listhistory=(ArrayList<History>)request.getAttribute("listhistory");
    
    %>
    <h1  style="text-align:center; color:white;" >Activity Log</h1>
     
     <div style="margin:auto; background-color:whitesmoke;" >
      
      
      <h4 style="text-align:center; color: green; margin: auto;">${messg7}</h4>
      
      <br><br>
      <br><br>
      <div style="width:80%; margin-left:200px;">
     
      <table id="t01" >
                        
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
                                <br><br>
           <button onclick="location.href='Alluser.jsp'" type="button">Close</button>
                               <br><br>
     </div>


</body>

</html>