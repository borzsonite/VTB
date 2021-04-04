package com.lesson2.Enums;

public enum Colors {
    RED("Красный"), ORANGE("Оранжевый"), YELLOW("Желтый"), GREEN("Зеленый"), BLUE("Голубой"), VIOLET("Фиолетовый");

    String translation;

    Colors(String translation) {
        this.translation = translation;
    }

    String getTranslation() {
        return translation;
    }
}

class Runner {
    public static void main(String[] args) {
        System.out.println(Colors.ORANGE + ":" + Colors.ORANGE.getTranslation());
        System.out.println(Colors.valueOf("RED"));

    }
}
