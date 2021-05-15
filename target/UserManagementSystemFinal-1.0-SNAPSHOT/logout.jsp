<%-- 
    Document   : logout
    Created on : May 18, 2020, 12:04:49 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="User.Model.User"%>
<%@page import="Database.connection.StoreHistory"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management System</title>
    </head>
    <body>
         
         <%  
           String sescon = (String)session.getAttribute("user");  
           Date outtime = new Date();
           String datetime =outtime.toString();
           //stroing login data
           StoreHistory sh=new StoreHistory();
           sh.storeHistory(sescon,"Logout from System",datetime); 
           session.invalidate();
          
         %>
         <jsp:forward page="index.jsp"/>
    </body>
</html>
