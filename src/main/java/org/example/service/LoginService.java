package org.example.service;

import org.example.dao.PStudentDAO;
import org.example.dao.PTeacherDAO;
import org.example.dao.PUserDao;
import org.example.entity.pstudent;
import org.example.entity.pteacher;
import org.example.entity.puser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginService extends HttpServlet {
    String name;
    String entity;
    String rasp;
    String jorney;
    String login;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение значения введенного имени пользователя и фамилии из запроса
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Проверка наличия пользователя в базе данных (здесь нужно добавить свою логику для проверки в базе данных)
        boolean userExists = false;
        try {
            userExists = checkUserExists(username, password);
        } catch (Exception e) {
            request.setAttribute("javax.servlet.error.message", null);
        }

        if (userExists) {
            // Получение объекта HttpSession
            HttpSession session = request.getSession();

            // Сохранение имени и фамилии пользователя в атрибуты сессии
            session.setAttribute("login", login);
            session.setAttribute("loggedInUser", name);
            session.setAttribute("entity", entity);
            session.setAttribute("rasp1", rasp);
            session.setAttribute("jorney1", jorney);
            // Здесь вы можете использовать вашу логику для получения фамилии
            // Перенаправление на следующую страницу
            response.sendRedirect("Page1.jsp?login=" + login);
        } else {
            request.setAttribute("javax.servlet.error.message", "Неверный логин или пароль");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private boolean checkUserExists(String username, String password) throws Exception {
        PUserDao pUserDao = new PUserDao();
        try {
            puser tryPuser = pUserDao.findEntityById(username);
            if (tryPuser.getPassword().equals(password)) {
                if (tryPuser.getStudent_id() != 0) {
                    PStudentDAO pStudentDAO = new PStudentDAO();
                    pstudent stud = pStudentDAO.findEntityById(tryPuser.getStudent_id());
                    name = stud.getSurname() + stud.getName() + stud.getPatronymic();
                    entity = "Студент:";
                    rasp = "raspisanie.jsp";
                    jorney = "zhurnal.jsp";
                    rasp = "raspisanie";
                    jorney = "zhurnal";
                    login = username;
                } else {
                    PTeacherDAO pTeacherDAO = new PTeacherDAO();
                    pteacher teach = pTeacherDAO.findEntityById(tryPuser.getTeacher_id());
                    name = teach.getSurname() + teach.getName() + teach.getPatronymic();
                    entity = "Учитель:";
                    rasp = "teacher_raspisanie.jsp";
                    jorney = "teacher-zhurnal.jsp";
                    login = username;
                }
                return true;
            }
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
