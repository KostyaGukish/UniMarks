package org.example.service;

import org.example.dao.DaoException;
import org.example.dao.PStudentDAO;
import org.example.dao.PTeacherDAO;
import org.example.dao.PUserDao;
import org.example.entity.pstudent;
import org.example.entity.pteacher;
import org.example.entity.puser;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class LoginService {
    PUserDao pUserDao;
    PStudentDAO pStudentDAO;

    public LoginService(){
        this.pUserDao = new PUserDao();
        this.pStudentDAO = new PStudentDAO();
    }

    public String getPassword(String username) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        puser tryPuser = pUserDao.findEntityById(username);
        return tryPuser.getPassword();
    }

    public boolean isStudent(String username) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        puser tryPuser = pUserDao.findEntityById(username);
        return tryPuser.getStudent_id() != 0;
    }

    public int getStudentId(String username) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        puser tryPuser = pUserDao.findEntityById(username);
        return tryPuser.getStudent_id();
    }

    public int getTeacherId(String username) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        puser tryPuser = pUserDao.findEntityById(username);
        return tryPuser.getTeacher_id();
    }

    public String getName(String username) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        puser tryPuser = pUserDao.findEntityById(username);
        if (this.isStudent(username)) {
            PStudentDAO pStudentDAO = new PStudentDAO();
            pstudent stud = pStudentDAO.findEntityById(this.getStudentId(username));
            return stud.getSurname() + stud.getName() + stud.getPatronymic();
        } else {
            PTeacherDAO pTeacherDAO = new PTeacherDAO();
            pteacher teach = pTeacherDAO.findEntityById(this.getTeacherId(username));
            return teach.getSurname() + teach.getName() + teach.getPatronymic();
        }
    }
}
