package org.example.hopital.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet(name = "checkSessionServlet",value = "/have-session")
public class CheckSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        boolean logged = (session.getAttribute("isLogged")!= null) ? (boolean) session.getAttribute("isLogged") : false;

        if(!logged){
           resp.sendRedirect("connexion.jsp");
        }else {
            resp.sendRedirect("listPatients.jsp");
        }
    }
}
