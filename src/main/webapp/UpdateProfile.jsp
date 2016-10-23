<%-- 
    Document   : UpdateProfile
    Created on : 21-Oct-2016, 11:28:57
    Author     : Brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>GrimInsta</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <h1>GrimInsta ! </h1>
        <h2>Edit Profile</h2>
        
         <nav id="nav">
        <ul class="container">
            <li><a href="/Instagrim">Home</a></li>
            <li><a href="/Instagrim/Upload">Upload</a></li>
                <%
                    LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg != null) {
                        String UserName = lg.getUsername();
                        if (lg.getlogedin()) {
                %>
            <li><a href="/Instagrim/Profile">User Profile</a></li>
            <li><a href="/Instagrim/Images/SAMPLE">Sample Images</a></li>
            <li><a href="/Instagrim/Images/<%=lg.getUsername()%>">Your Images</a></li>
            <li><a href="/Instagrim/Logout" >Logout</a></li>
                <% }
                } else {
                %>
            <li><a href="/Instagrim/Register">Register</a></li>
            <li><a href="/Instagrim/Login">Login</a></li>
            <li><a href="/Instagrim/Images/SAMPLE">Sample Images</a></li>
                <%}%>
        </ul>
    </nav>
        <%--
        <nav id="nav">
            <ul>
                <li class="nav"><a href="/Instagrim">Home</a></li>
                <li class="nav"><a href="/Instagrim/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/Instagrim/Images">Your Images</a></li>
                <li class="nav"><a href="/Instagrim/Images/majed">Sample Images</a></li> 
                <li class=nav"><a href="/Instagrim/logout.jsp">Logout<a/></li>
            </ul>
        </nav>
        --%>
          <article class="container" id="top">
            <h3>Profile Pic Upload</h3>
            <form method="POST" enctype="multipart/form-data" action="Image">
                File to upload: <input type="file" name="upfile"><br/>
                <input type="hidden" name="check" value="true"> 
                <br/>
                <input type="submit" value="Press"> to upload the file!
            </form>
                 <form method="POST"  action="UpdateProfile">
                    <ul>
                        <li>First Name <input type="text" name="firstname"></li>
                        <li>Last Name <input type="text" name="lastname"></li>
                        <li>Date Of Birth <input type="text" name="dateofbirth"></li>
                        <li>Email <input type="email" name="email"></li>
                        <li>User Name <input type="text" name="username"></li>
                        <li>Password <input type="password" name="password"></li>
                    </ul>
                <input type="submit" value="UpdateProfile"> 
            </form>
        </article>
        <footer>
        </footer>
    </body>
</html>
