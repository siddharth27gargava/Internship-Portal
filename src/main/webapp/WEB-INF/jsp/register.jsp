<%-- 
    Document   : register
    Created on : Apr 8, 2023, 8:31:28 PM
    Author     : siddh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Page</h1>
        
        <form action="register-user.htm" method="POST">
          <div class="form-control">
            <label for="username">Username: </label>
            <input type="text" name="username" value="${user.username}" required />
          </div>
          <div class="form-control">
            <label for="password">Password: </label>
            <input type="password" name="password" value="${user.password}" required />
          </div>
          <div class="form-control">
            <label for="role">Role: </label>
            <input type="radio" name="role" id="hrexec" value="hrexecutiverole" checked />
            <label for="hrexec">HR Executive</label>
            <input type="radio" name="role" id="student" value="studentrole" />
            <label for="student">Student</label>
          </div>
          <div class="form-control">
            <button type="submit"><b>REGISTER</b></button>
          </div>
        </form>
    </body>
</html>
