package org.example.servlets;

import org.example.domain.Gebruiker;
import org.example.dao.GebruikerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registreer")
public class RegistreerServlet extends HttpServlet {

    private GebruikerDao gebruikerDao = GebruikerDao.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String voornaam = request.getParameter("voornaam");
        String achternaam = request.getParameter("achternaam");
        String email = request.getParameter("email");

        System.out.println(voornaam);
        System.out.println(achternaam);
        System.out.println(email);

        Gebruiker gebruiker = new Gebruiker(voornaam, achternaam, email);
        gebruikerDao.add(gebruiker);

        request.getSession().setAttribute("voornaam", gebruiker.getVoornaam());

        request.setAttribute("persoon", gebruiker);
        request.getRequestDispatcher("/registratieresponse").forward(request, response);
    }

}
