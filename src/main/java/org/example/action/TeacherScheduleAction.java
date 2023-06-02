package org.example.action;

import org.example.dao.*;
import org.example.entity.*;
import org.example.service.StudentScheduleService;
import org.example.service.TeacherScheduleService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TeacherScheduleAction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");

        String login = (String) request.getSession().getAttribute("login");

        String[][] group = new String[10][10];

        TeacherScheduleService service = new TeacherScheduleService();
        try {
            ArrayList<TimeTable> schedule = service.getSchedule(login);
            for (TimeTable item: schedule) {
                group[item.getDay_of_week()][item.getSubject_number()] = item.getSubject_name();
            }

            session.setAttribute("group", group);
            request.getRequestDispatcher("teacher_raspisanie.jsp").forward(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
