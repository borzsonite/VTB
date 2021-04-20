package com.lesson8.my_homework;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
 встречающееся;
 2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
 среднюю зарплату сотрудника;
 3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
 сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
 имя1, имя2, имяN;”.
*/

public class MainApp {
    public static void main(String[] args) {
        Arrays.stream(new String[]{"aa", "bb", "cc", "dd", "aa"}).distinct().count();
    }
}
