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

    public void add(String name, String phone) {
        if(data.containsKey(name)) {
             data.get(name).add(phone);
        }
        data.put(name, );
    }

    public List<String> get(String name) {
        List<String> result = new ArrayList<>();
        data.forEach((key, value) -> {
            if(value.equals(name)) {
                result.add(name+":"+key + "\n");
            }
        });
        return result;
    }
}

class   AppRunner {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Bob", "12345");
        phonebook.add("Jhon", "54321");
        phonebook.add("Mike", "67891");
        phonebook.add("Kate", "32165");
        phonebook.add("Lory", "54986");
        phonebook.add("Bob", "98756");
        phonebook.add("Bob", "98787");

        System.out.println(phonebook.get("Bob"));
    }


}
