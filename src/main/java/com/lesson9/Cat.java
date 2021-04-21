package com.lesson9;

public class Cat {
    public int publicField;
    int defaultField;
    private int privateField;
    protected int protectedField;

    public Cat(int publicField, int defaultField, int privateField, int protectedField) {
        this.publicField = publicField;
        this.defaultField = defaultField;
        this.privateField = privateField;
        this.protectedField = protectedField;
    }

    public void publicMeow() {
        System.out.println("publicMeow");
    }

    private void privateMeow() {
        System.out.println("privateMeow");
    }
}
