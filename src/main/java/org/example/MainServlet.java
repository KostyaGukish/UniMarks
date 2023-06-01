package org.example;

import org.example.action.InitialPageAction;
import org.example.action.LoginAction;
import org.example.action.StudentScheduleAction;
import org.example.action.ZhurnalAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"", "/LoginServlet", "/zhurnal", "/raspisanie"})
public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURL().toString().equals("http://localhost:8081/LoginServlet")) {
            LoginAction loginAction = new LoginAction();
            loginAction.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/")) {
            InitialPageAction initialPage = new InitialPageAction();
            initialPage.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/zhurnal")) {
            ZhurnalAction zhurnalAction = new ZhurnalAction();
            zhurnalAction.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/raspisanie")) {
            StudentScheduleAction studentScheduleAction = new StudentScheduleAction();
            studentScheduleAction.doGet(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURL().toString().equals("http://localhost:8081/LoginServlet")) {
            LoginAction loginAction = new LoginAction();
            loginAction.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/")) {
            InitialPageAction initialPage = new InitialPageAction();
            initialPage.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/zhurnal")) {
            ZhurnalAction zhurnalAction = new ZhurnalAction();
            zhurnalAction.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/raspisanie")) {
            StudentScheduleAction studentScheduleAction = new StudentScheduleAction();
            studentScheduleAction.doPost(request, response);
        }
    }
}
