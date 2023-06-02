package org.example.dao;


import org.example.entity.pstudent;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PStudentDAO implements StudentDAO{
    private final static String FIND_ALL = "select * from pstudent";

    private final static String FIND_BY_GROUP = "select * from pstudent where group_id = ? and id <> 0";

    private final static String FIND_BY_ID = "select * from pstudent where id = ?";

    private final static String Create =
            "insert into pstudent (id,name,surname,patronymic,group_id) values((select max(id) from pstudent)+1,?,?,?,?);";
    private final static String Delete =
            "delete from pstudent where id = ?";
    private final static String Update =
            "update pstudent set name=?,surname=?,patronymic=?,group_id=? where id = ?";

    @Override
    public List findAll() throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<pstudent> pteachers = new ArrayList<>();
        Connection connection = ConnectionPool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while (resultSet.next()){
            pstudent temp = new pstudent();
            temp.setId(resultSet.getInt(1));
            temp.setName(resultSet.getString(2));
            temp.setSurname(resultSet.getString(3));
            temp.setPatronymic(resultSet.getString(4));
            temp.setGroup_id(resultSet.getInt(5));
            pteachers.add(temp);
        }
        close(statement);
        close(connection);
        return pteachers;
    }

    public List getByGroup(int group) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = ConnectionPool.getConnection();
        List<pstudent> students = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_GROUP);
        statement.setInt(1,group);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            pstudent temp = new pstudent();
            temp.setId(resultSet.getInt(1));
            temp.setName(resultSet.getString(2));
            temp.setSurname(resultSet.getString(3));
            temp.setPatronymic(resultSet.getString(4));
            temp.setGroup_id(resultSet.getInt(5));
            students.add(temp);
        }
        close(statement);
        close(connection);
        return students;
    }

    @Override
    public pstudent findEntityById(int id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        pstudent temp = new pstudent();
        temp.setId(resultSet.getInt(1));
        temp.setName(resultSet.getString(2));
        temp.setSurname(resultSet.getString(3));
        temp.setPatronymic(resultSet.getString(4));
        temp.setGroup_id(resultSet.getInt(5));
        close(statement);
        close(connection);
        return temp;
    }

    @Override
    public boolean delete(int id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try{
            Connection connection = ConnectionPool.getConnection();
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
    public boolean create(pstudent o) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(Create);
            statement.setString(1, o.getName());
            statement.setString(2, o.getSurname());
            statement.setString(3, o.getPatronymic());
            statement.setInt(4, o.getGroup_id());
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
    public boolean update(int id,pstudent o) throws DaoException {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(Update);
            statement.setInt(5, id);
            statement.setString(1, o.getName());
            statement.setString(2, o.getSurname());
            statement.setString(3, o.getPatronymic());
            statement.setInt(4, o.getGroup_id());
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
