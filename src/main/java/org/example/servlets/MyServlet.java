package org.example.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("MyServlet.GET");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("MyServlet.POST");
    }
}
