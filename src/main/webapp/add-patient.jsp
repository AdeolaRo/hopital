
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
       <title>Ajouter un Patient</title>
    <%@include file="WEB-INF/bootstrapImport.html" %>

</head>
<body>
<div class="container">
    <h1 class="mt-5">Ajouter un Patient</h1>
    <form action="Patient" method="post">
        <div class="form-group">
            <label for="name">Nom</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="phone">Téléphone</label>
            <input type="text" class="form-control" id="phone" name="phone" required>
        </div>
        <div class="form-group">
            <label for="dob">Date de Naissance</label>
            <input type="date" class="form-control" id="dob" name="dob" required>
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>
</body>
</html>

