package com.lesson2.repeat.lesson1;

public class Moto implements Drive{
    @Override
    public void start() {
        System.out.println("Moto gos!");
    }

    @Override
    public void stop() {
        System.out.println("Moto stops!");
    }
}

