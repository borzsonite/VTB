package com.lesson7.homework;

import java.util.concurrent.Semaphore;

import static com.lesson7.homework.MainClass.CARS_COUNT;

public class Tunnel extends Stage {
    private static Semaphore semaphore = null;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        semaphore = new Semaphore(CARS_COUNT/2);
    }

    @Override
    public void go(Car c) {
        try {
            try {
                semaphore.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +
                        description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
