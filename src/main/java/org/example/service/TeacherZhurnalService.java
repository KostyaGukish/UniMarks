package org.example.service;

import org.example.dao.DaoException;
import org.example.dao.PStudentDAO;
import org.example.dao.PTeacherDAO;
import org.example.entity.pstudent;
import org.example.entity.pteacher;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherZhurnalService {

    PTeacherDAO pTeacherDAO;
    PStudentDAO pStudentDAO;

    public TeacherZhurnalService() {
        pTeacherDAO = new PTeacherDAO();
        pStudentDAO = new PStudentDAO();
    }

    public ArrayList<String> getStudents(String login) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        pteacher teacher = pTeacherDAO.findEntityByLogin(login);
        ArrayList<pstudent> students = (ArrayList<pstudent>) pStudentDAO.getByGroup(teacher.getGroup_id());
        ArrayList<String> strings = new ArrayList<>();
        for (pstudent student: students) {
            strings.add(student.getSurname() + student.getName() + student.getPatronymic());
        }
        return strings;
    }

    public int getGroup(String login) throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        pteacher teacher = pTeacherDAO.findEntityByLogin(login);
        return teacher.getGroup_id();
    }
}
