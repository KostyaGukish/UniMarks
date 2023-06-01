package org.example.dao;

import org.example.entity.psubject;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PSubjectDAO implements SubjectDAO{
    private final static String FIND_ALL = "select * from psubject";

    private final static String FIND_BY_ID = "select * from psubject where id = ?";

    private final static String Create =
            "insert into psubject (id,name) values((select max(id) from psubject)+1,?);";
    private final static String Delete =
            "delete from psubject where id = ?";
    private final static String Update =
            "update psubject set name=? where id = ?";

    @Override
    public List findAll() throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<psubject> psubjects = new ArrayList<>();
        Connection connection = Constants.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while (resultSet.next()){
            psubject temp = new psubject();
            temp.setId(resultSet.getInt(1));
            temp.setName(resultSet.getString(2));
            psubjects.add(temp);
        }
        close(statement);
        close(connection);
        return psubjects;
    }

    @Override
    public psubject findEntityById(int id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = Constants.connect();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        psubject temp = new psubject();
        temp.setId(resultSet.getInt(1));
        temp.setName(resultSet.getString(2));
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
    public boolean create(psubject o) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Create);
            statement.setString(1, o.getName());
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
    public boolean update(int id,psubject o) throws DaoException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Update);
            statement.setInt(2, id);
            statement.setString(1, o.getName());
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
