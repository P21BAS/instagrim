/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.models.User;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    Cluster cluster=null;
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("userExists", false);
        request.setAttribute("passwordValid", false);
        
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
    
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
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname"); 
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String dateofbirth=request.getParameter("dateofbirth");

        
        User us=new User();
        us.setCluster(cluster);
        
        if(us.checkforexistinguser(username) == true){
            request.setAttribute("userExists", true);
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.forward(request, response);
        }else if(us.checkforexistinguser(username) == false){
           
        
        
        
        if(us.RegisterUser(firstname, lastname, username, password,dateofbirth,email) == false){
        request.setAttribute("passwordValid", true);
//        out.print(firstname, lastname, username, password, email, dateofbirth,email);
	RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("passwordValid", false);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
