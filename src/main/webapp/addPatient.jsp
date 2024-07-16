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
    <form action="createPatient" method="post">
        <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom">Prénom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" required>
        </div>
        <div class="form-group">
            <label for="phone">Téléphone</label>
            <input type="text" class="form-control" id="phone" name="phone" required>
        </div>
        <div class="form-group">
            <label for="dateNaissance">Date de Naissance</label>
            <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" required>
        </div>
        <div class="form-group">
            <label for="photo">Photo</label>
            <input type="text" class="form-control" id="photo" name="photo">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
    <a href="listPatients" class="btn btn-secondary mt-3">Retour à la liste</a>
</div>
</body>
</html>
