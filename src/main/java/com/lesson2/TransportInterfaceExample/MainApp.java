package com.lesson2.TransportInterfaceExample;

/**
 1. Человек хочет поехать, он может ехать на машине, автобусе, скейте.
 2. Способность ехать на чем то описывается интерфейсом Транспорт.
 3. У всех кто имплементирует интерфейс Транспорт должно быть два метода: Ехать() и Остановиться()
 4. У человека,  который хочет воспользоваться интерфесом Транспорт есть методы принимающие объеты имплиментирующие этот интерфейс (Машину, Автобус)

 Т.е. можно произвести какое-то действие с помощью разных инструментов. Например писать. Писать можно ручкой, на клавиатуре, карандашом.
 У человека есть метод писать в который передается параметр (ручка, клавиатура, карандаш). Ручка, клавиатура, карандаш пишут по разному, соответственно метод "писать" у них реализован по-разному. Но они все пишут, т.е. реализуют интерфейс "Писать" в котором есть метод "писать"

 */

public class MainApp {

    public static void main(String[] args) {
        Human human = new Human();
        Transport car = new Car();

        human.drive(car);
        human.stop();
        human.drive(new Skate());

    }
    
    static class Human {
        private Transport currentTransport;

        public void drive(Transport transport) {
            this.currentTransport = transport;
            transport.start();
        }

        public void stop() {
            if (this.currentTransport != null) {
                currentTransport.stop();
                currentTransport = null;
            } else {
                System.out.println("Пока никуда не еду");
            }
        }
    }

    static class Car implements Transport {

        @Override
        public void start() {
            System.out.println("Машина поехала");
        }

        @Override
        public void stop() {
            System.out.println("Машина остановилась");
        }
    }

    static class Bicycle implements Transport {

        @Override
        public void start() {
            System.out.println("Велосипед поехал");
        }

        @Override
        public void stop() {
            System.out.println("Велосипед остановился");
        }
    }

    static class Skate implements Transport {

        @Override
        public void start() {
            System.out.println("Скейт поехал");
        }

        @Override
        public void stop() {
            System.out.println("Скейт остановился");
        }
    }
}
