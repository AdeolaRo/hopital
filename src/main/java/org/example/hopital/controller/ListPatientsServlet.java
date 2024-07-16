package org.example.hopital.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hopital.dao.PatientDAO;
import org.example.hopital.model.Patient;


import jakarta.servlet.annotation.WebServlet;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

@WebServlet("/listPatients")
public class ListPatientsServlet extends HttpServlet {
    private PatientDAO patientDAO = new PatientDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = patientDAO.findAll();
        req.setAttribute("patients", patients);
        req.getRequestDispatcher("/WEB-INF/views/listPatients.jsp").forward(req, resp);
    }
}
