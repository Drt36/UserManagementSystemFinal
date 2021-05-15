<%-- 
    Document   : Editprofile
    Created on : May 23, 2020, 9:43:18 AM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="Database.connection.GetALLDATA"%>
<%@page import="User.Model.User"%>
<%@page import="Database.connection.Action"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminpageprotection.jsp" />
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
            
            <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
            <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
            <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>

            <script type="text/javascript" src="Script/date.js"></script>

        <title>User Management System</title>
    </head>
     <%  
         User user= (User)request.getAttribute("user");
     %>
    <body style="background-color:#0A4141; overflow: hidden;">
        <h3 style="text-align:center; color:white;">Edit Profile</h3>
        <form action="<%= request.getContextPath() %>/Editprofileownadminservletfinal" class="was-validated" style="border-radius:10px; background-color:#fafafa;margin-left: 35%; margin-right:35%; margin-bottom:10px;" method="post">
                <div class="container">
                    
                    
                    
                    <input type="hidden" class="form-control" id="uname" placeholder="Enter username" value="<%=user.getUsername()%>" name="username" required  maxlength="50">
                    
                    <label for="uname"><b>First Name:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter First Name"  value="<%= user.getFirst_name()%>" name="first_name_id" required  maxlength="50">
                   
                    
                
                    <label for="uname"><b>Last Name:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter Last Name" value="<%= user.getLast_name()%>" name="last_name_id" required  maxlength="50">
                    
                    
                
                 
                    
                
                    <label for="uname"><b>Contact:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter Phone Number" value="<%= user.getPhone_number()%>" name="phone_number_id" required minlength="10" maxlength="10">
                    
                    
                
                    <label for="uname"><b>Address:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter Address" value="<%= user.getAddress()%>" name="address_id" required maxlength="50">
                    
                    
              
                    <label for="uname"><b>Date of Birth:</b></label>
                    <input type="text" class="form-control" id="datepicker" value="<%= user.getBirthdate()%>" name="birthdate_id" required maxlength="30">
                  
                    
                 
                    <label for="uname"><b>Gender:</b></label>
                    <select name="gender_id" value="<%= user.isIs_admin()%> ">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                    
                    <div class="form-group" style="visibility: hidden;">
                        <label><b>Admin</b></label>
                        <input type="checkbox" name="role" value="true" checked />
                   </div>
                
       
                  <button type="submit" style="
                    background-color:#0A4141; color: white;
                    padding: 14px 20px;
                    margin: 8px 0;
                    border: none;
                    cursor: pointer;
                    width: 100%;" >Submit</button>


                
              </form>
    </body>
</html>
