package com.lesson5;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "A"));
        Iterator<String> iterator = list.iterator(); // 1. Создаем итератор
        while(iterator.hasNext()) { // 2. пока в коллекции есть следующее значение
            if(iterator.next().equals("A")) {
                iterator.remove();
            }
        }
        System.out.println(list);

        Map<Integer, String> map = new HashMap<>();
        map.entrySet().iterator();

        list.listIterator().nextIndex();
    }
}
