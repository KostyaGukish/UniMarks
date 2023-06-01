package org.example.action;

import org.example.dao.PStudentDAO;
import org.example.dao.PTeacherDAO;
import org.example.dao.PUserDao;
import org.example.entity.pstudent;
import org.example.entity.pteacher;
import org.example.entity.puser;
import org.example.service.LoginService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginAction extends HttpServlet {
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
            LoginService service = new LoginService();
            if (service.getPassword(username).equals(password)) {
                HttpSession session = request.getSession();
                if (service.isStudent(username)) {
                    session.setAttribute("entity", "Студент:");
                    session.setAttribute("rasp1", "raspisanie");
                    session.setAttribute("jorney1", "zhurnal");
                } else {
                    session.setAttribute("entity", "Учитель:");
                    session.setAttribute("rasp1", "teacher_raspisanie.jsp");
                    session.setAttribute("jorney1", "teacher-zhurnal.jsp");
                }
                name = service.getName(username);
                session.setAttribute("login", username);
                session.setAttribute("loggedInUser", name);
                response.sendRedirect("Page1.jsp?login=" + username);
            } else {
                request.setAttribute("javax.servlet.error.message", "Неверный логин или пароль");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("javax.servlet.error.message", null);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
