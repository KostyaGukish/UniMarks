package org.example.service;

import org.example.dao.DaoException;
import org.example.dao.PScheduleDAO;
import org.example.dao.PStudentDAO;
import org.example.dao.PTeacherDAO;
import org.example.entity.pstudent;
import org.example.entity.pteacher;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeacherZhurnalServiceTest {

    TeacherZhurnalService service = new TeacherZhurnalService();
    @Test
    void getStudents() throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String login = new String("t15");
        PTeacherDAO pTeacherDAO = new PTeacherDAO();
        pteacher teacher = pTeacherDAO.findEntityByLogin(login);
        PStudentDAO pStudentDAO = new PStudentDAO();
        ArrayList<pstudent> students = (ArrayList<pstudent>) pStudentDAO.getByGroup(teacher.getGroup_id());
        ArrayList<String> students1 = new ArrayList<>();
        for (pstudent student: students) {
            students1.add(student.getSurname() + student.getName() + student.getPatronymic());
        }
        ArrayList<String> students2 = service.getStudents(login);

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(students1.get(i), students2.get(i));
        }
    }

    @Test
    void getGroup() throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 1; i <= 50; i++) {
            StringBuilder login = new StringBuilder("t");
            login.append(i);
            int group = i / 10 + 1;
            if (i % 10 == 0) {
                group--;
            }
            System.out.println(group);
            Assert.assertEquals(service.getGroup(login.toString()), group);
        }
    }
}