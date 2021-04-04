package com.lesson3;

public class MainApp {
    public static void main(String[] args) {
        b();
    }

    public static void b() {
        a();
    }

    public static void a() {
        int x = 0;
        System.out.println(x/0);
    }
}
