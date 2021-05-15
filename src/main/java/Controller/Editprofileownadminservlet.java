/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.connection.Action;
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

/**
 *
 * @author HP Omen 15-dc0079tx
 */
@WebServlet("/Editprofileownadminservlet")
public class Editprofileownadminservlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editprofileadminservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Editprofileadminservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
         
        
         
         
         
        User user = null;
        try {
            
            user = Action.getUser(username);
            
              
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Editprofileownadminservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
         request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Editprofileownadmin.jsp");
        dispatcher.forward(request, response);
        
       
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
