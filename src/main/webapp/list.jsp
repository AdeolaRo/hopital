<%@ page import="org.example.hopital.model.Patient" %>
<jsp:useBean id="patients" type="java.util.ArrayList<org.example.hopital.model.Patient>" scope="request"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liste des Patients</title>
    <%@include file="WEB-INF/bootstrapImport.html" %>
</head>

<body>
<div class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 rounded text-bg-dark p-3">
            <h1 class="fw-light">- Dogs List -</h1>
            <hr>
            <% if (!patients.isEmpty()) { %>
            <table class="table table-dark align-middle table-striped text-center">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Téléphone</th>
                    <th>Date de Naissance</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <div class="text-end">
                <tbody>
                <% for (Patient p : patients) {%>
                <tr>
                    <td><%=p.getId()%>
                    </td>
                    <td><%=p.getName()%>
                    </td>
                    <td><%=p.getPhone()%>
                    </td>
                    <td><%=p.getBirthDate()%>
                    </td>
                </tr>
                <% } %>
                </tbody>

                <% } else { %>
                <p>There is no dog in the database yet!</p>
                <% } %>
                <hr>
                    <a href="listPatients?id=<%=patients.get()%>" class="btn btn-warning">Modifier</a>

                    <form action="patient" method="post" class="d-inline">
                        <input type="hidden" name="_method" value="delete">
                        <input type="hidden" name="id" value="${patient.id}">
                        <button type="submit" class="btn btn-danger">Supprimer</button>
                    </form>
            </table>
        </div>
</body>
</html>
