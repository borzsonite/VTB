package com.lesson2.repeat.lesson1;
/**
Задачча есть класс человек и классы машина, скейт, мотоцикл. Человек может ехать посредством этих ТС.
Есть действие которое можно выолнить несколькими разными способами, например ехать можно на машине, автобусе, самокате.
Для абстрактного действия "ехать" заводится интерфейс с методом описывающим это действие, например методк ехать().
Классы которые представляют собой разные варианты выполнения езды: машина, автобус, самокат, имплементируют данный интерфейс
и переопределяют этот метод. У человека есть метод, в который параметром передаются класс стратегии и у него вызывается метод ехать
 * */


public class MainApp {
    public static void main(String[] args) {
        Human human = new Human();
        human.startMoving(new Car());
        human.stopMoving(new Moto());
    }
}