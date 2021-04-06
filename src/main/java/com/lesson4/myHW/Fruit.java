package com.lesson4.myHW;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. Задача:
 a. Даны классы Fruit -> Apple, Orange.
 b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
 фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины.
 c. Для хранения фруктов внутри коробки можно использовать ArrayList.
 d. Написать метод getWeight(), который высчитывает вес коробки. Задать вес одного
 фрукта и их количество: вес яблока — 1.0f, апельсина — 1.5f (единицы измерения не
 важны).
 e. Внутри класса Box написать метод Compare, который позволяет сравнить текущую
 коробку с той, которую подадут в Compare в качестве параметра. True, если их массы
 равны, False — в противном случае. Можно сравнивать коробки с яблоками и
 апельсинами.
 f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 Помним про сортировку фруктов: нельзя высыпать яблоки в коробку с апельсинами.
 Соответственно, в текущей коробке фруктов не остаётся, а в другую перекидываются
 объекты, которые были в первой.
 g. Не забываем про метод добавления фрукта в коробку.
 * */

public class Fruit{
    final float WEIGHT;

    public Fruit(float weight) {
        WEIGHT = weight;
    }
}

class Apple extends Fruit {

    Apple() {
        super(1.0f);
    }

    public float getWeight() {
        return WEIGHT;
    }

}

class Orange extends Fruit {
    Orange() {
        super(1.5f);
    }
}

class Box<T extends Fruit> {
    private List<T> box = new ArrayList<>();
    private float sum = 0;

    public float getWeight() {
        for(Fruit fruit: box) {
            sum += fruit.WEIGHT;
        }
        return sum;
    }

    public void putIntoBox(T fruit) {
        box.add(fruit);
    }
}

class AppRunner {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        appleBox.putIntoBox(new Apple());
        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.putIntoBox(new Orange());
        orangeBox.putIntoBox(new Orange());
        orangeBox.putIntoBox(new Orange());
        orangeBox.putIntoBox(new Orange());
        System.out.println(orangeBox.getWeight());
    }
}
