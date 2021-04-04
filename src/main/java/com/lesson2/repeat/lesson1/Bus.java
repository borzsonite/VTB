package com.lesson2.repeat.lesson1;

public class Bus implements Drive{
    @Override
    public void start() {
        System.out.println("Bus gos!");
    }

    @Override
    public void stop() {
        System.out.println("Bus stops!");
    }
}
