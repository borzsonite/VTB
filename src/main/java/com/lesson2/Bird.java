package com.lesson2;

public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.printf("overriden fly");
    }
}
