package com.lesson3.lectureHW3;

public class MyArrayDataException extends MyException {

    public MyArrayDataException(int column, int row) {
        super("Ошибка данных:" + "column-" + column + " : " + "row-" + row);
    }
}
