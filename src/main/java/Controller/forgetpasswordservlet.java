/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Authentication.Validate;
import Database.connection.ChangePassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import otherfunction.EmailSender;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
@WebServlet("/forgetpasswordservlet")
public class forgetpasswordservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet forgetpasswordservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet forgetpasswordservlet at " + request.getContextPath() + "</h1>");
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
        
        String email=request.getParameter("email");
            Validate val= new Validate();
            boolean status2;
        try {              //validate email
                              status2 = val.validateEmail(email);

                                 if (status2==true){
                                     
                                        Random rand = new Random(); //instance of random class
                                        int upperbound = 10000000;
                                        //generate random values from 0-10000000
                                        int random= rand.nextInt(upperbound);
                                        String randompassword=Integer.toString(random); 
                                        
                                        //send code through email
                                        EmailSender es=new EmailSender();
                                        es.passwordEmailSender(email,randompassword);
                                        
                                        //saving code in database
                                        ChangePassword cp=new ChangePassword();
                                        cp.saveCode(email,randompassword);
                                        
                                        String message1 = "Hurray,Your email associated with this System and New password reset code is Successfully sent to your Email!!!";
                                        request.setAttribute("message1", message1);
                                        RequestDispatcher dispatcher = request.getRequestDispatcher("forgetpass1.jsp");
                                        dispatcher.forward(request, response);
                                   }
                                else{
                                     
                                    
                                     
                                    String message = "Your email is not associated with this System!!!";
                                    request.setAttribute("message", message);

                                    RequestDispatcher dispatcher = request.getRequestDispatcher("forgetpass.jsp");
                                    dispatcher.forward(request, response);
                                }
                    HttpSession session1= request.getSession();
                    session1.setAttribute("email",email);

           
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(forgetpasswordservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
