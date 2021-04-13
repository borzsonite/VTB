package com.lesson7;

import java.util.concurrent.*;

public class Test1 {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
//        for(int i = 0; i<20; i++) {
//            service.execute(new Runnable() { // .execute() ничего не возвращает
//                @Override
//                public void run() {
//                    System.out.println("Асинхронная задача: " + Thread.currentThread().getName());
//                }
//            });
//        }
//        service.shutdown();

//    Future future = service.submit(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("Hello from future...");
//        }
//    });
//
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        service.shutdown();

        Future future = service.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("Hello from future");
                return "Result from thread";
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
