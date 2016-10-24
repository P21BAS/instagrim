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
        <h2>Your world in Black and White</h2>
        
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
            <li><a href="/Instagrim/Register/">Register</a></li>
            <li><a href="/Instagrim/Login/">Login</a></li>
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
            <h3>File Upload</h3>
            <form method="POST" enctype="multipart/form-data" action="Image">
                File to upload: <input type="file" name="upfile">
                  <input type="hidden" name="check" value="false"> 
                <br/>
                  <input type="radio" name="filter" value="grey"> Grey Filter<br>
                  <input type="radio" name="filter" value="dark"> Dark Filter<br>
                  <input type="radio" name="filter" value="green"> Green Filter<br>
                  <input type="radio" name="filter" value="none"> No Filter<br>
                <br/>
                <input type="submit" value="Press"> to upload the file!
             
  
            </form>
        </article>
        <footer>
        </footer>
    </body>
</html>
