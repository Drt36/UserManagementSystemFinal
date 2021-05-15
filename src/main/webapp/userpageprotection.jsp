<%-- 
    Document   : userpageprotection
    Created on : May 24, 2020, 10:01:02 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="User.Model.User"%>
<%@page import="Database.connection.GetALLDATA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
   //protecting user page
  String sescon = (String)session.getAttribute("user");
  
   if(sescon==null){
        
        
       
        String permissionmsg="You are not normal user.Please login as normal user!!!";
        request.setAttribute("permissionmsg",permissionmsg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
   }else{
   
        GetALLDATA gad=new GetALLDATA();
        User user=gad.getAllDataofuser(sescon);
  
        if(user.isIs_admin()==true){
        
           String permissionmsg="You are not normal user.Please login as normal user!!!";
           request.setAttribute("permissionmsg",permissionmsg);
           RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
           dispatcher.forward(request, response);
        
        
        
        
        
        }
   
   
   
   }

%>