package com.lesson2.DanceInterfaceExample;

import java.util.Locale;

public class MainApp {
    public static void main(String[] args) {
        Human human = new Human();
        human.startWrite(new Pen());
        human.stopWrite();
        human.startWrite(new Keyboard());
        human.startWrite(new Pencil());
        human.stopWrite();

    }

   static class Human {

        Write currentWritingTool;

        void startWrite(Write writingTool) {
            writingTool.write();
            currentWritingTool = writingTool;
        }

        void stopWrite() {
            if(currentWritingTool != null) {
                System.out.println("Human stopped writing by " + currentWritingTool.getClass().getSimpleName().toLowerCase(Locale.ROOT));
                currentWritingTool = null;
            }

        }
    }

    static class Pen implements Write {

        @Override
        public void write() {
            System.out.println("Human writes by pen");
        }
    }

    static class Keyboard implements Write {

        @Override
        public void write() {
            System.out.println("Human writes on keyboard");
        }
    }

    static class Pencil implements Write {

        @Override
        public void write() {
            System.out.println("Human writes by pencil");
        }
    }

}
