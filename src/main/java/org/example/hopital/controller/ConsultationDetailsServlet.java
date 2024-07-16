package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import org.example.hopital.model.Consultation;
import org.example.hopital.dao.ConsultationDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/consultationDetails")
public class ConsultationDetailsServlet extends HttpServlet {
    private ConsultationDAO consultationDAO = new ConsultationDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long consultationId = Long.parseLong(request.getParameter("id"));
        Consultation consultation = consultationDAO.find(consultationId);
        request.setAttribute("consultation", consultation);
        request.getRequestDispatcher("/WEB-INF/views/consultationDetails.jsp").forward(request, response);
    }
}
