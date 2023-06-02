package org.example.service;

import org.example.action.ZhurnalAction;
import org.example.dao.DaoException;
import org.example.dao.pevaluationDAO;
import org.example.entity.SelectedMarks;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZhurnalService {
    pevaluationDAO pevaluationDAO;

    public ZhurnalService() {
        pevaluationDAO = new pevaluationDAO();
    }

    public ArrayList<SelectedMarks> getTimeTables(String login) throws Exception {
        return (ArrayList<SelectedMarks>) pevaluationDAO.SelectAllUserMarks(login);
    }
}
