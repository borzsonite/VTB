package com.lesson1.HW1;

public class Tiger extends Animal{
    int runLimit = 1000;
    int swimLimit = 500;

    @Override
    void run(int distance) {
        if(distance > runLimit) {
            System.out.println("Can't run so far");
        }
        System.out.printf("Tiger ran "+ distance);
    }

    @Override
    void swim(int distance) {
        if(distance > swimLimit) {
            System.out.println("Can't swim so far");
        }
        System.out.printf("Tiger swam "+ distance);
    }
}
