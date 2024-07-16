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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/createPatient")
public class CreatePatientServlet extends HttpServlet {
    private PatientDAO patientDAO;

    @Override
    public void init() throws ServletException {
         patientDAO = new PatientDAO();
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients", patientDAO.findAll());
        req.getRequestDispatcher("createPatient.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        String phone = req.getParameter("phone");
        String birthDate = req.getParameter("birthDate");
        String photo = req.getParameter("photo");

        Patient patient = new Patient(name,phone, LocalDate.parse(birthDate) ,photo );

        patientDAO.save(patient);

        resp.sendRedirect("list.jsp");
    }
}
