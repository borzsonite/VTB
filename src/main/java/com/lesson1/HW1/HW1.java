package com.lesson1.HW1;
/**
 Практическое задание
 1. Создать классы Собака, Домашний Кот, Тигр, Животное (можете добавить два-три своих
 класса).
 2. Животные могут бежать и плыть. В качестве аргумента каждому методу передается длина
 препятствия.
 3. У каждого животного есть ограничения на действия (бег: кот — 200 м, собака — 500 м;
 плавание: кот — не умеет плавать, собака — 10 м). Результатом выполнения действия будет
 печать в консоль. Например: dogBobik.run(150); -> 'Бобик пробежал 150 м'.
 4. Создать один массив с животными и заставляете их по очереди пробежать дистанцию и
 проплыть.
 5. * Добавить подсчет созданных Домашних Котов, Тигров, Собак, Животных.
 * */

public class HW1 {
    public static void main(String[] args) {
        Animal[] animals = {new Dog("Bobik"), new Dog("Tuzik"), new Cat("Vaska"), new Tiger("Sharhan")};
        for(Animal animal: animals) {
            animal.run(300);
            animal.swim(10);
        }

        System.out.println("Dog's count: " + Dog.getCount());
        System.out.println("Cat's count: " + Cat.getCount());
        System.out.println("Tiger's count: " + Tiger.getCount());
    }
}
