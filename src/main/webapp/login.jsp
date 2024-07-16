<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <%@include file="WEB-INF/bootstrapImport.html" %>
</head>
<body>
<div class="container">
    <div>
        <h3>Login</h3>
    </div>
    <form action="login" method="post">
        <div class="text-center">
            <label for="username">Utilisateur:</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">Mot de Passe:</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </form>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <p><%= request.getAttribute("errorMessage") %></p>
    <% } %>
</div>
</body>
</html>

