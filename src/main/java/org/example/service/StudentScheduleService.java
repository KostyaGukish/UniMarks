package org.example.service;

import org.example.dao.DaoException;
import org.example.dao.PScheduleDAO;
import org.example.entity.TimeTable;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentScheduleService {
    PScheduleDAO pScheduleDAO;

    public StudentScheduleService() {
        pScheduleDAO = new PScheduleDAO();
    }

    public ArrayList<TimeTable>  getSchedule(String login) throws Exception {
        return (ArrayList<TimeTable>) pScheduleDAO.findTimeTableForUser(login);
    }
}
