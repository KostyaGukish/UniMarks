package org.example.action;

import org.example.dao.pevaluationDAO;
import org.example.entity.SelectedMarks;
import org.example.service.TeacherZhurnalService;
import org.example.service.ZhurnalService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TeacherZhurnalAction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        TeacherZhurnalService service = new TeacherZhurnalService();
        try {
            String login = (String) request.getSession().getAttribute("login");

            ArrayList<String> students = service.getStudents(login);
            request.setAttribute("students", students);
            int group = service.getGroup(login);
            request.setAttribute("group", group);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("teacher-zhurnal.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
