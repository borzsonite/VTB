package com.lesson1.HW1;

public class Dog extends Animal{
    static int count;

    public Dog(String name) {
        this.name = name;
        this.runLimit = 500;
        this.swimLimit = 10;
        count++;

    }

    @Override
    void run(int distance) {
        if(distance > runLimit) {
            System.out.println("Dog " + name +  " can't run so far");
            return;
        }
        System.out.println("Dog " + name + " ran "+ distance);
    }

    @Override
    void swim(int distance) {
        if(distance > swimLimit) {
            System.out.println("Dog " + name + " can't swim so far");
            return;
        }
        System.out.println("Dog " + name + " swam "+ distance);
    }

    static int getCount() {
        return count;
    }
}
