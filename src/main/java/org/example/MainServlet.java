package org.example;

import org.example.action.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet({"", "/LoginServlet", "/zhurnal", "/raspisanie", "/teacher_raspisanie", "/teacher-zhurnal"})
public class MainServlet extends HttpServlet {
    static Logger logger = LogManager.getLogger(MainServlet.class.getName());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURL().toString().equals("http://localhost:8081/LoginServlet")) {
            logger.log(Level.INFO, "LoginServlet");
            LoginAction loginAction = new LoginAction();
            loginAction.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/")) {
            logger.log(Level.INFO, "/");
            InitialPageAction initialPage = new InitialPageAction();
            initialPage.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/zhurnal")) {
            logger.log(Level.INFO, "zhurnal");
            ZhurnalAction zhurnalAction = new ZhurnalAction();
            zhurnalAction.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/raspisanie")) {
            logger.log(Level.INFO, "raspisanie");
            StudentScheduleAction studentScheduleAction = new StudentScheduleAction();
            studentScheduleAction.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher_raspisanie")) {
            logger.log(Level.INFO, "teacher_raspisanie");
            TeacherScheduleAction teacherScheduleAction = new TeacherScheduleAction();
            teacherScheduleAction.doGet(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher-zhurnal")) {
            logger.log(Level.INFO, "teacher-zhurnal");
            TeacherZhurnalAction teacherZhurnalAction = new TeacherZhurnalAction();
            teacherZhurnalAction.doGet(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURL().toString().equals("http://localhost:8081/LoginServlet")) {
            logger.log(Level.INFO, "LoginServlet");
            LoginAction loginAction = new LoginAction();
            loginAction.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/")) {
            logger.log(Level.INFO, "/");
            InitialPageAction initialPage = new InitialPageAction();
            initialPage.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/zhurnal")) {
            logger.log(Level.INFO, "zhurnal");
            ZhurnalAction zhurnalAction = new ZhurnalAction();
            zhurnalAction.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/raspisanie")) {
            logger.log(Level.INFO, "raspisanie");
            StudentScheduleAction studentScheduleAction = new StudentScheduleAction();
            studentScheduleAction.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher_raspisanie")) {
            logger.log(Level.INFO, "teacher_raspisanie");
            TeacherScheduleAction teacherScheduleAction = new TeacherScheduleAction();
            teacherScheduleAction.doPost(request, response);
        }
        if (request.getRequestURL().toString().equals("http://localhost:8081/teacher-zhurnal")) {
            logger.log(Level.INFO, "teacher-zhurnal");
            TeacherZhurnalAction teacherZhurnalAction = new TeacherZhurnalAction();
            teacherZhurnalAction.doPost(request, response);
        }
    }
}
