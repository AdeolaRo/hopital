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

@WebServlet("/patient")
public class PatientServlet extends HttpServlet {
    private final PatientDAO patientDAO = new PatientDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("_method");
        if ("delete".equals(action)) {
            Long id = Long.parseLong(req.getParameter("id"));
            patientDAO.delete(id);
        } else {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String birthDate = req.getParameter("birthDate");
            String photo = req.getParameter("photo");

            Patient patient = new Patient();
            if (id != null && !id.isEmpty()) {
                patient.setId(Long.parseLong(id));
            }
            patient.setName(name);
            patient.setPhone(phone);
            patient.setBirthDate(LocalDate.parse(birthDate));
            patient.setPhoto(photo);

            if (id == null || id.isEmpty()) {
                patientDAO.save(patient);
            } else {
                patientDAO.update(patient);
            }
        }
        resp.sendRedirect("listPatients");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Patient patient = patientDAO.findById(id);
        req.setAttribute("patient", patient);
        req.getRequestDispatcher("/WEB-INF/views/editPatient.jsp").forward(req, resp);
    }
}
