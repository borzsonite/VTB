package com.lesson6;

public class Test1 {
    Object monitor = new Object();

    public static void main(String[] args) {
        Test1 monitor = new Test1();
        new Thread(() -> monitor.method()).start();
        new Thread(() -> monitor.method()).start();
        new Thread(() -> monitor.method()).start();

    }

    public void  method() {
        // non synchronized block
        System.out.println(Thread.currentThread().getName() + " non sync starts");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // synchronized block
        synchronized (monitor) {
            System.out.println(Thread.currentThread().getName() + " sync starts");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
