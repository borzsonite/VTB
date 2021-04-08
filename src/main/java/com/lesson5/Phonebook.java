package com.lesson5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
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
