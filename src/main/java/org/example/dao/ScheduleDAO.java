package org.example.dao;

import org.example.entity.pschedule;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface ScheduleDAO {
    List<pschedule> findAll() throws Exception ;
    pschedule findEntityById(int id) throws Exception ;
    boolean delete(int id) throws Exception;
    boolean create(pschedule t) throws Exception;
    boolean update(int id,pschedule O) throws Exception;
    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            // log
        }
    }
    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close(); // or connection return code to the pool
            }
        } catch (SQLException e) {
            // log
        }
    }
}
