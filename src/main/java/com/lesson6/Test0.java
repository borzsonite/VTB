package com.lesson6;

import sun.java2d.loops.GraphicsPrimitive;

public class Test0 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        t.start();
    }
}
