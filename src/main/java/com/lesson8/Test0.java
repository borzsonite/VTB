package com.lesson8;

public class Test0 {
    public static void main(String[] args) {
        doSomething(() -> {
            for(int i=0; i<5; i++) {
                System.out.println("Java");
            }
        });

        doSomething(() -> {
            System.out.println(100);
        });

    }

    static void doSomething(Runnable runnable) {
        runnable.run();
    }
}
