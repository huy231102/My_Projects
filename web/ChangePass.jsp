<%-- 
    Document   : ChangePass
    Created on : Nov 3, 2023, 10:41:40 PM
    Author     : HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="changePass" method="post">
            <h1 style="color:red;">${mess}</h1>
            Current pass:<input type="password" name="pass3" value=""><br/>
            New pass:<input type="password" name="pass1" value=""><br/>
            Re-enter new pass:<input type="password" name="pass2" value=""><br/>
            <input type="submit" name="change" value="Change"><br/> 
        </form> 
    </body>
</html>
