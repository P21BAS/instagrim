<%-- 
    Document   : UserProfile
    Created on : 18-Oct-2016, 15:47:07
    Author     : Brian
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Profile</title>
        <link rel="stylesheet" type="text/css" href="/Instagrim/Styles.css" />
   
    </head>
    <body>
       <nav id="nav">
        <ul class="container">
            <li><a href="/Instagrim">Home</a></li>
            <li><a href="/Instagrim/upload.jsp">Upload</a></li>
                <%
                    LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                    ProfileStore ps = (ProfileStore) session.getAttribute("ProfileStore");
                    if (lg != null) {
                        String UserName = lg.getUsername();
                        if (lg.getlogedin()) {
                %>
            <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
            <li><a href="/Instagrim/Images/<%=lg.getUsername()%>">Your Images</a></li>
            <li><a href="/Instagrim/Logout">Logout</a></li>
                <% }
                } else {
                %>
            <li><a href="/Instagrim/register.jsp">Register</a></li>
            <li><a href="/Instagrim/login.jsp">Login</a></li>
            <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
                <%}%>
        </ul>
    </nav>
      <%--  <nav id="nav">
            <ul>
                <li class="nav"><a href="/Instagrim">Home</a></li>
                <li class="nav"><a href="/Instagrim/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/Instagrim/register.jsp">Register</a></li>
                <li class="nav"><a href="/Instagrim/login.jsp">Login</a></li>
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li>
            </ul>
        </nav> --%>
        <div class="wrapper style1 first">
            <article class="container" id="top">
                <header>
                    <h1>GrimInsta ! </h1>
                    <h2>Your world in Black and White</h2>
                </header>
                <article>
                    <h1>Your Pics</h1>
                   
                    <a class="image featured" href="/Instagrim/Image/<%=ps.getSUUID()%>" ><img src="/Instagrim/Thumb/<%=ps.getSUUID()%>"></a><br/>

                       
                       
                </article>
                <footer>
                </footer>
            </article>
        </div>
    </body>
</html>
