package com.lesson9;

import java.sql.*;

public class MainAppSQL {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connect();
            // tableQuery();
            // tableInsert();
            //tableUpdate();
            //tableDelete();
            // preparedStatementEx();
            // preparedStatementBatchEx();
            savePoint();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?,?); ");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Can't connect...");
        }
    }

    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void tableQuery() {
        try (ResultSet rs = statement.executeQuery("SELECT * from students")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void tableInsert() {
        // вставка в таблицу
        try {
            statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob4', 100);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void tableUpdate() {
        // обновление данных в таблице
        try {
            statement.executeUpdate("UPDATE students SET  score = 200 WHERE id = 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void tableClear() {
        try {
            statement.executeUpdate("DELETE FROM students");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void tableDelete() {
        try {
            statement.executeUpdate("DELETE FROM students WHERE id = 4");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void preparedStatementEx() {
        try {
            tableClear();
            long time = System.currentTimeMillis();
            connection.setAutoCommit(false);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1, "Bob" + i);
                preparedStatement.setInt(2, 50);
                preparedStatement.executeUpdate();
            }
            connection.commit();
            System.out.println(System.currentTimeMillis() - time);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void preparedStatementBatchEx() {
        try {
            tableClear();
            long time = System.currentTimeMillis();
            connection.setAutoCommit(false);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1, "Bob" + i);
                preparedStatement.setInt(2, 50);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            System.out.println(System.currentTimeMillis() - time);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void savePoint() {
        tableClear();
        try {
            statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 1000);");
            Savepoint sp1 = connection.setSavepoint();
            statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 1000);");
            connection.rollback(sp1);
            statement.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 1000);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
