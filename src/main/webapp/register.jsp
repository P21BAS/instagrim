<%-- 
    Document   : register.jsp
    Created on : Sep 28, 2014, 6:29:51 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instagrim</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <nav id="nav">
            <li><a href="/Instagrim">Home</a></li>
            <li><a href="upload.jsp">Upload</a></li>
            <li><a href="register.jsp">Register</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="/Instagrim/Images/majed">Sample Images</a></li>
        </nav>
        <div class="wrapper style1 first">
            <article class="container" id="top">
                <header>
                    <h1>GrimInsta!</h1>
                    <h2>Your world in Black and White</h2>
                </header>
                <h3>Register as user</h3>
                <form method="POST"  action="Register">
                    <ul>
                        <li>First Name <input type="text" name="firstname"></li>
                        <li>Last Name <input type="text" name="lastname"></li>
                        <li>Date Of Birth <input type="text" name="dateofbirth"></li>
                        <li>Email <input type="email" name="email"></li>
                        <li>User Name <input type="text" name="username"></li>
                        <li>Password <input type="password" name="password  "></li>
                    </ul>
                    <input type="submit" value="Register"> 
                </form>
                <footer>
                    <ul id="copyright">
                        <li class="footer"><a href="/Instagrim">Home</a></li>
                    </ul>
                </footer>
            </article>
        </div>
    </body>
</html>
