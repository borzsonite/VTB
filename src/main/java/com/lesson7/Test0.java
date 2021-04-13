package com.lesson7;

public class Test0 {
    public static Integer mon = 1;
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (mon) {
                System.out.println("1 start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1 end");
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                System.out.println("2 start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2 end");
            }
        }).start();

        new Thread(() -> {
            synchronized (mon) {
                System.out.println("3 start");
                mon++;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3 end");
            }
        }).start();
    }
}
