package org.example.dao;

import org.example.entity.pschedule;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PScheduleDAO implements ScheduleDAO{
    private final static String FIND_ALL = "select * from pschedule";

    private final static String FIND_BY_ID = "select * from pschedule where id = ?";

    private final static String Create =
            "insert into pschedule (id,group_id,subject_id,week_day,number) values((select max(id) from pschedule)+1,?,?,?,?);";
    private final static String Delete =
            "delete from pschedule where id = ?";
    private final static String Update =
            "update pschedule set group_id=?,subject_id=?,week_day=?,number=? where id = ?";

    @Override
    public List findAll() throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<pschedule> schedules = new ArrayList<>();
        Connection connection = Constants.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while (resultSet.next()){
            pschedule temp = new pschedule();
            temp.setId(resultSet.getInt(1));
            temp.setGroup_id(resultSet.getInt(2));
            temp.setSubject_id(resultSet.getInt(3));
            temp.setWeek_day(resultSet.getInt(4));
            temp.setNumber(resultSet.getInt(5));
            schedules.add(temp);
        }
        close(statement);
        close(connection);
        return schedules;
    }

    @Override
    public pschedule findEntityById(int id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = Constants.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_BY_ID);
        pschedule temp = new pschedule();
        temp.setId(resultSet.getInt(1));
        temp.setGroup_id(resultSet.getInt(2));
        temp.setSubject_id(resultSet.getInt(3));
        temp.setWeek_day(resultSet.getInt(4));
        temp.setNumber(resultSet.getInt(5));
        close(statement);
        close(connection);
        return temp;
    }

    @Override
    public boolean delete(int id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try{
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Delete);
            statement.setInt(1, id);
            statement.executeQuery();
            close(statement);
            close(connection);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean create(pschedule o) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Create);
            statement.setInt(2, o.getGroup_id());
            statement.setInt(3, o.getSubject_id());
            statement.setInt(4, o.getWeek_day());
            statement.setInt(5, o.getNumber());
            statement.executeQuery();
            close(statement);
            close(connection);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(int id,pschedule o) throws DaoException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Update);
            statement.setInt(6, id);
            statement.setInt(2, o.getGroup_id());
            statement.setInt(3, o.getSubject_id());
            statement.setInt(4, o.getWeek_day());
            statement.setInt(5, o.getNumber());
            statement.executeQuery();
            close(statement);
            close(connection);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
