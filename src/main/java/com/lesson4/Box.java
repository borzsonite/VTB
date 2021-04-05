package com.lesson4;

public class Box implements Comparable<Box> {
    private int size;

    public Box(int size) {
        this.size = size;
    }


    @Override
    public int compareTo(Box o) {
        return this.size - o.size;
    }
}

class BoxRunner {
    public static void main(String[] args) {
        Box b1 = new Box(100);
        Box b2 = new Box(10);
        System.out.println(b2.compareTo(b1));
    }
}
