<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <title>Liste des Patients</title>
    <%@include file="WEB-INF/bootstrapImport.html" %>

</head>
<body>
<div class="container">
    <h1 class="mt-5">Liste des Patients</h1>
    <a href="add-patient" class="btn btn-primary mb-3">Ajouter un Patient</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Téléphone</th>
            <th>Date de Naissance</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var ="patient" items="${listPatient}">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.name}</td>
                <td>${patient.phone}</td>
                <td>${patient.dob}</td>
                <td>
                    <a href="edit-patient.jsp?id=${patient.id}" class="btn btn-warning">Modifier</a>
                    <form action="patient" method="post" class="d-inline">
                        <input type="hidden" name="_method" value="delete">
                        <input type="hidden" name="id" value="${patient.id}">
                        <button type="submit" class="btn btn-danger">Supprimer</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

