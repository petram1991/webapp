package org.example.servlets;

import org.example.dao.GebruikerDao;
import org.example.domain.Gebruiker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registratieresponse")
public class RegistratieResponseServlet extends HttpServlet {

    private final GebruikerDao dao = GebruikerDao.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("aanmelding.jsp").forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        Gebruiker gebruiker = dao.getPersoonByEmail(email);

        request.setAttribute("persoon", gebruiker);
        request.getRequestDispatcher("aanmelding.jsp").forward(request, response);
    }
}
