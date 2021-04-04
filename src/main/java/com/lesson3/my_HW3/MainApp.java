package com.lesson3.my_HW3;

/**
 * 1. Создайте исключения: MyArraySizeException (неправильный размер массива), и
 * MyArrayDataException (в ячейке массива лежит что-то не то);
 * <p>
 * 2. Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером
 * 4×4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 3. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
 * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
 * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные. Расчет
 * данных для этой матрицы прекращается.
 * <p>
 * 4. В методе main() нужно вызвать полученный метод, обработать возможные исключения
 * MySizeArrayException и MyArrayDataException и вывести результат расчёта.
 * Заметка : для преобразования строки в число можно использовать метод класса Integer:
 * Integer. valueOf ( "1" )
 */

public class MainApp {

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"},
        };

        try {
            System.out.println(arrayChecker(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int arrayChecker(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int i = 0;
        int j = 0;
        int sum = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                try{
                    sum += Integer.valueOf(arr[i][j]);
                } catch(NumberFormatException e) {
                    throw new MyArrayDataException(i+1, j+1);
                }
            }
            if (j != 4) {
                throw new MyArraySizeException();
            }
        }
        if (i != 4) {
            throw new MyArraySizeException();
        }
        return sum;
    }
}
