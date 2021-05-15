<%-- 
    Document   : adminpageprotection
    Created on : May 24, 2020, 10:01:51 PM
    Author     : HP Omen 15-dc0079tx
--%>

<%@page import="Database.connection.GetALLDATA"%>
<%@page import="User.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //proptecting admin page
  String sescon = (String)session.getAttribute("user");
  
   if(sescon==null){
        String permissionmsg="You are not admin.Please login as admin!!!";
        request.setAttribute("permissionmsg",permissionmsg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
   }else{
   
        GetALLDATA gad=new GetALLDATA();
        User user=gad.getAllDataofuser(sescon);
  
        if(user.isIs_admin()==false){
        
           String permissionmsg="You are not admin.Please login as admin!!!";
           request.setAttribute("permissionmsg",permissionmsg);
           RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
           dispatcher.forward(request, response);
        }
   }
%>
