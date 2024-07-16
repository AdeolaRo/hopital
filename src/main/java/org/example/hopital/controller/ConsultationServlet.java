package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import org.example.hopital.model.Consultation;
import org.example.hopital.dao.ConsultationDAO;
import org.example.hopital.dao.PatientDAO;
import org.example.hopital.model.Patient;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/createConsultation")
public class ConsultationServlet extends HttpServlet {
    private ConsultationDAO consultationDAO = new ConsultationDAO();
    private PatientDAO patientDAO = new PatientDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long patientId = Long.parseLong(request.getParameter("patientId"));
        Patient patient = patientDAO.findById(patientId);

        String dateConsultationStr = request.getParameter("dateConsultation");
        String nomMedecin = request.getParameter("nomMedecin");
        String prescription = request.getParameter("prescription");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateConsultation = null;
        try {
            dateConsultation = dateFormat.parse(dateConsultationStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Consultation consultation = new Consultation();
        consultation.setDateConsultation(dateConsultation);
        consultation.setNomMedecin(nomMedecin);
        consultation.setPrescription(prescription);
        consultation.setPatient(patient);

        consultationDAO.create(consultation);

        response.sendRedirect("patientDetails?id=" + patientId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long patientId = Long.parseLong(request.getParameter("patientId"));
        request.setAttribute("patientId", patientId);
        request.getRequestDispatcher("/WEB-INF/views/createConsultation.jsp").forward(request, response);
    }
}
