/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Authentication.Validate;
import Database.connection.ChangePassword;
import Database.connection.StoreHistory;
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
@WebServlet("/ChangePasswordServletadmin")
public class ChangePasswordServletadmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             String oldpassword = request.getParameter("oldpassword");
             String newpassword = request.getParameter("newpassword");
             String confirmnewpassword= request.getParameter("confirmnewpassword");
             
             HttpSession session=request.getSession();
             String sescon = (String)session.getAttribute("user");
             
             Validate val=new Validate();
             
                try {
                    //validate old password
                    boolean status=val.validateUser(sescon,oldpassword);
                
             
             if(!newpassword.equals(confirmnewpassword) && status==false){
                String message11="New password and Confirm New password did not matched!!! \n Old password is also Wrong!!!";
                request.setAttribute("message11", message11);
                RequestDispatcher dispatcher = request.getRequestDispatcher("changePasswordadmin.jsp");
                dispatcher.forward(request, response);
             
             }
             
             if(newpassword.equals(confirmnewpassword)){
                 
                 if(status==true){
                    

                    ChangePassword cp=new ChangePassword();
                   
                    //calling change password method
                   cp.changeManually(sescon, newpassword);
                   
                   //storing history log
                  
                    Date outtime = new Date();
                    String datetime =outtime.toString();
                    StoreHistory sh=new StoreHistory();
                    sh.storeHistory(sescon,"Changed password.",datetime);
                   
                    String message10="Your password has been changed Successfully.";
                    request.setAttribute("message10", message10);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("changePasswordadmin.jsp");
                    dispatcher.forward(request, response);
                 }
                 else{
                   
                     String message9="Old Password is Wrong!!!";
                        request.setAttribute("message9", message9);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("changePasswordadmin.jsp");
                        dispatcher.forward(request, response);
                 
                 
                 }
               
             }else{
             
                 
                String message8="New password and Confirm New password did not matched!!!";
                request.setAttribute("message8", message8);
                RequestDispatcher dispatcher = request.getRequestDispatcher("changePasswordadmin.jsp");
                dispatcher.forward(request, response);
             
             
             }
             
        
        
        
        
        
        
        
        
        }
          catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ChangePasswordServletadmin.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
