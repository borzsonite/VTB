package com.lesson3.lectureHW3;

public class MyException extends Throwable {
    public MyException() {

    }

    public MyException(String message) {
        super(message);
    }

    public MyException(int column, int row) {
        super("Ошибка данных! " + "column: " + column + " row: " + row);
    }
}
