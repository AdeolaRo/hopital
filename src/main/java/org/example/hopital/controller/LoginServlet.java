package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hopital.model.User;

import java.io.IOException;


public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        User user1 = new User("John", "abdel");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isValidUser = true;

        if (isValidUser) {
            resp.sendRedirect("listPatients.jsp");
        } else {
            resp.sendRedirect("connexion.jsp");
        }
    }
}

