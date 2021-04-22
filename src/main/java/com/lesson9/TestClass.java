package com.lesson9;

public class TestClass {

    @MyAnnotation(priority = 10)
    static void method1() {
        System.out.println("Method 1");
    }

    @MyAnnotation(priority = 7)
    static void method2() {
        System.out.println("Method 2");
    }

    @MyAnnotation(priority = 3)
    static void method3() {
        System.out.println("Method 3");
    }
}
