package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hopital.model.Patient;
import org.example.hopital.dao.PatientDAO;


import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/Patient")
public class PatientServlet extends HttpServlet {
    PatientDAO patientDAO;

    @Override
    public void init() throws ServletException {
        patientDAO = new PatientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/listpatient.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("_method");
        if (method == null) {
            method = "post";
        }

        switch (method.toLowerCase()) {
            case "put":
                doPut(request, response);
                break;
            case "delete":
                doDelete(request, response);
                break;
            default:
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String dob = request.getParameter("dob");

                Patient patient = new Patient();
                patient.setName(name);
                patient.setPhone(phone);
                patient.setBirthDate(LocalDate.parse(dob));
                patient.setFile("file");

                patientDAO.create(patient);

                response.sendRedirect("listPatients");
        }

        }
    }

