package org.example;

import org.example.dao.DaoException;
import org.example.dao.PUserDao;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение значения введенного имени пользователя и фамилии из запроса
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Проверка наличия пользователя в базе данных (здесь нужно добавить свою логику для проверки в базе данных)
        boolean userExists = false;
        try {
            userExists = checkUserExists(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DaoException e) {
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

        if (userExists) {
            // Получение объекта HttpSession
            HttpSession session = request.getSession();

            // Сохранение имени и фамилии пользователя в атрибуты сессии
            session.setAttribute("username", username);
             // Здесь вы можете использовать вашу логику для получения фамилии
            // Перенаправление на следующую страницу
            response.sendRedirect("Page1.jsp");
        } else {
            // Если пользователь не существует, отправляем ошибку и сообщение об ошибке на страницу входа
            //response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Неверный логин или пароль");
        }
    }

    // Пример метода для проверки наличия пользователя в базе данных (здесь нужно добавить свою логику)
    private boolean checkUserExists(String username, String password) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PUserDao pUserDao = new PUserDao();
        puser tryPuser =  pUserDao.findEntityById(username);
        if(tryPuser.getPassword().equals(password)){
            return true;
        }
        else return false;
    }
}
