package com.lesson2.repeat.lesson1;

public class Car implements Drive{
    @Override
    public void start() {
        System.out.println("Car gos!");
    }

    @Override
    public void stop() {
        System.out.println("Car stops!");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
