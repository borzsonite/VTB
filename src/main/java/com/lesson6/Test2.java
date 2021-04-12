package com.lesson6;

public class Test2 {
static private int c1 = 0;
static private int c2 = 0;
private static Object lock1 = new Object();
private static Object lock2 = new Object();


    public static void main(String[] args) throws InterruptedException {

   Thread t1 =  new Thread(()-> {
        for(int i=0; i<100; i++) {
            inc1();
        }
    });


   Thread t2 = new Thread(()-> {
            for(int i=0; i<100; i++) {
                dec1();
            }
        });

     Thread t3 = new Thread(()-> {
            for(int i=0; i<100; i++) {
                inc2();
            }
        });

      Thread t4 = new Thread(()-> {
            for(int i=0; i<100; i++) {
                dec2();
            }
        });
      t1.start();
      t2.start();
      t3.start();
      t4.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.join();
      t3.join();
      t4.join();

        System.out.println(c1);
        System.out.println(c2);

    }

    static void inc1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " in inc1 is working");
            c1++;
        }

    }

    static void dec1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " in dec1 is working");
            c1--;
        }

    }

    static void inc2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " in inc2 is working");
            c2++;
        }

    }

    static void dec2() {
        synchronized (lock2)
        {
            System.out.println(Thread.currentThread().getName() + " in dec1 is working");
            c2--;
        }

    }

}
