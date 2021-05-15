/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Authentication.Validate;
import Database.connection.Databasecon;
import Database.connection.Storer;
import User.Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import otherfunction.Hashing;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
@WebServlet("/userregisterservlet")
public class Userregisterservlet extends HttpServlet {
      Hashing hash=new Hashing();
      private Databasecon databasecon;
      
      public void init() {
        databasecon = new Databasecon();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerservlet at " + request.getContextPath() + "</h1>");
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
        
             String username = request.getParameter("username");
             String first_name = request.getParameter("first_name_id");
             String last_name = request.getParameter("last_name_id");
             String email = request.getParameter("email");
             boolean role=Boolean.parseBoolean(request.getParameter("role"));
             String phone_number =request.getParameter("phone_number_id");
             String address = request.getParameter("address_id");
             String birthdate = request.getParameter("birthdate_id");
             String gender=request.getParameter("gender_id");
             
             String password1=request.getParameter("password1_id");
             String confirmpassword1=request.getParameter("confirmpassword1_id");
              Validate val= new Validate();
              boolean status1= false;
              boolean status2 = false;
          try {
              status1 = val.validateUsername(username);
                 status2 = val.validateEmail(email);
              } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(Userregisterservlet.class.getName()).log(Level.SEVERE, null, ex);
          }
                            
             
             if((password1.equals(confirmpassword1) && (status1==false && status2==false))){
                    password1=hash.getMd5(password1);
              
                     User user = new User();
                     user.setUsername(username);
                     user.setFirst_name(first_name);
                     user.setLast_name(last_name);
                     user.setEmail(email);
                     user.setIs_admin(false);
                     user.setPhone_number(phone_number);
                     user.setAddress(address);
                     user.setBirthdate(birthdate);
                     user.setGender(gender);
                     user.setPassword1(password1);
                     
                     
             try {
                        //register user        
                        databasecon.registerUserTest(user);
                       
                         //added to added count
                        long millis=System.currentTimeMillis();  
                        java.sql.Date date=new java.sql.Date(millis);  
                        Storer store=new Storer();
                        store.storeAddedcount(date);
                        
                } catch (ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                           System.out.println(e);
                        }        
             
                     String message3 = "Hurray,Your account has been registered Successfully!!! Now you can login.";
                              request.setAttribute("message3", message3);
                                         
                     RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                                dispatcher.forward(request, response);
        
             } 
             else if((!password1.equals(confirmpassword1) && (status1==true && status2==true))){
                 String message12 = " Password and Confirm password did not matched !!!";
                 request.setAttribute("message12", message12);
                 
                String message = "Username Already Taken.Try Another username!!!";
                request.setAttribute("message", message);

               String message3 = "Email Already Exist.Try Another Email or login directly!!!";
               request.setAttribute("message3", message3);

               RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
               dispatcher.forward(request, response);
              
             }
             else if(status1==true && status2==true){
                                String message = "Username Already Taken.Try Another username!!!";
                                    request.setAttribute("message", message);
                                    
                                String message3 = "Email Already Exist.Try Another Email or login directly!!!";
                                    request.setAttribute("message3", message3);
                                    
                                    RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
                                    dispatcher.forward(request, response);
             }
             else if(status1==true && !password1.equals(confirmpassword1))
             {
             
             
             String message12 = " Password and Confirm password did not matched !!!";
                              request.setAttribute("message12", message12);
             String message = "Username Already Taken.Try Another username!!!";
                                    request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
                                dispatcher.forward(request, response);
             
             }
             else if(status2==true && !password1.equals(confirmpassword1))
             {
             
             
             String message12 = " Password and Confirm password did not matched !!!";
                              request.setAttribute("message12", message12);
             String message3 = "Email Already Exist.Try Another Email or login directly!!!";
                                    request.setAttribute("message3", message3);
            RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
                                dispatcher.forward(request, response);
             
             }
             else if(!password1.equals(confirmpassword1)){
             
               String message12 = " Password and Confirm password did not matched !!!";
                              request.setAttribute("message12", message12);
                                         
                     RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
                                dispatcher.forward(request, response);
             
             }
             else if(status1==true){
                                    String message = "Username Already Taken.Try Another username!!!";
                                    request.setAttribute("message", message);

                                    RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
                                    dispatcher.forward(request, response);
                                }
             else if(status2==true){
                                  String message3 = "Email Already Exist.Try Another Email or login directly!!!";
                                    request.setAttribute("message3", message3);

                                    RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
                                    dispatcher.forward(request, response);
             }
             
             
             
             }
             
              
       
    }

   
