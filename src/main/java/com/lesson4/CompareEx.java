package com.lesson4;

import java.util.*;

public class CompareEx {
    /**
     Задача отсортировать коллекцию по собственному алгоритму (по длине строки)
     Это можно сделать двумя путями:
     1. вызывать у коллекции метод sort(Comparator<? super T> c)
     2. вызвать у утильного класса Collections метод sort(Collection c, Comparator <? super T> c) переадав в него коллекцию и компаратор
    */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "BBB", "CC", "GGGGG", "YYYY"));
        list.sort((o1, o2) -> o1.length() - o2.length()); // Способ 1
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length()); // Способ 2

        System.out.println(list);
    }
}
