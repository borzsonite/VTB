package com.lesson7;

import java.util.Collections;

public class TempApp {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            int finalI = i;
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}

