package com.lesson4;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        GenBox<String> stringGenBox = new GenBox<>("Java");
        GenBox<Integer> integerGenBox = new GenBox<>(1);
        System.out.println(stringGenBox.getObj());

        GeneralBoх<Integer> intBox = new GeneralBoх<>(1, 2, 3, 4);
        GeneralBoх<Double> dblBox = new GeneralBoх<Double>(1.0, 2.0, 3.0, 4.0);
        System.out.println(intBox.average());
        System.out.println(dblBox.average());;
    }
}

class GenBox<T> {
    T obj;

    public GenBox(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

//    void doSomething() {
//        T obj = new T();
//    }
}

class GeneralBoх<T extends Number> {
    private T[] data;

    public GeneralBoх(T... data) {
        this.data = data;
    }

   double average () {
        double avg = 0.0;
        for(int i=0; i<data.length; i++) {
            avg += data[i].doubleValue();
        }
        return avg/data.length;
   }
}
