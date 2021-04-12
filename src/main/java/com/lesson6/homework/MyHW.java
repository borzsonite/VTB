package com.lesson6.homework;

import java.util.Arrays;

public class MyHW {


    public static void main(String[] args) {
//        long start1 = System.currentTimeMillis();
//        method1();
//        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        method2();
        System.out.println(System.currentTimeMillis() - start2);
    }

    public static void method1() {

        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
        System.out.println(arr[999999]);
    }

    public static void method2() {

        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        Arrays.fill(arr, 1);
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        }).start();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println(arr[999999]);
    }
}
