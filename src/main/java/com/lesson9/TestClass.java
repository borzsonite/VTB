package com.lesson9;

public class TestClass {

    @MyAnnotation
    static void method1() {
        System.out.println("Method 1");
    }

    static void method2() {
        System.out.println("Method 2");
    }

    @MyAnnotation
    static void method3() {
        System.out.println("Method 3");
    }
}
