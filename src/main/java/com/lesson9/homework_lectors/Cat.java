package com.lesson9.homework_lectors;

@Table(title = "cats")
public class Cat {
    @Column(value = "id")
    int id;
    @Column(value = "name")
    String name;
    @Column(value = "age")
    int age;

    public Cat(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
