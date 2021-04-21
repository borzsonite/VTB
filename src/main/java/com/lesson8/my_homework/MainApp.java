package com.lesson8.my_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
 * встречающееся;
 * 2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
 * среднюю зарплату сотрудника;
 * 3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
 * сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
 * имя1, имя2, имяN;”.
 */

public class MainApp {
    public static void main(String[] args) {
        Arrays.stream(new String[]{"aa", "bb", "cc", "dd", "aa"}).distinct().count();

        User[] users = {
                new User("Bob", 20, 10000),
                new User("Mike", 15, 20000),
                new User("Kate", 10, 10000),
                new User("Paul", 30, 20000),
                new User("Jane", 12, 23000),

        };

        //  * 2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
        // * среднюю зарплату сотрудника;
        double res = Arrays.stream(users).mapToInt(User::getSalary).average().getAsDouble();
        System.out.println(res);


        getNOldestUsers(users, 3);
    }


   //  3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
   //  сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
   //  имя1, имя2, имяN;”.
   static void getNOldestUsers(User[] users, int n) {

        String res = Arrays.stream(users)
               .sorted(Comparator.comparingInt(User::getAge))
               .skip(Math.abs(n-users.length))
               .map(o -> o.getName())
               .collect(Collectors.joining(", ", n + " самых старших сотрудников зовут: ", ";"));
       System.out.println(res);
    };
}

class User {
    private String name;
    private int age;
    private int salary;

    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
