package com.lesson2.HW2.my_discision;

public abstract class AliveObject implements Action{
     int runLimit;
     int jumpLimit;

    public AliveObject(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void doAction(Obstacle[] obstacles) {
       if(run((Treadmill) obstacles[0])) {
           jump((Wall) obstacles[1]);
       }
    }

    public boolean run(Treadmill treadmill) {
        if(this.runLimit < treadmill.getLength()) {
            System.out.println(getClass().getSimpleName() + " не смог добежать");
            return false;
        } else {
            System.out.println(getClass().getSimpleName() + " успешно пробежал");
            return true;
        }
    }

    public void jump(Wall wall) {
        if(this.jumpLimit < wall.getHeight()) {
            System.out.println(getClass().getSimpleName() + " не смог перепрыгнуть");
        } else {
            System.out.println(getClass().getSimpleName() + " успешно перепрыгнул");
        }
    }
}
