package com.lesson4.myHW;

public class Test1 {

    public static class Box <T> {
        //твой код здесь
        private T object;

        public static <T> Box <T> getBox() {
            return new Box<T>();
        }
    }
}


