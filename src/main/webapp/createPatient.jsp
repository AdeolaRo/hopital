<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <title>Create Patient</title>
    <%@include file="WEB-INF/bootstrapImport.html" %>

</head>
<body>

<div class="container">

    <h2>Créer un Patient</h2>
    <form action="createPatient" method="post">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="prenom" required><br>

        <label for="dateNaissance">Date de naissance:</label>
        <input type="date" id="dateNaissance" name="dateNaissance" required><br>

        <label for="photo">Photo:</label>
        <input type="text" id="photo" name="photo"><br>

        <input type="submit" value="Create">
    </form>

    <a href="patient-list">Back to list</a>

</div>
</body>
</html>

