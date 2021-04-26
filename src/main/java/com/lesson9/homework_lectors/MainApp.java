/**
Задача на основе разметки класса и его полей аннотациями, создать в базе таблицу и заполнить ее значениями полей класса.
Т.е. выполнить запрос вида: CREATE TABLE cats (id INTEGER, name TEXT, age INTEGER)
*/

package com.lesson9.homework_lectors;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MainApp {
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        connect();
        Cat cat = new Cat(1, "Vaska", 5);
        //createTable(Cat.class);
        try {
            addToTable(cat);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void createTable(Class cs) {
        if(!cs.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("There's no table...");
        }

        Map<Class, String> map = new HashMap<>();
        map.put(int.class, "INTEGER");
        map.put(String.class, "TEXT");
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(((Table) cs.getAnnotation(Table.class)).title()); // CREATE TABLE cats
        sb.append(" ("); // CREATE TABLE cats (

        Field[] fields = cs.getDeclaredFields();
        for(Field o: fields) {
            if(o.isAnnotationPresent(Column.class)) {
                sb.append(o.getName()) // CREATE TABLE cats (id
                .append(" ")
                .append(map.get(o.getType())) // CREATE TABLE cats (id INTEGER
                .append(", ");

            }
        }
        sb.setLength(sb.length()-2);
        sb.append(");");
        try {
            statement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addToTable(Object o) throws SQLException, IllegalAccessException {
        // INSERT INTO cats (id, name, age) VALUES (?, ?, ?);
        if(!o.getClass().isAnnotationPresent(Table.class)) { // 1. Проверяем что переданный класс является таблицей
            throw new RuntimeException("There's no table...");
        }
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(o.getClass().getAnnotation(Table.class).title()) // INSERT INTO cats
                .append(" (");
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field f: fields) {
            if(f.isAnnotationPresent(Column.class)) {
                sb.append(f.getName()); // если поле помечено аннотацией - аппендим его имя
                sb.append(", ");
            }
        }
        sb.setLength(sb.length()-2); // убираем лишнюю запятую
        sb.append(") VALUES (");

        for(Field f: fields) {
            if(f.isAnnotationPresent(Column.class)) {
                sb.append("?, "); // добавляем ? по колличеству аннотаций
            }
        }
        sb.setLength(sb.length()-2);
        sb.append(");");
        System.out.println(sb);
        preparedStatement = connection.prepareStatement(sb.toString()); // создаем preparedStatement вида

        int index = 1;
        for(Field f: fields) {
            if(f.isAnnotationPresent(Column.class)) {
                preparedStatement.setObject(index++, f.get(o));
            }
        }
        preparedStatement.executeUpdate();

    }

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    static void disconnect() {
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


}
