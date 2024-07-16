package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import org.example.hopital.dao.PatientDAO;
import org.example.hopital.model.Patient;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patientDetails")
public class PatientDetailsServlet extends HttpServlet {
    private PatientDAO patientDAO = new PatientDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long patientId = Long.parseLong(request.getParameter("id"));
        Patient patient = patientDAO.find(patientId);
        request.setAttribute("patient", patient);
        request.getRequestDispatcher("/WEB-INF/views/patientDetails.jsp").forward(request, response);
    }
}
