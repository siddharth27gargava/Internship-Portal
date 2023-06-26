<%-- 
    Document   : addPosting
    Created on : Apr 16, 2023, 1:13:32 PM
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
        <h1>Add Posting</h1>
        <div id="left">
                <a href="register-user-get.htm">Register</a><br><br>
                <a href="get-user-logging.htm">Login</a><br><br>
                <a href="add-get.htm">Add-Posting</a><br>
                <a href="viewPosting.htm">View All Postings</a><br><!-- comment -->
                <a href="searchbylocation.htm">View Posting by Location</a><br>
        </div>
        
        <form action="posting-add.htm" method="POST">
          <div class="form-control">
            <label for="position">Position Title: </label>
            <input type="text" name="position" value="${posting.position}" required />
          </div>
            <div class="form-control">
                <label for="company">Company: </label>
                <input type="text" name="company" value="${posting.company}" required />
            </div><!-- comment -->
          <div class="form-control">
            <label for="location">Location: </label>
            <input type="text" name="location" value="${posting.location}" required />
          </div>
          <div class="form-control">
            <button type="submit"><b>POST</b></button>
          </div>
        </form><br><br><br><br>
         <h1>Searching by keyword</h1>
            <form action="searchbylocation.htm" method="post">
            <label for="keyword">KeyWord:</label>
            <input type="text" id="keyword" name="keyword"><br><br>
            <input type="radio" name="radio" value="location" checked>
            <label for="category">Search By Location</label><br><br>
            <input type="radio" name="radio" value="company">
            <label for="category">Search By Company</label><br><br>
            <input type="radio" name="radio" value="position">
            <label for="category">Search By Position</label><br><br>
            <input type="submit" value="SEARCH">
       
    </body>
</html>
