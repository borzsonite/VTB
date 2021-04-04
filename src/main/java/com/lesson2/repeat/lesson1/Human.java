package com.lesson2.repeat.lesson1;

public class Human {
    Drive currentVeecle;

    public Human() {
    }

    void startMoving(Drive drive) {
        this.currentVeecle = drive;
        drive.start();
    }

    void stopMoving(Drive drive) {
        if(drive.getClass() == currentVeecle.getClass()) {
            drive.stop();
            return;
        }
        System.out.println("Я никуда не еду!");
    }
}
