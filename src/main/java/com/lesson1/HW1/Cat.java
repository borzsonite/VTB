package com.lesson1.HW1;

public class Cat extends Animal{
    static int count;

    public Cat(String name) {
        this.name = name;
        this.runLimit = 200;
        this.swimLimit = 0;
        count++;
    }

    @Override
    void run(int distance) {
        if(distance > runLimit) {
            System.out.println("Cat " + name +  " can't run so far");
            return;
        }
        System.out.println("Cat " + name + " ran "+ distance);

    }

    @Override
    void swim(int distance) {
        if(distance > swimLimit) {
            System.out.println("Cat " + name + " can't swim so far");
            return;
        }
        System.out.println("Cat " + name + " swam "+ distance);
    }

    static int getCount() {
        return count;
    }
}
