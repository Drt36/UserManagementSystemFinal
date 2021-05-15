/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.connection.Action;
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
@WebServlet("/Deletehistoryadmin")
public class Deletehistoryadmin extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Deletehistoryadmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Deletehistoryadmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email=request.getParameter("email");
        Action ac=new Action();
        try {
            //calling delete history method
            ac.deleteHistory(email);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Deletehistoryuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String messg8 = "All history cleaned!!!";
        request.setAttribute("messg8", messg8);

        RequestDispatcher dispatcher = request.getRequestDispatcher("historyadmin.jsp");
        dispatcher.forward(request, response);
        
        
        
        
        
        
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
