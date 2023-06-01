package org.example;

import org.example.service.InitialPageService;
import org.example.service.LoginService;
import org.example.service.StudentScheduleService;
import org.example.service.ZhurnalService;

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
            LoginService loginService = new LoginService();
            loginService.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/")) {
            InitialPageService initialPage = new InitialPageService();
            initialPage.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/zhurnal")) {
            ZhurnalService zhurnalService = new ZhurnalService();
            zhurnalService.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/raspisanie")) {
            StudentScheduleService studentScheduleService = new StudentScheduleService();
            studentScheduleService.doGet(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURL().toString().equals("http://localhost:8081/LoginServlet")) {
            LoginService loginService = new LoginService();
            loginService.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/")) {
            InitialPageService initialPage = new InitialPageService();
            initialPage.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/zhurnal")) {
            ZhurnalService zhurnalService = new ZhurnalService();
            zhurnalService.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/raspisanie")) {
            StudentScheduleService studentScheduleService = new StudentScheduleService();
            studentScheduleService.doPost(request, response);
        }
    }
}
