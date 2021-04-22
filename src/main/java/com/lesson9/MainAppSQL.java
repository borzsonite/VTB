package com.lesson9;

import java.sql.Connection;
import java.sql.Statement;

public class MainAppSQL {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {

    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
