package org.example.dao;

import org.example.entity.SelectedMarks;
import org.example.entity.pevaluation;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pevaluationDAO implements DAOBase{

    private final static String FIND_ALL = "select * from pevaluation";

    private final static String FIND_BY_ID = "select * from pevaluation where id = ?";

    private final static String Create =
            "insert into pevaluation (id,subject_id,mark,attendance,date,student_id) values((select max(id) from pevaluation)+1,?,?,?,?,?);";
    private final static String Delete =
            "delete from pevaluation where id = ?";
    private final static String Update =
            "update pevaluation set subject_id=?,mark=?,attendance=?,date=?,student_id=? where id = ?";
    private final static String SelectMarks =
            "select pevaluation.mark,psubject.name from pevaluation,psubject\n" +
                    "where \n" +
                    "psubject.id = pevaluation.subject_id\n" +
                    "and \n" +
                    "pevaluation.student_id in (select pstudent.id from pstudent,puser where puser.student_id = pstudent.id and puser.login = ?);\n" +
                    "\n";

    public List SelectAllUserMarks(String login) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<SelectedMarks> selectedMarks = new ArrayList<>();
        Connection connection = Constants.connect();
        PreparedStatement statement = connection.prepareStatement(SelectMarks);
        statement.setString(1, login);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            SelectedMarks temp = new SelectedMarks();
            temp.setMark(resultSet.getInt(1));
            temp.setSubject_name(resultSet.getString(2));
            selectedMarks.add(temp);
        }
        close(statement);
        close(connection);
        return selectedMarks;
    }



    @Override
    public List findAll() throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<pevaluation> pevaluations = new ArrayList<>();
        Connection connection = Constants.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while (resultSet.next()){
            pevaluation temp = new pevaluation();
            temp.setId(resultSet.getInt(1));
            temp.setSubject_id(resultSet.getInt(2));
            temp.setMark(resultSet.getInt(3));
            temp.setAttendance(resultSet.getBoolean(4));
            temp.setDate(resultSet.getDate(5));
            temp.setStudent_id(resultSet.getInt(6));
            pevaluations.add(temp);
        }
        close(statement);
        close(connection);
        return pevaluations;
    }

    @Override
    public Object findEntityById(Object id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Connection connection = Constants.connect();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setInt(1,(Integer) id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        pevaluation temp = new pevaluation();
        temp.setId(resultSet.getInt(1));
        temp.setSubject_id(resultSet.getInt(2));
        temp.setMark(resultSet.getInt(3));
        temp.setAttendance(resultSet.getBoolean(4));
        temp.setDate(resultSet.getDate(5));
        temp.setStudent_id(resultSet.getInt(6));
        close(statement);
        close(connection);
        return temp;
    }

    @Override
    public boolean delete(Object id) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try{
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Delete);
            statement.setInt(1,(Integer) id);
            statement.executeQuery();
            close(statement);
            close(connection);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean create(Object o) throws DaoException, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Create);
            statement.setInt(1, ((pevaluation) o).getSubject_id());
            statement.setInt(2, ((pevaluation) o).getMark());
            statement.setBoolean(3, ((pevaluation) o).isAttendance());
            statement.setDate(4, ((pevaluation) o).getDate());
            statement.setInt(5, ((pevaluation) o).getStudent_id());
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
    public boolean update(Object id,Object o) throws DaoException {
        try {
            Connection connection = Constants.connect();
            PreparedStatement statement = connection.prepareStatement(Update);
            statement.setInt(1, ((pevaluation) o).getSubject_id());
            statement.setInt(2, ((pevaluation) o).getMark());
            statement.setBoolean(3, ((pevaluation) o).isAttendance());
            statement.setDate(4, ((pevaluation) o).getDate());
            statement.setInt(5, ((pevaluation) o).getStudent_id());
            statement.setInt(6, (Integer)id);
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