package org.example;

import org.example.action.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"", "/LoginServlet", "/zhurnal", "/raspisanie", "/teacher_raspisanie", "/teacher-zhurnal"})
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
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher_raspisanie")) {
            TeacherScheduleAction teacherScheduleAction = new TeacherScheduleAction();
            teacherScheduleAction.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher-zhurnal")) {
            TeacherZhurnalAction teacherZhurnalAction = new TeacherZhurnalAction();
            teacherZhurnalAction.doGet(request, response);
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
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher_raspisanie")) {
            TeacherScheduleAction teacherScheduleAction = new TeacherScheduleAction();
            teacherScheduleAction.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher-zhurnal")) {
            TeacherZhurnalAction teacherZhurnalAction = new TeacherZhurnalAction();
            teacherZhurnalAction.doPost(request, response);
        }
    }
}
