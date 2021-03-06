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
import javax.servlet.http.HttpSession;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.models.User;
import uk.ac.dundee.computing.aec.instagrim.stores.*;
/**
 *
 * @author Brian
 */


    
@WebServlet(name = "UpdateProfile", urlPatterns = {"/UpdateProfile"})
public class UpdateProfile extends HttpServlet {
       Cluster cluster=null;
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("UpdateProfile.jsp");
            rd.forward(request, response);
    
    }


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
            out.println("<title>Servlet UpdateProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfile at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession session = request.getSession();
        
        String first_name=request.getParameter("firstname");
        String last_name=request.getParameter("lastname"); 
        
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String dateofbirth=request.getParameter("dateofbirth");
        
        User us=new User();
        us.setCluster(cluster);
        LoggedIn lg =(LoggedIn)session.getAttribute("LoggedIn");
        ProfileStore ps = (ProfileStore) session.getAttribute("profilepic");
        String username = lg.getUsername();
        
        
        java.util.UUID picid = us.selectProfilePic(username);
                
//                if(first_name.isEmpty()){
//                    first_name=lg.getUserFName();
//                }
//                
//                 if(last_name.isEmpty()){
//                    last_name=lg.getUserLName();
//                }
//                 
//                  if(email.isEmpty()){
//                    email=lg.getUserEmail();
//                }
//                  
                  us.UpdateUser(username, first_name, last_name, email, password);
                  
                  
                  lg.update(first_name, last_name, email);
                  ps.setUUID(picid);
                  
                  request.setAttribute("LoggedIn", lg);
                  session.setAttribute("LoggedIn", lg);
                  session.setAttribute("profilepic", ps);
     

        RequestDispatcher rd = request.getRequestDispatcher("UserProfile.jsp");
            rd.forward(request, response);
                  
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
