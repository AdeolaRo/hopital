package org.example.hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hopital.model.User;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("user", new User("John", "abdel"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = (User) getServletContext().getAttribute("user");
        boolean isValidUser = user != null && user.getUsername().equals(username) && user.getPassword().equals(password);

        HttpSession session = req.getSession();

        if (isValidUser) {
            session.setAttribute("isLogged", true);
            resp.sendRedirect("list.jsp");
        } else {
            session.setAttribute("isLogged", false);
            resp.sendRedirect("login.jsp");
        }
    }
}



