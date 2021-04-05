package com.lesson4;

import java.util.ArrayList;
import java.util.List;

public class GenBox2<T extends Number> {
  private  T[] data;

    public GenBox2(T... data) {
        this.data = data;
    }

    public double sum() {
        double sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i].doubleValue();
        }
        return sum;
    }

    public static <M extends Number> M doAction(List<M> list) {
        return list.get(0);
    }
}

class Runner {
    public static void main(String[] args) {
        GenBox2<Integer> gbx2 = new GenBox2<Integer>(1,2,3,4 );
        System.out.println(gbx2.sum());

        GenBox2<Integer>.doAction(new ArrayList<Integer>(1,2,3));
        List<Integer> myList = new ArrayList<Integer>(1,2,3);

    }
}