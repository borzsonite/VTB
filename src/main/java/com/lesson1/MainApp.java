package com.lesson1;

public class MainApp {
    public static void main(String[] args) {
        Dog dog = new Dog("Sharik", "Black", 4);
        Animal animal = new Dog("Bobik", "White", 2);

        dog.helloFromAnimal();
        dog.helloFromDog();

        animal.helloFromAnimal();
        ((Dog)animal).helloFromDog();

    }
}
