<%-- 
    Document   : register
    Created on : May 18, 2020, 12:05:00 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="Database.connection.GetALLDATA"%>
<%@page import="User.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="adminpageprotection.jsp" />
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
    <body style="background-color:#0A4141; overflow: hidden;">
        <h3 style="text-align:center; color:white;">Register</h3>
        <form action="<%= request.getContextPath() %>/adminregisterservlet1" class="was-validated" style="border-radius:10px; background-color:#fafafa;margin-left: 35%; margin-right:35%; margin-bottom:10px;" method="post">
                <div class="container">
                 
                    <label for="uname"><b>Username:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter username" name="username" required  maxlength="50">
                    
                    <p style="color:red;">${message}</p>
                    
                 
                    <label for="uname"><b>First Name:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter First Name" name="first_name_id" required  maxlength="50">
                   
                    
                
                    <label for="uname"><b>Last Name:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter Last Name" name="last_name_id" required  maxlength="50">
                    
                    
                
                    <label for="uname"><b>Email:</b></label>
                    <input type="email" class="form-control" id="uname" placeholder="Enter Email" name="email" required  maxlength="100">
                   <p style="color:red;">${message3}</p>
                    
                
                    <label for="uname"><b>Contact:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter Phone Number" name="phone_number_id" required minlength="10" maxlength="10">
                    
                    
                
                    <label for="uname"><b>Address:</b></label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter Address" name="address_id" required maxlength="50">
                    
                    
              
                    <label for="uname"><b>Date of Birth:</b></label>
                    <input type="text" class="form-control" id="datepicker" name="birthdate_id" required maxlength="30">
                  
                    
                 
                    <label for="uname"><b>Gender:</b></label>
                    <select name="gender_id">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                    
                    <div class="form-group">
                        <label><b>Admin</b></label>
                        <input type="checkbox" name="role" value="true" />
                   </div>
                
                
                  <p style="color:red;">${message12}</p>
                  
                 
                    <label for="pwd"><b>Password:</b></label>
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password1_id" required minlength="8" maxlength="100">
                   
                    
                  
                    <label for="pwd"><b>Confirm Password:</b></label>
                    <input type="password" class="form-control" id="pwd" placeholder="Enter Confirm password" name="confirmpassword1_id" required minlength="8" maxlength="100" >
                   
                    
                  
                  <div class="form-group form-check">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" name="remember" required> I agree on<a href="terms.jsp">Terms & Conditions.</a>
                   
                      
                    </label>
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
