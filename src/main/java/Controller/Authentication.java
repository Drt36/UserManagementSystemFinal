/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Authentication.Validate;
import Database.connection.GetALLDATA;
import Database.connection.StoreHistory;
import User.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Authentication</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Authentication at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             String email= request.getParameter("email");
             String password = request.getParameter("password1");
             
                            Validate val= new Validate();
                            boolean status = false;
                            try {
                                status = val.validateUser(email,password);
                           
                               
                            if (status==true) {
                                  //creating session
                                  HttpSession session=request.getSession();
                                  session.setAttribute("user",email);
                                  String sescon = (String)session.getAttribute("user");
                                  //getting data of user
                                  GetALLDATA gad=new GetALLDATA();
                                  User user=gad.getAllDataofuser(email);
                                  //get role
                                  boolean role=user.isIs_admin();
                                  //getting name
                                  String name=user.getFirst_name();
                                  
                                  if(sescon!=null){
                                      
                                      if(role==true){
                                          //login time
                                          Date createTime = new Date(session.getCreationTime());
                                          String datetime =createTime.toString();
                                          
                                           //stroing login data
                                          StoreHistory sh=new StoreHistory();
                                          sh.storeHistory(sescon,"Login into System",datetime);
                                          
                                          String message4=name;
                                          request.setAttribute("message4","Welcome: "+message4);
                                          
                                          String message5=datetime;
                                          request.setAttribute("message5","Login Time:"+message5);
                                          
                                          RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
                                          dispatcher.forward(request, response);
                                       
                                      
                                      }
                                      else if(role==false){
                                          //login time
                                          Date createTime = new Date(session.getCreationTime());
                                          String datetime =createTime.toString();
                                          
                                           //stroing login data
                                          StoreHistory sh=new StoreHistory();
                                          sh.storeHistory(sescon,"Login into System",datetime);
                                          
                                          String message4=name;
                                          request.setAttribute("message4","Welcome: "+message4);
                                          
                                          String message5=datetime;
                                          request.setAttribute("message5","Login Time"+message5);
                                          
                                          RequestDispatcher dispatcher = request.getRequestDispatcher("userDashboard.jsp");
                                          dispatcher.forward(request, response);
                                      
                                      
                                      }
                                      else{
                                      
                                      
                                          String message6=" Role is not created. contact the support Department";
                                          request.setAttribute("message6", message6);
                                          RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                          dispatcher.forward(request, response);
                                      
                                      
                                      }
                                        
                                       
                                        
                                        
                                       
                                  }
                                  else{
                                      
                                       String message7="session is not created.contact the support Department";
                                       request.setAttribute("message7", message7);
                                       RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                          dispatcher.forward(request, response);
                                  }
                               }
                            else{
                               String message1 = "Wrong Credentials!!! \n Email and Password did not matched.";
                               request.setAttribute("message1", message1);
                                String message="Forget Password?";
                                request.setAttribute("message",message);
                                         
                                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                dispatcher.forward(request, response);
                            }
             } 
             catch (ClassNotFoundException | SQLException ex) 
             {
                 Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
                            
             }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
