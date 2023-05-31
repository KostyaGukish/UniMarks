package org.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Установка типа контента и кодировки
        response.setContentType("text/html;charset=UTF-8");
        // Перенаправление на страницу login.jsp
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
}
