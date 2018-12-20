package kpi.db;


import java.sql.*;

import java.sql.DriverManager;

public class ConnectionToDB {
    private static Connection connection;
    private static Statement statement;

    private static ConnectionToDB ourInstance = new ConnectionToDB();

    public static ConnectionToDB getThisObject() {
        return ourInstance;
    }

    public static boolean setConnection(String login, String password) {
        try
        {
            Connection connection = DriverManager.getConnection(User.getUser().getUrl(), login, password);
            Statement statement = connection.createStatement();
            setConnection(connection);
            setStatement(statement);
            User.getUser().setLogin(login);
            User.getUser().setPassword(password);
        }
        catch (SQLException ex)
        {
            return false;
        }
        return true;
    }

    private ConnectionToDB() {
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement(Statement statement) {
        ConnectionToDB.statement = statement;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectionToDB.connection = connection;
    }
}
