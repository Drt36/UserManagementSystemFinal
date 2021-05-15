/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.connection.Action;
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
@WebServlet("/Editprofileownadminservletfinal")
public class Editprofileownadminservletfinal extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editprofileadminservletfinal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Editprofileadminservletfinal at " + request.getContextPath() + "</h1>");
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
        
        

                Action ac=new Action(); 
        try {
            //updating details
            ac.updateUser(username,first_name,last_name,role,phone_number,address,birthdate,gender);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Editprofileownadminservletfinal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      //storing activity history
        HttpSession session=request.getSession();
             String sescon = (String)session.getAttribute("user");
           Date outtime = new Date();
           String datetime =outtime.toString();
    
           StoreHistory sh=new StoreHistory();
        try {
            sh.storeHistory(sescon,"Profile updated.",datetime);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Editprofileownadminservletfinal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         String messg2 = "User details are Updated Successfully!!!";
        request.setAttribute("messg2", messg2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Profileadmin.jsp");
        dispatcher.forward(request, response);
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
