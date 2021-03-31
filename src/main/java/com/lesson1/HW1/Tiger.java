package com.lesson1.HW1;

public class Tiger extends Animal{
    static int count;

    public Tiger(String name) {
        this.name = name;
        this.runLimit = 1000;
        this.swimLimit = 500;
        count++;
    }

    @Override
    void run(int distance) {
        if(distance > runLimit) {
            System.out.println("Tiger " + name + " can't run so far");
            return;
        }
        System.out.println("Tiger " + name + " swam "+ distance);
    }

    @Override
    void swim(int distance) {
        if(distance > swimLimit) {
            System.out.println("Tiger " + name + " can't swim so far");
            return;
        }
        System.out.println("Tiger " + name + " swam "+ distance);
    }

    static int getCount() {
        return count;
    }
}
