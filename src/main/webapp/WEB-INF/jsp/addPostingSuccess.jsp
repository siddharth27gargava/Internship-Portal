<%-- 
    Document   : addPostingSuccess
    Created on : Apr 16, 2023, 10:03:27 PM
    Author     : siddh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
    #left {
        width: 350px;
        overflow: auto;
        float: left;
    }

    .contact {
        margin-left: 50px;
        margin-top: 400px;
        position: fixed;
        color: black;
    }

    .contact a:hover {
        color: green;
        text-shadow: 2px 2px 5px chartreuse;
        font-size: xx-large;
    }
        </style>
    </head>
    <body>
        <h1>Posting Success</h1>
        <div id="left">
                <a href="register-user-get.htm">Register</a><br><br>
                <a href="get-user-logging.htm">Login</a><br><br>
                <a href="add-get.htm">Add-Posting</a><br>
                <a href="viewPosting.htm">View All Postings</a><br><!-- comment -->
                <a href="searchbylocation.htm">View Posting by Location</a><br>
        </div>
        
        <p> The Posting and details added: </p><br><br><!-- comment -->
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>POSITION TITLE</b></td>
                <td><b>COMPANY</b></td>
                <td><b>LOCATION</b></td>
            </tr>
            <tr>
                <td>${posting.position}</td>
                <td>${posting.company}</td>
                <td>${posting.location}</td>
            </tr>
            
        </table>
        
    </body>
</html>
