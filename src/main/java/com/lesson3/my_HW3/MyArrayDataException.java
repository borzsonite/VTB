package com.lesson3.my_HW3;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(int column, int row) {
        super("Ошибка данных:" + "column-" + column + " : " + "row-" + row);
    }
}
