package com.lesson1.HW1;

public abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;


    abstract void  run(int distance);
    abstract void swim(int distance);

}
