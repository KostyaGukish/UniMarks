package org.example.action;

import org.example.dao.*;
import org.example.entity.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class StudentScheduleAction extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");

        String login = (String) request.getSession().getAttribute("login");

        String[][] predmet = new String[10][10];
        String[][] teacher = new String[10][10];

        PScheduleDAO pScheduleDAO = new PScheduleDAO();
        try {
            ArrayList<TimeTable> schedule = new ArrayList<>(pScheduleDAO.findTimeTableForUser(login));
            for (TimeTable item: schedule) {
                predmet[item.getDay_of_week()][item.getSubject_number()] = item.getSubject_name();
                teacher[item.getDay_of_week()][item.getSubject_number()] = item.getPteacher_surname();
            }

            session.setAttribute("predmet", predmet);
            session.setAttribute("teacher", teacher);
            request.getRequestDispatcher("raspisanie.jsp").forward(request, response);
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
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}