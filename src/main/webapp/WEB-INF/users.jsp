<%-- 
    Document   : users
    Created on : Mar. 11, 2022, 6:39:42 p.m.
    Author     : peony Liu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Users</h1>
        
        <table class="table">
            <thead>
                <tr>
                    <th>Email:</th> 
                    <th>First Name:</th> 
                    <th>Last Name:</th> 
                </tr>
            </thead>
            
            
            <tbody>
                
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${users.email}</td>
                        <td>${users.fname}</td>
                        <td>${users.lname}</td>
                    </tr>
                    
                </c:forEach>
            </tbody>
            
            
            
        </table>
        
    </body>
</html>
