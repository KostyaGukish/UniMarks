package org.example.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("")
public class InitialPageService extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Перенаправление на страницу login.jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Перенаправление на страницу login.jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
