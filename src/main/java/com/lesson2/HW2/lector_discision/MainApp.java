package com.lesson2.HW2.lector_discision;

import com.lesson1.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * У препятствия есть метод contest() в который передается участник
 * */

public class MainApp {
    public static void main(String[] args) {

        List<Contestant> contestants = new ArrayList<>();
        contestants.add(new Cat(1000, 2));
        contestants.add(new Human(2000, 1));
        contestants.add(new Robot(5000, 10));

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Treadmill(1500));
        obstacles.add(new Wall(2));

        for(Contestant contestant: contestants) {
            for(Obstacle obstacle: obstacles) {
                if(!obstacle.contest(contestant)) {
                    break;
                }
            }
        }
    }

}
