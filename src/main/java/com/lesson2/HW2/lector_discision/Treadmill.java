package com.lesson2.HW2.lector_discision;

public class Treadmill implements Obstacle{
    int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.run(length)) {
            return true;
        } else {
            return false;
        }
 }
}
