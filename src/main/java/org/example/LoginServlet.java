package org.example;

import org.example.dao.PUserDao;
import org.example.entity.puser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Установка типа контента и кодировки
        response.setContentType("text/html;charset=UTF-8");
        // Перенаправление на страницу login.jsp
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userlogin = request.getParameter("username");
        String password = request.getParameter("password");
        PUserDao pUserDao = new PUserDao();
        try {
            puser tryPuser =  pUserDao.findEntityById(userlogin);
            if(tryPuser.getPassword().equals(password)){
                request.getRequestDispatcher("/Page1.jsp").forward(request, response);
                // request.setAttribute("res", delta);
            }
            else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Неверный логин или пароль");
            }
        } catch (Exception e) {
            response.getWriter().print("fdfsdgsdg");
            //response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Неверный логин или пароль");
        }

    }
}
