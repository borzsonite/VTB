package com.lesson1.HW1;

public abstract class Cat extends Animal{
    int count;

    public Cat(String type, String name, int runLimit, int swimLimit) {
        super(type, name, runLimit, swimLimit);
        count++;
    }
}
