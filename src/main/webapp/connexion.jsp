<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login Page</title>
    <%@include file="WEB-INF/bootstrapImport.html" %>

</head>
<body>

<div class="container">
<div >
    <h3>Login</h3>
</div>
    <form action="LoginServlet" method="post">
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

    <% if (request.getAttribute("Bienvenue") != null) { %>
    <p><%= request.getAttribute("Désolez ! Veuillez contacter l'Admin !") %></p>
    <% } %>

</div>
</body>
</html>
