<%-- 
    Document   : hrhome
    Created on : Apr 14, 2023, 10:37:43 AM
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
        <h1>HR Executive Home</h1>
        <div id="left">
                <a href="register-user-get.htm">Register</a><br><br>
                <a href="get-user-logging.htm">Login</a><br><br>
                <a href="add-get.htm">Add-Posting</a><br>
                <a href="viewPosting.htm">View All Postings</a><br><!-- comment -->
                <a href="searchbylocation.htm">View Posting by Location</a><br>
        </div>
    </body>
</html>
