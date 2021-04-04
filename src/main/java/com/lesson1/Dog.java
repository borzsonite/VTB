package com.lesson1;

public class Dog extends Animal {

    public Dog(String name, String color, int age) {
        super(name, color, age);
    }

    public void helloFromDog() {
        System.out.println("Dog says hello");
    }
}
