package org.example.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constants {
    public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=UniMarks;user=root;password=817bnerfmF1d;encrypt=false;";
    public static Connection connection;
    public static Connection connect() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection(Constants.url);
    }
}
