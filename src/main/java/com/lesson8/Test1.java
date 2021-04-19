package com.lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> out = list.stream().filter((o) -> o % 2 == 0).collect(Collectors.toList());
        System.out.println(out);

        list.stream().filter((o) -> o % 2 == 1).forEach(integer -> System.out.print(integer + " "));

        Stream.of("AA", "D", "CCC", "NN").map(s -> s.length()).forEach(System.out::println);
        Stream.of(1, 2, 3, 4).map(s -> s + 1).forEach(System.out::println);

        Stream.of("aa", "bb").map(String::length).forEach(System.out::println); // для каждого объекта типа String в потоке вызвать метод .length()
        Stream.of("aa", "bb").map(s -> s.length()).forEach(System.out::println); // то же самое

        Stream.of("Bob", "Mike", "Jhon").map(User::new).forEach(User::getName); // для каждого объекта типа User в потоке вызвать метод new() т.е. конструктор, а затем метод .getName();
        Stream.of("Bob", "Mike", "Jhon").map(s-> new User(s)).forEach(s -> s.getName()); // то же самое


        // distinct example
        Arrays.asList(1,2,3,4,1,2,2).stream().distinct().forEach(System.out::println); // 1 2 3 4
        Arrays.asList("Jhon", "Mike", "Jhon").stream().distinct().forEach(System.out::println); // Jhon Mike

        //math example
        System.out.println(Arrays.asList(1,2,3,4,5,6,7).stream().allMatch(s -> s > 0)); // true. Все элементы больше 0
        System.out.println(Arrays.asList(1,2,3,4,5,6,7).stream().anyMatch(s -> s > 10)); // false. Хоть один элмент стрима больше 10
        System.out.println(Arrays.asList(1,2,3,4,5,6,7).stream().noneMatch(s -> s == 7)); // false. Не один элемент не равен 7



    }
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println(name);;
    }
}
