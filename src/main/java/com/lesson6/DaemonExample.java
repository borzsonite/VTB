package com.lesson6;

import sun.awt.windows.ThemeReader;

public class DaemonExample {
    public static void main(String[] args) {
        Thread timer = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while(true) {
                    System.out.println("time:" + count++);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //timer.setDaemon(true);
        timer.start(); // Процесс демон будет работать пока работает хоть один обычный процесс. Как только все обычные процессы завершены демон тоже завершается.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread ended");
    }
}
