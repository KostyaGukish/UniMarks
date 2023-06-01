package org.example.dao;

import org.example.entity.puser;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PUserDao implements UserDAO{
    private final static String FIND_ALL = "select * from puser";

    private final static String FIND_BY_ID = "select * from puser where login = ?";

    private final static String Create =
            "insert into puser (login,password,teacher_id,student_id) values(?,?,?,?);";
    private final static String Delete =
            "delete from puser where login = ?";
    private final static String Update =
            "update puser set password=?,teacher_id=?,student_id=? where login = ?";

    @Override
    public List findAll() throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<puser> pusers = new ArrayList<>();
        Connection connection = Constants.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while (resultSet.next()){
            puser temp = new puser();
            temp.setLogin(resultSet.getString(1));
            temp.setPassword(resultSet.getString(2));
            temp.setTeacher_id(resultSet.getInt(3));
            temp.setStudent_id(resultSet.getInt(4));
            pusers.add(temp);
        }
        close(statement);
        close(connection);
        return pusers;
    }

    @Override
    public puser findEntityById(String id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = Constants.connect();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
            puser temp = new puser();
            temp.setLogin(resultSet.getString(1).replace(" ", ""));
            temp.setPassword(resultSet.getString(2).replace(" ", ""));
            temp.setTeacher_id(resultSet.getInt(3));
            temp.setStudent_id(resultSet.getInt(4));
        close(statement);
        close(connection);
        return temp;
    }

    @Override
    public boolean delete(String id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try{
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Delete);
            statement.setString(1, id);
            statement.executeQuery();
            close(statement);
            close(connection);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean create(puser o) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Create);
            statement.setString(1, o.getLogin());
            statement.setString(2, o.getPassword());
            statement.setInt(3, o.getTeacher_id());
            statement.setInt(4, o.getStudent_id());
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
    public boolean update(String id,puser o) throws DaoException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Update);
            statement.setString(4, o.getLogin());
            statement.setString(1, o.getPassword());
            statement.setInt(2, o.getTeacher_id());
            statement.setInt(3, o.getStudent_id());
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
