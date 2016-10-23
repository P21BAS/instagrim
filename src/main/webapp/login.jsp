<%-- 
    Document   : login.jsp
    Created on : Sep 28, 2014, 12:04:14 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GrimInsta</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <nav id="nav">
            <li><a href="/Instagrim">Home</a></li>
            <li><a href="/Instagrim/Upload">Upload</a></li>
            <li><a href="/Instagrim/Register">Register</a></li>
            <li><a href="/Instagrim/Login">Login</a></li>
            <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
            
        </nav>
        <div class="wrapper style1 first">
            <article class="container" id="top">
                <header>
                    <h1>GrimInsta!</h1>
                    <h2>Your world in Black and White</h2>
                </header>
                <h3>Login</h3>
                <form method="POST"  action="Login">
                    <ul>
                        <li>User Name <input type="text" name="username"></li>
                        <li>Password <input type="password" name="password"></li>
                    </ul>
                    <br/>
                    <input type="submit" value="Login"> 
                </form>
                <footer>
                  <%--  <ul>
                        <li class="footer"><a href="/Instagrim">Home</a></li>
                    </ul> --%>
                </footer>
            </article>
        </div>
    </body>
</html>
