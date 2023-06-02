package org.example.service;

import org.example.dao.DaoException;
import org.example.dao.PScheduleDAO;
import org.example.entity.TimeTable;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeacherScheduleServiceTest {

    TeacherScheduleService service = new TeacherScheduleService();
    @Test
    void getSchedule() throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String login = "t15";
        PScheduleDAO pScheduleDAO = new PScheduleDAO();
        ArrayList<TimeTable> timeTable = (ArrayList<TimeTable>) pScheduleDAO.findTimeTableForUser(login);;
        timeTable.add(new TimeTable());
        ArrayList<TimeTable> timeTableTrue = service.getSchedule(login);

        for (int i = 0; i < timeTable.size() - 1; i++) {
            TimeTable t1 = timeTableTrue.get(i);
            TimeTable t2 = timeTable.get(i);
            Assert.assertEquals(t1.getDay_of_week(), t2.getDay_of_week());
            Assert.assertEquals(t1.getSubject_number(), t2.getSubject_number());
            Assert.assertEquals(t1.getSubject_name(), t2.getSubject_name());
            Assert.assertEquals(t1.getPteacher_surname(), t2.getPteacher_surname());
        }
    }
}