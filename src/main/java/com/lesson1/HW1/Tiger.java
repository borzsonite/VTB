package com.lesson1.HW1;

public class Tiger extends Cat{
    static int count;

    public Tiger(String name, int runLimit, int swimLimit) {
        super("Тигр", name, runLimit, swimLimit);
        count++;
    }
}
