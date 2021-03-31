package com.lesson1.HW1;

public abstract class Animal {
    String type;
    String name;
    int runLimit;
    int swimLimit;
    static int count;

    public Animal(String type, String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.type = type;
        count++;
    }

    void run(int distance) {
        if (runLimit == 0) {
            System.out.println(type + " " + name + " не умеет бегать");
        } else if (distance > runLimit) {
            System.out.println(type + " " + name + " не может бежать так далеко ");
        } else if (distance < runLimit) {
            System.out.println(type + " " + name + " успешно пробежал " + distance);
        }

    }

    void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(type + " " + name + " не умеет плавть");
        } else if (distance > swimLimit) {
            System.out.println(type + " " + name + " не может плыть так далеко ");
        } else if (distance < swimLimit) {
            System.out.println(type + " " + name + " успешно проплыл " + distance);
        }
    }


}
