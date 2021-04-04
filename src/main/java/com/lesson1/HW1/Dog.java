package com.lesson1.HW1;

public class Dog extends Animal{
    static int count;

    public Dog(String type, String name, int runLimit, int swimLimit) {
        super(type, name, runLimit, swimLimit);
        count++;
    }
}
