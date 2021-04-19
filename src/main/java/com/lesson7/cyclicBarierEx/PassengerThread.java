package com.lesson7.cyclicBarierEx;

import java.util.concurrent.CyclicBarrier;

public class PassengerThread extends Thread {
    private int duration;
    private CyclicBarrier barrier;

    public PassengerThread(int duration, CyclicBarrier barrier, String pname) {
        super(pname);
        this.duration = duration;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " is arrived.");

            int await = 0;
            try {
                await = barrier.await();
            } catch (java.util.concurrent.BrokenBarrierException e) {
                e.printStackTrace();
            }
            if(await == 0) {
                System.out.println("Four passengers have arrived so cab is going to start..");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

