package org.example.dao;

import org.example.entity.pgroup;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PGroupDAO implements GroupDAO{
    private final static String FIND_ALL = "select * from pgroup";

    private final static String FIND_BY_ID = "select * from pgroup where id = ?";

    private final static String Create =
            "insert into pgroup (id,GroupDescription) values((select max(id) from pgroup)+1,?);";
    private final static String Delete =
            "delete from schedule where id = ?";
    private final static String Update =
            "update schedule set GroupDescription=? where id = ?";

    @Override
    public List findAll() throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<pgroup> pgroups = new ArrayList<>();
        Connection connection = Constants.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while (resultSet.next()){
            pgroup temp = new pgroup();
            temp.setId(resultSet.getInt(1));
            temp.setGroupDescription(resultSet.getString(2));
            pgroups.add(temp);
        }
        close(statement);
        close(connection);
        return pgroups;
    }

    @Override
    public pgroup findEntityById(int id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = Constants.connect();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        pgroup temp = new pgroup();
        temp.setId(resultSet.getInt(1));
        temp.setGroupDescription(resultSet.getString(2));
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
    public boolean create(pgroup o) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Create);
            statement.setString(1, o.getGroupDescription());
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
    public boolean update(int id,pgroup o) throws DaoException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Update);
            statement.setInt(2, id);
            statement.setString(1, o.getGroupDescription());
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
