<%-- 
    Document   : forgetpass1
    Created on : May 20, 2020, 10:04:13 AM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/Style_2.css" type="text/css">
        <title>User Management System</title>
    </head>
    <body>
         <h1 style="text-align:center; color:white;" >Validate code</h1>
         <form style="border-radius:10px; background-color:#fafafa;" action="<%= request.getContextPath() %>/forgetpasswordservlet1" method="post">
                           <div class="container">
                                <p style=" text-align:center; color:red;">${msg1}</p>
                                <p style=" text-align:center; color:green;">${message1}</p>

                                <label for="code"><b>code:</b></label><br>
                                <input  style="  width:100%;
                                    padding: 12px 20px;
                                    margin: 8px 0;
                                    display: inline-block;
                                    border: 1px solid #ccc;
                                    box-sizing: border-box;
                                    border-radius:15px;" type="text" placeholder="Enter code" name="code" required>
                                <br>
                                <br>
                                <button type="submit" class="btn btn-success">Submit</button>
                           </div>


         </form>
                 
    </body>
</html>
