package com.lesson5.homework.my;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
 * вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 */

public class MainApp {
    public static void main(String[] args) {
        String[] words = {"Кот", "Ямщик", "Ящик", "Письмо", "Птица", "Птица", "Слон", "Лыжи", "Кот", "Собака", "Гвоздь", "Собака", "Кот", "Слон", "Собака"};
        Map<String, Integer> data = new LinkedHashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!data.containsKey(words[i])) {
                data.put(words[i], 1);
            } else {
                data.put(words[i], data.get(words[i]) + 1);
            }
        }
        data.forEach((x, y) -> System.out.println(x + ": " + y));
    }
}
