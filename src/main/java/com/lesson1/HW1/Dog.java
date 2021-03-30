package com.lesson1.HW1;

public class Dog extends Animal{
    int runLimit = 500;
    int swimLimit = 10;

    @Override
    void run(int distance) {
        if(distance > runLimit) {
            System.out.println("Can't run so far");
        }
        System.out.printf("Dog ran "+ distance);
    }

    @Override
    void swim(int distance) {
        if(distance > swimLimit) {
            System.out.println("Can't swim so far");
        }
        System.out.printf("Dog swam "+ distance);
    }
}
