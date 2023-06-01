package org.example;

import org.example.dao.DaoException;
import org.example.dao.PStudentDAO;
import org.example.dao.PTeacherDAO;
import org.example.dao.PUserDao;
import org.example.entity.pstudent;
import org.example.entity.pteacher;
import org.example.entity.puser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    String name;
    String entity;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            session.setAttribute("loggedInUser", name);
            session.setAttribute("entity", entity);
            // Здесь вы можете использовать вашу логику для получения фамилии
            // Перенаправление на следующую страницу
            response.sendRedirect("Page1.jsp");
        } else {
            request.setAttribute("javax.servlet.error.message", "Неверный логин или пароль");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Пример метода для проверки наличия пользователя в базе данных (здесь нужно добавить свою логику)
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
                } else {
                    PTeacherDAO pTeacherDAO = new PTeacherDAO();
                    pteacher teach = pTeacherDAO.findEntityById(tryPuser.getTeacher_id());
                    name = teach.getSurname() + teach.getName() + teach.getPatronymic();
                    entity = "Учитель:";
                }
                return true;
            }
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
