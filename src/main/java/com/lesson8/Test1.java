package com.lesson8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        Stream.of("Bob", "Mike", "Jhon").map(s -> new User(s)).forEach(s -> s.getName()); // то же самое


        // distinct example
        Arrays.asList(1, 2, 3, 4, 1, 2, 2).stream().distinct().forEach(System.out::println); // 1 2 3 4
        Arrays.asList("Jhon", "Mike", "Jhon").stream().distinct().forEach(System.out::println); // Jhon Mike

        //math example
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().allMatch(s -> s > 0)); // true. Все элементы больше 0
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().anyMatch(s -> s > 10)); // false. Хоть один элмент стрима больше 10
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream().noneMatch(s -> s == 7)); // false. Не один элемент не равен 7

        // findAny example
        System.out.println("findAny example");
        Arrays.asList(1, 2, 3, 4, 5).stream().filter(o -> o > 15).findAny().ifPresent(System.out::println); //
        Optional<Integer> opt = Arrays.asList(1, 2, 3, 4, 5).stream().filter(o -> o > 15).findAny();
        System.out.println(opt);

        // mapping example

        Function<String, Integer> function0 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Consumer<Integer> consumer = System.out::println;
        Consumer<Integer> consumer1 = s -> System.out.print(s);

        Stream.of(1,2,3,4,5,1,2,3,4,5).forEach(consumer);
        Stream.of(1,2,3,4,5,1,2,3,4,5).forEach(consumer1);

        // reduce();
        System.out.println("reduce example");
        System.out.println(Stream.of(1,2,3,4).reduce(0, (a,b) -> a+b));


        // mapToInt example
        System.out.println("mapToInt example");
        Stream.of(new User2("Bob", 20)).mapToInt(User2::getAge).forEach(System.out::println);

        // Задача посчитать длину каждой строки в файле
        System.out.println("Задача посчитать длину каждой строки в файле");
        try {
           Files.lines(Paths.get("123.txt")).map(String::length).forEach(System.out::println); // .lines() возвращает стрим Стрингов
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Задача посчитать количество уникальных слов в строке.
        System.out.println("Задача посчитать количество уникальных слов в строке.");
       long count =  Stream.of("aa bb cc aa b b".split("\\s")).distinct().count();
        System.out.println("---------------------------------------------------------");
        Stream.of("aa bb cc aa b b".split("\\s")).distinct().forEach(System.out::println);

        System.out.println(count);

        // Задача вывести уникальные элементы, разделенные запятыми, с префиксом - "Уникальные данные" и суффиксом - точкой.
        System.out.println("Задача вывести уникальные элементы, разделенные запятыми, с префиксом - \"Уникальные данные\" и суффиксом - точкой. ");
        System.out.println(Stream.of("a", "b", "c", "a","b", "d").distinct().collect(Collectors.joining(",", "Уникальные данные:", ".")));



        Function<String, Integer> function = (str) -> {
            return str.length();
        };

        Function<String, Integer> function1 = String::length;

        System.out.println(function0.apply("Hello"));
        }
    }

class User {
    String name;
    int age;

    public User(String name) {
        this.name = name;
        //this.age = age;
    }

    public void getName() {
        System.out.println(name);
    }

    public int getAge() {
        return age;
    }
}

class User2 {
    String name;
    int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getName() {
        System.out.println(name);
    }

    public int getAge() {
        return age;
    }
}
