package org.example.service;

import org.example.dao.DaoException;
import org.example.dao.PScheduleDAO;
import org.example.dao.pevaluationDAO;
import org.example.entity.SelectedMarks;
import org.example.entity.TimeTable;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ZhurnalServiceTest {

    ZhurnalService service = new ZhurnalService();
    @Test
    void getTimeTables() throws SQLException, DaoException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String login = new String("s15");
        pevaluationDAO pevaluationDAO = new pevaluationDAO();
        ArrayList<SelectedMarks> SelectedMarks1 = (ArrayList<SelectedMarks>) pevaluationDAO.SelectAllUserMarks(login);
        ArrayList<SelectedMarks> SelectedMarks2 = service.getTimeTables(login);

        for (int i = 0; i < SelectedMarks1.size() - 1; i++) {
            SelectedMarks t1 = SelectedMarks1.get(i);
            SelectedMarks t2 = SelectedMarks2.get(i);
            Assert.assertEquals(t1.getSubject_name(), t2.getSubject_name());
            Assert.assertEquals(t1.getMark(), t2.getMark());
        }
    }
}