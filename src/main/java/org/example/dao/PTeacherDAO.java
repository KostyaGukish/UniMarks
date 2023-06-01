package org.example.dao;

import org.example.entity.pteacher;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PTeacherDAO implements TeacherDAO{
    private final static String FIND_ALL = "select * from pteacher";

    private final static String FIND_BY_ID = "select * from pteacher where id = ?";

    private final static String Create =
            "insert into pteacher (id,name,surname,patronymic,subject_id,group_id) values((select max(id) from pteacher)+1,?,?,?,?,?);";
    private final static String Delete =
            "delete from pteacher where id = ?";
    private final static String Update =
            "update pteacher set name=?,surname=?,patronymic=?,subject_id,group_id=? where id = ?;";

    private final static String FIND_BY_LOGIN = "select * from pteacher where pteacher.id = " +
            "(select puser.teacher_id from puser where login = ?)";

    @Override
    public List findAll() throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<pteacher> pteachers = new ArrayList<>();
        Connection connection = Constants.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while (resultSet.next()){

            pteacher temp = new pteacher();
            temp.setId(resultSet.getInt(1));
            temp.setName(resultSet.getString(2));
            temp.setSurname(resultSet.getString(3));
            temp.setPatronymic(resultSet.getString(4));
            temp.setSubject_id(resultSet.getInt(5));
            temp.setGroup_id(resultSet.getInt(6));
            pteachers.add(temp);
        }
        close(statement);
        close(connection);
        return pteachers;
    }

    @Override
    public pteacher findEntityById(int id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = Constants.connect();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
            pteacher temp = new pteacher();
            temp.setId(resultSet.getInt(1));
            temp.setName(resultSet.getString(2));
            temp.setSurname(resultSet.getString(3));
            temp.setPatronymic(resultSet.getString(4));
            temp.setSubject_id(resultSet.getInt(5));
            temp.setGroup_id(resultSet.getInt(6));
        close(statement);
        close(connection);
        return temp;
    }
    public pteacher findEntityByLogin(String login) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = Constants.connect();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        pteacher temp = new pteacher();
        temp.setId(resultSet.getInt(1));
        temp.setName(resultSet.getString(2));
        temp.setSurname(resultSet.getString(3));
        temp.setPatronymic(resultSet.getString(4));
        temp.setSubject_id(resultSet.getInt(5));
        temp.setGroup_id(resultSet.getInt(6));
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
    public boolean create(pteacher o) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Create);
            statement.setString(1, o.getName());
            statement.setString(2, o.getSurname());
            statement.setString(3, o.getPatronymic());
            statement.setInt(4, o.getSubject_id());
            statement.setInt(5, o.getGroup_id());
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
    public boolean update(int id,pteacher o) throws DaoException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Update);
            statement.setInt(6, id);
            statement.setString(1, o.getName());
            statement.setString(2, o.getSurname());
            statement.setString(3, o.getPatronymic());
            statement.setInt(4, o.getSubject_id());
            statement.setInt(5, o.getGroup_id());
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
