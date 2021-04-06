package com.lesson4.myHW;

import java.util.Arrays;
import java.util.List;

/**
 1. Написать метод, который меняет два элемента массива местами (массив может быть любого
 ссылочного типа).
 2. Написать метод, который преобразует массив в ArrayList.

 */

public class MainApp {
    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.swapElements(0,1,"a", "b", "c", "d");

        System.out.println( arrayToList(1,2,3));
        System.out.println( arrayToList("a", "b", "c", "d"));
    }

    public <T> void swapElements(int first, int second, T... data) {
        T temp = data[first];
        data[first] = data[second];
        data[second] = temp;
        System.out.println(Arrays.toString(data));
    }

    public static <T> List<? extends T> arrayToList(T...array) {
        return Arrays.asList(array);
    }
}
