package org.example.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool instance = null;
    private static ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }


    //  public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=UniMarks;user=root;password=817bnerfmF1d;encrypt=false;";
    // public static Connection connection;
    public static Connection getConnection() throws Exception {
        Context ctx = null;
        DataSource dataSource = null;
        Connection c = null;
        try{
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/testpool");
            ctx = new InitialContext();
            c = dataSource.getConnection();
            return c;
        }catch (Exception e){
            throw e;
        }
    }
}