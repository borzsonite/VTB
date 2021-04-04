package com.lesson2;

public interface Flyable {
    default void fly() {
        System.out.printf("fly");
    }
}
