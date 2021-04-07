package com.lesson4.myHW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3. Задача:
 * a. Даны классы Fruit -> Apple, Orange.
 * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
 * фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины.
 * <p>
 * c. Для хранения фруктов внутри коробки можно использовать ArrayList.
 * <p>
 * d. Написать метод getWeight(), который высчитывает вес коробки. Задать вес одного
 * фрукта и их количество: вес яблока — 1.0f, апельсина — 1.5f (единицы измерения не
 * важны).
 * <p>
 * e. Внутри класса Box написать метод Compare, который позволяет сравнить текущую
 * коробку с той, которую подадут в Compare в качестве параметра. True, если их массы
 * равны, False — в противном случае. Можно сравнивать коробки с яблоками и
 * апельсинами.
 * <p>
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 * Помним про сортировку фруктов: нельзя высыпать яблоки в коробку с апельсинами.
 * Соответственно, в текущей коробке фруктов не остаётся, а в другую перекидываются
 * объекты, которые были в первой.
 * <p>
 * g. Не забываем про метод добавления фрукта в коробку.
 */

public class Fruit {
    final float WEIGHT;

    public Fruit(float weight) {
        WEIGHT = weight;
    }
}

class Apple extends Fruit {

    Apple() {
        super(1.0f);
    }
}

class Orange extends Fruit {
    Orange() {
        super(1.5f);
    }
}

class Box<T extends Fruit> implements Comparable<Box> {
    private List<T> storage = new ArrayList<>();


    public float getWeight() {
        float sum = 0;
        for (Fruit fruit : storage) {
            sum += fruit.WEIGHT;
        }
        return sum;
    }

    public void putIntoBox(T fruit) {
        storage.add(fruit);
    }

    @Override
    public int compareTo(Box o) {
        return Math.round(this.getWeight() - o.getWeight());
    }

    public boolean compare(Box o) {
        if (Math.abs(this.getWeight() - o.getWeight()) < 0.000001) {
            return true;
        }
        return false;
    }

    public void moveFruits(Box<T> box) {
        this.storage.addAll(box.storage);
        box.storage.clear();
    }
}

class AppRunner {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        System.out.println(appleBox.getWeight());

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.putIntoBox(new Apple());
        appleBox1.putIntoBox(new Apple());
        appleBox1.putIntoBox(new Apple());
        System.out.println(appleBox1.getWeight());

        appleBox.moveFruits(appleBox1);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.putIntoBox(new Orange());
        orangeBox.putIntoBox(new Orange());
        orangeBox.putIntoBox(new Orange());
        orangeBox.putIntoBox(new Orange());
        orangeBox.putIntoBox(new Orange());

       // appleBox.moveFruits(orangeBox);

        // System.out.println(orangeBox.getWeight());

       // System.out.println(appleBox.compareTo(orangeBox));
       // System.out.println(appleBox.compare(orangeBox));
    }
}


