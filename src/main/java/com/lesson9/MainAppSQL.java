package com.lesson9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainAppSQL {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            Statement statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Can't connect...");
        }
    }

    public static void disconnect() {
        try {
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        try{
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
