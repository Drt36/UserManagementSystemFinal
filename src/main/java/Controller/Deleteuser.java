/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.connection.Action;
import Database.connection.StoreHistory;
import Database.connection.Storer;
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
import otherfunction.EmailSender;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
@WebServlet(name = "Deleteuser", urlPatterns = {"/Deleteuser"})
public class Deleteuser extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Deleteuser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Deleteuser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        Action ac=new Action();
        try {
            
            //deleting user
            ac.deleteUser(username);
            
            //store remove count
           
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);  
            Storer store=new Storer();
            store.storeRemovedcount(date);
            
            //store data of deleted user
          
            store.storeRemovedUser(username);
        
          //stroring history log of admin
           HttpSession session=request.getSession();
           String sescon = (String)session.getAttribute("user");
           Date outtime = new Date();
           String datetime =outtime.toString();
         
           StoreHistory sh=new StoreHistory();
           
           sh.storeHistory(sescon,"Removed user named as:"+username,datetime);
           
           //sending account removed email
           EmailSender es=new EmailSender();
           es.removeEmailSender(email, username);
      
           
        String messg1 = "Selected User is removed Successfully!!!";
        request.setAttribute("messg1", messg1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Alluser.jsp");
        dispatcher.forward(request, response);
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Deleteuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
