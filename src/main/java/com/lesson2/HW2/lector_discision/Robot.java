package com.lesson2.HW2.lector_discision;

public class Robot implements Contestant {
    int runLimit;
    int jumpLimit;

    public Robot(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean run(int runDistance) {
        if(runDistance<0) {
            System.out.println(this.toString() + " can't run backward");
            return false;
        } else if(runDistance>runLimit) {
            System.out.println(this.toString() + " не смог пробежать это расстояние");
            return false;
        } else {
            System.out.println(this.toString() + " успешно пробежал дистанцию");
            return true;
        }
    }

    @Override
    public boolean jump(int jumpDistance) {
        if(jumpDistance<0) {
            System.out.println(this.toString() + " не может прыгать вниз");
            return false;
        } else if(jumpDistance>jumpDistance) {
            System.out.println(this.toString() + " не смог перепрыгнуть это перпятствие");
            return false;
        } else {
            System.out.println(this.toString() + " успешно перепрыгнул");
            return true;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
