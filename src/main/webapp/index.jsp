<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>GrimInsta</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
    </head>
    <body>
    <nav id="nav">
        <ul class="container">
            <li><a href="/Instagrim">Home</a></li>
            <li><a href="/Instagrim/upload.jsp">Upload</a></li>
                <%
                    LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg != null) {
                        String UserName = lg.getUsername();
                        if (lg.getlogedin()) {
                %>
            <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
            <li><a href="/Instagrim/Images/<%=lg.getUsername()%>">Your Images</a></li>
            <li><a href="/Instagrim/Logout" >Logout</a></li>
            <li><a href="/Instagrim/UserProfile.jsp">User Profile</a></li>
                <% }
                } else {
                %>
            <li><a href="/Instagrim/register.jsp">Register</a></li>
            <li><a href="/Instagrim/login.jsp">Login</a></li>
            <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
                <%}%>
        </ul>
    </nav>
    <div class="wrapper style1 first">
        <article class="container" id="top">
            <div class="row">
                <div class="8u 12u(mobile)">
                    <header>
                        <h1>Welcome to <strong>GrimInsta</strong>.</h1>
                    </header>
                    <p>GrimInsta is an example web app using Cassandra as a back end.   The app allows picture uploads, creates a thumbnail and 
                        a  B/W version of the picture, and a simple login.</p>
                      <%
                    LoggedIn lgn = (LoggedIn) session.getAttribute("LoggedIn");
                    if (lg != null) {
                        String UserName = lg.getUsername();
                        if (lg.getlogedin()) {
                %>
                    
                        <% }
                } else {
                %>
                <a href="register.jsp" class="button big scrolly">Sign Up</a>
                <%}%>
                </div>
            </div>
            <footer>
                <ul id="copyright">
                    <li class="footer">&COPY; Andy C & Brian S</li>
                </ul>
            </footer>
        </article>
    </div>
</body>
</html>
