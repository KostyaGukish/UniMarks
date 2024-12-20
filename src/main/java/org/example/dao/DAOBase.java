package org.example.dao;

import javax.naming.NamingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface DAOBase < K,T > {
    List<T> findAll() throws Exception, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NamingException;
    T findEntityById(K id) throws Exception, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    boolean delete(K id) throws Exception, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    boolean create(T t) throws Exception, SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    boolean update(K id,T O) throws Exception;
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