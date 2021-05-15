/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.connection.ChangePassword;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
@WebServlet("/forgetpasswordservlet1")
public class forgetpasswordservlet1 extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet forgetpasswordservlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet forgetpasswordservlet1 at " + request.getContextPath() + "</h1>");
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
         HttpSession session = request.getSession();
         String email=(String) session.getAttribute("email");
         System.out.println(email);
         String code=request.getParameter("code");
         ChangePassword cp=new ChangePassword();
         
        try {
            //validating code
            boolean status=cp.validateCode(email, code);
             if(status==true){
                 
              //redirect to next page to set up new password
               String msg2 = "Hurray,Your credentials are Valid.Now save your new Password";
               request.setAttribute("msg2", msg2);
               RequestDispatcher dispatcher = request.getRequestDispatcher("changeforgetpassword.jsp");
               dispatcher.forward(request, response);
               
               
               //deleting temprorary code
               cp.deleteCode(email);
             
             
             
             }else{
        
              
               String msg1 = "Wrong credentials !!! Please Try Again.";
               request.setAttribute("msg1", msg1);
               RequestDispatcher dispatcher = request.getRequestDispatcher("forgetpass1.jsp");
               dispatcher.forward(request, response);
        
               
           }
              
            
            
            
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(forgetpasswordservlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
   
        
        
      
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
