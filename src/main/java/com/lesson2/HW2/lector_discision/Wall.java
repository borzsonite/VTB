package com.lesson2.HW2.lector_discision;

public class Wall implements Obstacle{
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.jump(height)) {
            return true;
        } else {
            return false;
        }
    }
}
