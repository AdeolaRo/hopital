package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hopital.dao.PatientDAO;
import org.example.hopital.model.Patient;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/createPatient")
public class CreatePatientServlet extends HttpServlet {
    private final PatientDAO patientDAO = new PatientDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("name");
        String phone = req.getParameter("phone");
        String birthDate = req.getParameter("birthDate");
        String photo = req.getParameter("photo");

        Patient patient = new Patient();
        patient.setName(nom);
        patient.setPhone(phone);
        patient.setBirthDate(LocalDate.parse(birthDate));
        patient.setPhoto(photo);

        patientDAO.save(patient);
        resp.sendRedirect("listPatients");
    }
}
