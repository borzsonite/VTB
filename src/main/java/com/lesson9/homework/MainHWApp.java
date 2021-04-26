package com.lesson9.homework;

import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Field;
import java.sql.*;

public class MainHWApp {
    static Connection connection;
    static PreparedStatement preparedStatement;

    public static void main(String[] args) {

        Student student1 = new Student(1, "Bob Marley", 50);
        Student student2 = new Student(2, "Elvis", 60);
        Student student3 = new Student(3, "Curt", 55);
        connect();
        try {
            annotationProcessor(student1);
            annotationProcessor(student2);
            annotationProcessor(student3);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void annotationProcessor(Student student) throws IllegalAccessException, SQLException {
        Class classStudent = student.getClass();
        if (!classStudent.getSimpleName().equals("Student")) {
            System.out.println("Class format exception");
        } else {
            Field[] fields = classStudent.getDeclaredFields();
            for (Field f : fields) {
                if (f.getAnnotation(Column.class) != null) {
                    String columnName = f.getAnnotation(Column.class).columnName();
                    switch (columnName) {
                        case "id": {
                            f.setAccessible(true);
                            preparedStatement.setInt(1, (int) f.get(student));
                        }
                        break;
                        case "name": {
                            f.setAccessible(true);
                            preparedStatement.setString(2, (String) f.get(student));
                        }
                        break;
                        case "score": {
                            f.setAccessible(true);
                            preparedStatement.setInt(3, (int) f.get(student));
                        }
                    }
                }
            }
            preparedStatement.executeUpdate();
        }
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            preparedStatement = connection.prepareStatement("INSERT INTO students (id, name, score) VALUES (?,?,?)");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
