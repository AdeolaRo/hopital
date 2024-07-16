package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hopital.dao.PatientDAO;
import org.example.hopital.model.Patient;

import java.io.IOException;
import java.util.List;

@WebServlet("/listPatients")
public class ListePatientsServlet extends HttpServlet {
    private final PatientDAO patientDAO = new PatientDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Patient> patients = patientDAO.findAll();
        req.setAttribute("patients", patients);
        req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
    }
}
