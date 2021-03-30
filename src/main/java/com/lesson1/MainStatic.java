package com.lesson1;

public class MainStatic {
    static class A {
        int a;

        public A(int a) {
            this.a = a;
            System.out.println("В конструкторе А " + a);
        }
    }

    static class B extends A {
        int b;

        public B(int a) {
            super(a);
            System.out.println("В конструкторе В " + b);
            System.out.println("В конструкторе В " + super.a);
        }

        void info() {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        B b = new B(10);
        b.info();
    }
}
