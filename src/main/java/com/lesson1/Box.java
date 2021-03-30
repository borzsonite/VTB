package com.lesson1;

public class Box {
    private String color;
    private int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public static void main(String[] args) {
        Box box1 = new Box("Green", 5);
        Box box2 = new Box("Green", 6);
        System.out.println(box1.equals(box2));
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof Box)) {
            return false;
        }
        Box another = (Box)object;
        if(this.color.equals(another.color) && this.size == another.size) {
            return true;
        }
        return false;
    }
}
