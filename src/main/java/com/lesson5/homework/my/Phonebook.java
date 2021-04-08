package com.lesson5.homework.my;

import java.util.*;

/**
 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
 телефонных номеров. В этот телефонный справочник с помощью метода add() можно
 добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
 учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.  Желательно не добавлять
 лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем
 через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного
 справочника.
 */

public class  Phonebook {
    private Map<String, ArrayList<String>> data = new HashMap<>();

    void add(String name, String number) {
        data.putIfAbsent(name, new ArrayList<>()); // если пары нет, добавляем
        data.get(name).add(number); // тут это имя уже есть, по любому и в него добавляется телефон
    }

    ArrayList<String> get(String name) {
        return data.getOrDefault(name, new ArrayList<>()); // возвращается либо лист по имеющейся фамилии, либо пустой лист
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Jhon", "12345");
        phonebook.add("Jhon1", "123456");
        phonebook.add("Jhon2", "123457");
        phonebook.add("Jhon", "123458");

        System.out.println(phonebook.get("Jhon1"));
    }
}
